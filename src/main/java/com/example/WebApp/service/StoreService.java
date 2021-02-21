package com.example.WebApp.service;

import com.example.WebApp.repository.StoreRepository;


public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


}
