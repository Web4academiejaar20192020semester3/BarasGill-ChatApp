package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Comment;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value= "/blog")
public class Blog {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private static final List<Comment> comments = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String commentToSend) throws IOException {
        addComment(commentToSend);
    }

    private void addComment(String commentToSend) throws IOException {
        JsonNode mapper = new ObjectMapper().readTree(commentToSend);
        Comment comment = new Comment(
                mapper.get("topicId").asInt(),
                mapper.get("name").asText(),
                mapper.get("commentText").asText(),
                mapper.get("rating").asInt(),
                mapper.get("guid").asText());
        comments.add(comment);
        sendCommentsToAll();
    }

    private void sendCommentsToAll(){
        for(Session s : sessions){
            try {
                s.getBasicRemote().sendText(toJSON((ArrayList<Comment>) comments));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String toJSON (ArrayList<Comment> comments) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(comments);
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Chat " +session.getId()+" has ended");
        sessions.remove(session);
    }
}
