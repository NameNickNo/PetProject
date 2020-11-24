package com.example.WebApp.purchase.service;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.purchase.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> findAll();

    Purchase findById(int id);

    void savePurchase(Purchase purchase);

    Purchase createPurchase(Car rentalCar, int rentalDays, Person person);

    Purchase getLastOrder();
}
