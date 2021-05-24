package com.app.lab11_v2.controllers;

import com.app.lab11_v2.exceptions.PersonNotFoundException;
import com.app.lab11_v2.models.Person;
import org.springframework.web.bind.annotation.*;
import com.app.lab11_v2.repositories.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/people")
    List<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/people/{id}")
    public Person one(@PathVariable Long id) {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping("/people")
    public Person newPerson(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

    @PutMapping("/people/{id}")
    Person updatePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return personRepository.findById(id)
                .map(person -> {
                    person.setUsername(newPerson.getUsername());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    @DeleteMapping("/people/{id}")
    void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
