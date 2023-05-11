package com.gapht.restservice.answers;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class Answer {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;
    private UUID uuid;
    @Column(columnDefinition = "LONGTEXT")
    private String prompt;
    @Column(columnDefinition = "LONGTEXT")
    private String result;

    Answer() {}

    Answer(String prompt) {

        this.prompt = prompt;
    }

    public Integer getId() {
        return this.id;
    }

    public UUID getUuid() {
        if (this.uuid != null) {
            return this.uuid;
        }

        this.uuid = UUID.randomUUID();
        return this.uuid;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getResult() {
        return this.result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String give() {
        return "Here is your Answer " + this.prompt;
    }
}
