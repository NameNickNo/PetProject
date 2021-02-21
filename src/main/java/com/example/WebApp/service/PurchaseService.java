package com.example.WebApp.service;

import com.example.WebApp.model.Car;
import com.example.WebApp.model.Person;
import com.example.WebApp.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> findAll();

    Purchase findById(int id);

    void savePurchase(Purchase purchase);

    Purchase createPurchase(Car rentalCar, int rentalDays, Person person);

    Purchase getLastOrder();
}
