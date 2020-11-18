package com.example.WebApp.person.service;

import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(int id) {
        return personRepository.getOne(id);
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
