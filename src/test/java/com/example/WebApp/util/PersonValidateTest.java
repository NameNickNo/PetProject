package com.example.WebApp.util;

import com.example.WebApp.model.Person;
import com.example.WebApp.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonValidateTest {

    @InjectMocks
    private PersonValidate personValidate;

    @Mock
    private PersonService personService;

    @Mock
    Person person;

    @Mock
    BindingResult bindingResult;

    @Test
    void validateTest() {
        personValidate.validate(person, bindingResult);
        verify(personService).findByEmail(person.getEmail());
    }
}
