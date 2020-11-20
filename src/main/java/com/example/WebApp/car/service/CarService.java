package com.example.WebApp.car.service;

import com.example.WebApp.car.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(int id);

    void saveCar(Car car);
}
