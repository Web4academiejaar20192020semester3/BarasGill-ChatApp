package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Person;
import domain.PersonService;


public class GetFriendsList extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        List<Person> friendsList = loggedInUser.getAllFriends();

        String friendListToJSON = this.personListToJSON(friendsList);
        response.setContentType("application/json");
        response.getWriter().write(friendListToJSON);
    }
}