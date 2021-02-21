package com.example.WebApp.service;

import com.example.WebApp.model.Car;

import java.util.List;


public interface CarService {
    List<Car> findAll();

    Car findById(int id);

    void saveCar(Car car);
}
