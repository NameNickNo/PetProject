package com.example.WebApp.person.controller;

import com.example.WebApp.purchase.model.Purchase;
import com.example.WebApp.purchase.service.PurchaseService;
import com.example.WebApp.purchase.service.PurchaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonControllerTest {
    @Mock
    private PurchaseServiceImpl purchaseService;


    @Test(expected = NullPointerException.class)
    public void lo() {
        List<Purchase> list = purchaseService.findAll();
        Purchase purchase = purchaseService.findById(9);
        assertEquals(list.get(2), purchase );
    }

}