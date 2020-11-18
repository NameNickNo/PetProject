package com.example.WebApp.car.controller;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getAll(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "main-page";
    }

    @GetMapping("/info/{id}")
    public String getInfo(@PathVariable("id") int id, Model model){
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "car-info";
    }


}
