package com.example.WebApp.purchase.service;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.purchase.model.Purchase;
import com.example.WebApp.purchase.repository.PurchaseRepository;
import com.example.WebApp.store.model.Store;
import com.example.WebApp.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final StoreRepository storeRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, StoreRepository storeRepository) {
        this.purchaseRepository = purchaseRepository;
        this.storeRepository = storeRepository;
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
        Store oneStore = storeRepository.getOne(1);
        Purchase createdPurchase = new Purchase();
        createdPurchase.setCar(rentalCar);
        createdPurchase.setPerson(person);
        createdPurchase.setRentalDays(rentalDays);
        createdPurchase.setDateOfPurchase(today);
        createdPurchase.setStore(oneStore);
        return createdPurchase;
    }
}
