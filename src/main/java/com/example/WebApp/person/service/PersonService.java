package com.example.WebApp.person.service;

import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(int id);

    void savePerson(Person person);

    void deleteById(int id);
}
