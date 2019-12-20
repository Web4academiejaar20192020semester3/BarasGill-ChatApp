package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        String newFriendUserId = request.getParameter("newFriend");
        Person newFriend = service.getPerson(newFriendUserId);

        if (loggedInUser.getAllFriends().contains(newFriend)) {
            throw new IllegalArgumentException("You are already friends with this person");
        }
        else
        {
            service.addFriend(newFriend, loggedInUser);
        }
    }
}
