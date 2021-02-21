package com.example.WebApp.service.impl;

import com.example.WebApp.model.Car;
import com.example.WebApp.model.Person;
import com.example.WebApp.model.Purchase;
import com.example.WebApp.repository.PurchaseRepository;
import com.example.WebApp.model.Store;
import com.example.WebApp.repository.StoreRepository;
import com.example.WebApp.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final StoreRepository storeRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, StoreRepository storeRepository) {
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

    public Purchase getLastOrder() {
        List<Purchase> orders = purchaseRepository.findAll();//тоже протестировать
        Purchase lastOrder = orders.get(orders.size() - 1);
        return lastOrder;
    }

}
