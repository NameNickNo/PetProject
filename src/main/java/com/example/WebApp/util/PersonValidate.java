package com.example.WebApp.util;

import com.example.WebApp.model.Person;
import com.example.WebApp.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PersonValidate implements Validator {

    @Qualifier("personServiceImpl")
    private final PersonService personService;

    public PersonValidate(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.findByEmail(person.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is already in use");
        }
    }
}
