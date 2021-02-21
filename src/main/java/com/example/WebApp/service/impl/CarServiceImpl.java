package com.example.WebApp.service.impl;

import com.example.WebApp.model.Car;
import com.example.WebApp.repository.CarRepository;
import com.example.WebApp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(int id) {
        return carRepository.getOne(id);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

}
