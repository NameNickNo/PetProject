package com.example.WebApp.store.service;

import com.example.WebApp.store.model.Store;
import com.example.WebApp.store.repository.StoreRepository;


public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


}
