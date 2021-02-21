package com.example.WebApp.controller;

import com.example.WebApp.model.Car;
import com.example.WebApp.service.CarService;
import com.example.WebApp.model.Person;
import com.example.WebApp.service.PersonService;
import com.example.WebApp.util.PersonValidate;
import com.example.WebApp.model.Purchase;
import com.example.WebApp.service.PurchaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.logging.Logger;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Qualifier("personServiceImpl")
    private final PersonService personService;
    @Qualifier("carServiceImpl")
    private final CarService carService;
    @Qualifier("purchaseServiceImpl")
    private final PurchaseService purchaseService;
    private final PersonValidate personValidate;

    private final Logger log = Logger.getLogger(CarController.class.getName());

    public PersonController(PersonService personService, CarService carService, PurchaseService purchaseService, PersonValidate personValidate) {
        this.personService = personService;
        this.carService = carService;
        this.purchaseService = purchaseService;
        this.personValidate = personValidate;
    }

    @GetMapping("/rent/{id}")
    public String registration(Person person, Model model,
                               @PathVariable("id") int carId) {
        person.setNumber("+7");
        model.addAttribute("carId", carId);

        return "registration-page";
    }

    @PostMapping("/registration/{carId}")
    public String createPurchase(@Valid Person person, BindingResult bindingResult,
                              @PathVariable("carId") int id,
                              @RequestParam("rentalDays") int rentalDays) {
        log.info(Integer.toString(id));
        log.info(person.toString());

        personValidate.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration-page";
        }
        personService.savePerson(person);

        Car rentalCar = carService.findById(id);
        Purchase createdPurchase = purchaseService.createPurchase(rentalCar, rentalDays, person);
        purchaseService.savePurchase(createdPurchase);
        return "redirect:/person/order";
    }

    @GetMapping("/order")
    public String ordering(Model model) {

        Purchase lastOrder = purchaseService.getLastOrder(); //засунуть в метод и протестировать!
        Car rentalCar = lastOrder.getCar();
        Person customer = lastOrder.getPerson();
        int rentPrice = rentalCar.getPrice() * lastOrder.getRentalDays();
        LocalDate startOfLease = lastOrder.getDateOfPurchase();
        LocalDate endOfLease = startOfLease.plusDays(lastOrder.getRentalDays());

        model.addAttribute("car", rentalCar);
        model.addAttribute("lastOrder", lastOrder);
        model.addAttribute("endDate", endOfLease);
        model.addAttribute("customer", customer);
        model.addAttribute("price", rentPrice);

        return "order-page";
    }
}
