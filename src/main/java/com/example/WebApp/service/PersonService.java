package com.example.WebApp.service;

import com.example.WebApp.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(int id);

    void savePerson(Person person);

    Person findByEmail(String email);
}
