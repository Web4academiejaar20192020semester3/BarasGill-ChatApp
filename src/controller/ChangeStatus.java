package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeStatus extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        Person loggedInUser = service.getPerson(userId);

        String currentStatus = loggedInUser.getStatus();
        String newStatus = request.getParameter("newStatus");

        if (newStatus != currentStatus && newStatus != null) {
            loggedInUser.setStatus(newStatus);
            response.setContentType("application/json");
            response.getWriter().write(newStatus);
        }
        else
        {
            throw new IllegalArgumentException("The new status is not valid");
        }
    }
}
