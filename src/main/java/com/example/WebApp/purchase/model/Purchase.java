package com.example.WebApp.purchase.model;


import com.example.WebApp.car.model.Car;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.store.model.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_of_purchase")
    private LocalDate dateOfPurchase;

    @Column(name = "rental_days")
    private int rentalDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;
}
