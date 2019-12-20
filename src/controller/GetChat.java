package controller;

import domain.Chat;
import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetChat extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        String contactPersonUserId = request.getParameter("contactPerson");
        Person contactPerson = service.getPerson(contactPersonUserId);

/*
        if (loggedInUser.getAllFriends().contains(contactPerson)) {
*/
            if (this.getPersonService().messages.isEmpty()) {
                Chat chat = new Chat(loggedInUser, contactPerson);
                chat.addMessage("This is a new chat");
                String chatToJson = this.stringListToJSON(chat.getMessages());
                response.setContentType("application/json");
                response.getWriter().write(chatToJson);
            } else {
                String chatToJson = this.stringListToJSON(this.getPersonService().messages);
                response.setContentType("application/json");
                response.getWriter().write(chatToJson);
            }
/*        } else {
            throw new IllegalArgumentException("You are not friends with this person");
        }*/
    }
}
