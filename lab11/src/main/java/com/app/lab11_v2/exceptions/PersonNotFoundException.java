package com.app.lab11_v2.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
        super("Could not find person with id=" + id);
    }
}
