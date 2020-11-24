package com.example.WebApp.person.service;

import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.repository.PersonRepository;
import com.example.WebApp.purchase.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

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
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
