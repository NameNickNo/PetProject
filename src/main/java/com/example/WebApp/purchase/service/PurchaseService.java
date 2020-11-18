package com.example.WebApp.purchase.service;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.purchase.model.Purchase;
import com.example.WebApp.purchase.repository.PurchaseRepository;
import com.example.WebApp.store.model.Store;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(int id) {
        return purchaseRepository.getOne(id);
    }

    public void savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public Purchase createPurchase(Car rentalCar, int rentalDays, Person person) {
        LocalDate today = LocalDate.now();
        Store oneStore = new Store();
        Purchase createdPurchase = new Purchase();
        createdPurchase.setCar(rentalCar);
        createdPurchase.setPerson(person);
        createdPurchase.setRentalDays(rentalDays);
        createdPurchase.setDateOfPurchase(today);
        createdPurchase.setStore(oneStore);
        return createdPurchase;
    }
}
