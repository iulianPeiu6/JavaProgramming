package com.app.lab11_v2.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

public class PersonPopularity {
    private Long id;

    private String username;

    private Integer popularity;

    public PersonPopularity(Person person) {
        this.id = person.getId();
        this.username = person.getUsername();
        this.popularity =0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
