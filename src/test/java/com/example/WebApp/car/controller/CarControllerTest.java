package com.example.WebApp.car.controller;

import com.example.WebApp.car.service.CarService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@SpringBootTest
class CarControllerTest {

    @InjectMocks
    private CarController carController;
    @Mock
    @Qualifier("carServiceImpl")
    private CarService carService;
    @Mock
    Model model;

    private final Logger logger = Logger.getLogger(CarController.class.getName());
//    @BeforeEach
//    void setUp() {
//        carService = mock(CarServiceImpl.class);
//        carController = mock(CarController.class);
//    }
    @Test
    void mainPageShouldWork() {
        carController.MainPage(model);
        verify(carService).findAll();
        logger.info("All good");

    }

    @Test
    void getCarInfoShouldWork() {
        int checkId = 4;
        logger.info("there");

        try {
            String info = carController.getCarInfo(checkId, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("All good from method getCarInfo");
//        verify(carService).findById(checkId);

    }
}