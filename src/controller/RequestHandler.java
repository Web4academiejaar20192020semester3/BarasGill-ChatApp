package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PersonService;
import domain.Person;
import domain.Role;

import java.io.IOException;
import java.util.List;

public abstract class RequestHandler {
	
	private PersonService personService;
	
	public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}


	public String personListToJSON (List<Person> friendList) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(friendList);
	}

	public String stringListToJSON (List<String> messages) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(messages);
	}

//	public String stringToJSON (String status) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.writeValueAsString(status);
//	}

}
