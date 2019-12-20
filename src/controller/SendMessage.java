package controller;

import domain.Chat;
import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SendMessage extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        String contactPersonUserId = request.getParameter("contactPersonUserId");
        Person contactPerson = service.getPerson(contactPersonUserId);

        String message = request.getParameter("message");
        List<String> messages = this.getPersonService().messages;
        System.out.println("test:" + messages);
        if (loggedInUser.getAllFriends().contains(contactPerson) && contactPerson.getStatus() != "Offline" ) {
            messages.add(loggedInUser.getNickName() + ": " + message);
            response.setContentType("application/json");
        }
        else
        {
            throw new IllegalArgumentException("You are not friends with this person");
        }
    }
}
