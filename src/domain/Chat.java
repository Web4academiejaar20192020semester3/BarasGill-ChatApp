package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private Person person1, person2;
    public List<String> messages;

    public Chat(Person person1, Person person2) {
        setPerson1(person1);
        setPerson2(person2);
        messages = new ArrayList<>();
    }

    public Chat() {};

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public void addMessage(String message){
        if(message == null){
            throw new DomainException("The message is not valid");
        }
        this.messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
