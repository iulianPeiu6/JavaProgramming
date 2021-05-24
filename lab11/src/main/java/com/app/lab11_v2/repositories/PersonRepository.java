package com.app.lab11_v2.repositories;

import com.app.lab11_v2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
