package com.example.WebApp.service.impl;

import com.example.WebApp.model.Person;
import com.example.WebApp.repository.PersonRepository;
import com.example.WebApp.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.getOne(id);
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findByEmail(String email) {
        List<Person> people = findAll();
        return people.stream()
                .filter(person -> person.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }
}
