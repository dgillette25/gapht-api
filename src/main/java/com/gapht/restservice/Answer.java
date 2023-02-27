package com.gapht.restservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Answer {

  private @Id @GeneratedValue Long id;
  private String prompt;
  private String result;

  Answer() {}

  Answer(String prompt) {

    this.prompt = prompt;
  }

  public Long getId() {
    return this.id;
  }

  public String getPrompt() {
    return this.prompt;
  }

  public String getResult() {
    return this.result;
  }

  public void setId(Long id) {
    this.id = id;
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
