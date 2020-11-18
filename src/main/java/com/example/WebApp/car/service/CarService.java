package com.example.WebApp.car.service;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car findById(Integer id) {
        return carRepository.getOne(id);
    }
}
