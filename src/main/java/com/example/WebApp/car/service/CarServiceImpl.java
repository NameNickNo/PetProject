package com.example.WebApp.car.service;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(int id) {
        return carRepository.getOne(id);
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

}
