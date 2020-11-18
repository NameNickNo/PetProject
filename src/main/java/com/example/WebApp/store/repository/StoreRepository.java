package com.example.WebApp.store.repository;

import com.example.WebApp.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
