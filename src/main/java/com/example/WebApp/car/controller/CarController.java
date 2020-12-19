package com.example.WebApp.car.controller;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.service.CarService;
import com.example.WebApp.purchase.model.Purchase;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Qualifier("carServiceImpl")
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String MainPage(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "main-page";
    }

    @GetMapping("/info/{id}")
    public String getCarInfo(@PathVariable("id") int id, Model model) throws NotFoundException {
        Car car = carService.findById(id);
        if (car == null) {
            throw new NotFoundException("Car is not found");
        }
        List<Purchase> purchases = car.getPurchaseList();
        model.addAttribute("car", car);
        model.addAttribute("purchases", purchases);
        return "car-info";
    }


}
