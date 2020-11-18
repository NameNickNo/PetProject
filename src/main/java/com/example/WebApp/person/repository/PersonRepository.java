package com.example.WebApp.person.repository;

import com.example.WebApp.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
