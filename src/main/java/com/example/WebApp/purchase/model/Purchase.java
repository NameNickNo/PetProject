package com.example.WebApp.purchase.model;


import com.example.WebApp.car.model.Car;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.store.model.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int id;

    @Column(name = "date_of_purchase")
    private LocalDate dateOfPurchase;

//    @Min(value = 1, message = "select number of days to rent")
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
