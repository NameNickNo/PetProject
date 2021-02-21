package com.example.WebApp.controller;

import com.example.WebApp.model.Person;
import com.example.WebApp.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonControllerTest {

    @InjectMocks
    private PersonController controller;
    @Mock
    @Qualifier("personServiceImpl")
    private PersonService personService;

    private final Logger logger = Logger.getLogger(CarController.class.getName());


    @Mock
    private Model model;
    private Person person;

    @BeforeEach
    void setUp() {
        person = mock(Person.class);
    }

    @Test
    void registrationMethodTest() {
        int carId = 2;
        controller.registration(person, model, carId);
        verify(person).setNumber("+7");
        verify(model).addAttribute("carId", carId);
        logger.info("Test was successful");
    }

}