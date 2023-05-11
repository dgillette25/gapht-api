package com.gapht.restservice;

import java.util.ArrayList;
import java.util.List;

import com.gapht.restservice.chats.Message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;
    private String name;
    private String username;
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User id(Integer id) {
        setId(id);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }
}
