package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	public List<String> messages = new ArrayList<String>();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	public void changeStatus(String status, Person user){
		user.setStatus(status);
		getPersonRepository().update(user);
	}

	public String getStatus(Person user){
		return getPersonRepository().get(user.getUserId()).getStatus();
	}

	public void addFriend(Person friend, Person user) {
		getPersonRepository().get(user.getUserId()).addFriend(friend);
		getPersonRepository().get(friend.getUserId()).addFriend(user);
	}

	public void removeFriend(Person friend, Person user) {
		getPersonRepository().get(user.getUserId()).removeFriend(friend);
		getPersonRepository().get(friend.getUserId()).removeFriend(user);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
