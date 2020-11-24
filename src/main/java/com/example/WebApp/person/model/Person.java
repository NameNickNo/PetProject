package com.example.WebApp.person.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "person")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @NotEmpty(message = "first name should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "middle name should not be empty")
    @Column(name = "middle_name")
    private String middleName;

    @Size(min = 12, max = 12, message = "number is not correct")
    @NotEmpty(message = "number shouldn't be empty")
    @Column(name = "number")
    private String number;

    @Column(name = "email")
    private String email;


    public Person(String firstName, String lastName, String middleName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.number = number;
    }
}
