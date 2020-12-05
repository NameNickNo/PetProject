package com.example.WebApp.car.model;

import com.example.WebApp.purchase.model.Purchase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_car")
    private String numberOfCar;

    @Column(name = "price_per_day")
    private int price;

    @Column(name = "fhoto_url")
    private String photo;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<Purchase> purchaseList = new ArrayList<>();
}
