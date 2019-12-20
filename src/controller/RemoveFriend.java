package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RemoveFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        String oldFriendUserId = request.getParameter("oldFriend");
        Person oldFriend = getPersonService().getPerson(oldFriendUserId);

        if (!loggedInUser.getAllFriends().contains(oldFriend)) {
            throw new IllegalArgumentException("You are not friends with this person");
        }
        else
        {
            service.removeFriend(oldFriend, loggedInUser);
        }
    }
}
