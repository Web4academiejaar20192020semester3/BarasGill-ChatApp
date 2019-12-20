package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetUsers extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        //response.setHeader("Access-Control-Allow-Methods", "GET");

        ObjectMapper mapper = new ObjectMapper();
        String usersToJson = "";
        try {
            usersToJson = mapper.writeValueAsString(getPersonService().getPersons());
            response.setContentType("application/json");
            response.getWriter().write(usersToJson);
        }catch (Exception e){
            usersToJson = mapper.writeValueAsString(new ArrayList<String>());
            response.setContentType("application/json");
            response.getWriter().write(usersToJson);
            e.printStackTrace();
        }
    }
}
