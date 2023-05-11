package com.gapht.restservice.chats;

import java.sql.Date;

import com.gapht.restservice.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;
    private String text;
    private Date created_at;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name="CHAT_ID")
    private Chat chat;


    public Message() {
    }

    public Message(Integer id, String text, Date created_at, User user, Chat chat) {
        this.id = id;
        this.text = text;
        this.created_at = created_at;
        this.user = user;
        this.chat = chat;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return this.chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Message id(Integer id) {
        setId(id);
        return this;
    }

    public Message text(String text) {
        setText(text);
        return this;
    }

    public Message createdAt(Date created_at) {
        setCreatedAt(created_at);
        return this;
    }

    public Message user(User user) {
        setUser(user);
        return this;
    }

    public Message chat(Chat chat) {
        setChat(chat);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", text='" + getText() + "'" +
            ", created_at='" + getCreatedAt() + "'" +
            ", user='" + getUser() + "'" +
            ", chat='" + getChat() + "'" +
            "}";
    }
   
}
