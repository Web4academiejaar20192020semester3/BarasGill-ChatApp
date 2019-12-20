package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String destination = "index.jsp";
            List<String> errors = new ArrayList<String>();

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String userId = request.getParameter("signUpEmail");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));
            String password = request.getParameter("signUpPassword");
            String repeatPassword = request.getParameter("repeatPassword");

            if ( !repeatPassword.isEmpty() && !password.isEmpty() && !userId.isEmpty() ) {
                if (password.equals(repeatPassword)) {
                    Person newPerson = new Person(userId, password, firstName, lastName, gender, age);
                    this.getPersonService().addPerson(newPerson);
                } else {
                    errors.add("The passwords do not match");
                }
            } else {
                errors.add("UserId or password(s) are invalid");
            }

            if (errors.size() > 0) {
                request.setAttribute("errors", errors);
            }

            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
    }
}
