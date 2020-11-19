package com.example.WebApp.person.controller;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.service.CarService;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.service.PersonService;
import com.example.WebApp.purchase.model.Purchase;
import com.example.WebApp.purchase.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final CarService carService;
    private final PurchaseService purchaseService;

    public PersonController(PersonService personService, CarService carService, PurchaseService purchaseService) {
        this.personService = personService;
        this.carService = carService;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/rent/{id}")
    public String registration(Person person, Model model,
                               @PathVariable("id") int carId) {
        person.setNumber("+7");
        model.addAttribute("carId", carId);

        return "registration-page";
    }

    @PostMapping("/registration/{carId}")
    public String addPurchase(Person person, @PathVariable("carId") int id,
                              @RequestParam("rentalDays") int rentalDays) {
        System.out.println(id);
        personService.savePerson(person);
        System.out.println(person.toString());

        Car car = carService.findById(id);
        Purchase createdPurchase = purchaseService.createPurchase(car, rentalDays, person);
        purchaseService.savePurchase(createdPurchase);
        return "redirect:/car";
    }
}
