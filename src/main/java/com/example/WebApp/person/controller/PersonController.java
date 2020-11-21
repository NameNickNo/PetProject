package com.example.WebApp.person.controller;

import com.example.WebApp.car.model.Car;
import com.example.WebApp.car.service.CarService;
import com.example.WebApp.person.model.Person;
import com.example.WebApp.person.service.PersonService;
import com.example.WebApp.person.service.PersonServiceImpl;
import com.example.WebApp.purchase.model.Purchase;
import com.example.WebApp.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Qualifier("personServiceImpl")
    private final PersonService personService;
    @Qualifier("carServiceImpl")
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
    public String addPurchase(@Valid Person person, BindingResult bindingResult,
                              @PathVariable("carId") int id,
                              @RequestParam("rentalDays") int rentalDays) {
        System.out.println(id);
        System.out.println(person.toString());

        if (bindingResult.hasErrors()) {
            return "registration-page";
        }
        personService.savePerson(person);

        Car car = carService.findById(id);
        Purchase createdPurchase = purchaseService.createPurchase(car, rentalDays, person);
        purchaseService.savePurchase(createdPurchase);
        return "redirect:/person/order";
    }

    @GetMapping("/order")
    public String ordering(Model model) {
        List<Purchase> orders = purchaseService.findAll();//тоже протестировать
        Purchase lastOrder = orders.get(orders.size() - 1); //засунуть в метод и протестировать!
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

    @PostMapping("/deleteOrder")
    public String returnToRegistration(@ModelAttribute("lastOrder") Purchase deleteOrder) {
        int idOfCustomer = deleteOrder.getPerson().getId();//засунуть, протестировать
        purchaseService.deletePurchase(deleteOrder);
        personService.deleteById(idOfCustomer);

        return "redirect:/car";
    }
}
