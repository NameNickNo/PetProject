package com.example.WebApp.person.controller;

import com.example.WebApp.car.controller.CarController;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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

    @Test
    void addPurchaseShouldSuccessful() {
        BindingResult bindingResult = mock(BindingResult.class);
        int checkedId = 2;
        int rentalDays = 2;
        controller.addPurchase(person, bindingResult, checkedId, rentalDays);
        verify(personService).savePerson(person);
    }
}