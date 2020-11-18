package com.example.WebApp.purchase.repository;

import com.example.WebApp.purchase.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
