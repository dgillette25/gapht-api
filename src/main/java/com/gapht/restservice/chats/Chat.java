package com.gapht.restservice.chats;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;
    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList<>();

    public Chat() {
    }

    public Chat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Chat id(Integer id) {
        setId(id);
        return this;
    }

    public Chat messages(List<Message> messages) {
        setMessages(messages);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", messages='" + getMessages() + "'" +
            "}";
    }
}
