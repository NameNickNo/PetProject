package com.example.WebApp.controller;

import com.example.WebApp.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@SpringBootTest
class CarControllerTest {

    @InjectMocks
    private CarController carController;
    @Mock
    private CarService carService;

    @Mock
    Model model;

    private final Logger logger = Logger.getLogger(CarController.class.getName());

    @Test
    void mainPageShouldWork() {
        carController.MainPage(model);
        verify(carService).findAll();
        logger.info("All good");

    }


}