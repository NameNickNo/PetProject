package com.example.WebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Size(min = 2, max = 30, message = "first name should between 2 and 30 chars")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    @Column(name = "last_name")
    @Size(min = 2, max = 30, message = "last name should between 2 and 30 chars")
    private String lastName;

    @NotEmpty(message = "middle name should not be empty")
    @Column(name = "middle_name")
    @Size(min = 2, max = 30, message = "middle name should between 2 and 30 chars")
    private String middleName;

    @Size(min = 12, max = 12, message = "number is not correct")
    @NotEmpty(message = "number shouldn't be empty")
    @Column(name = "number")
    private String number;

    @Column(name = "email")
    @Email(message = "email should be in the format of an email address")
    @NotEmpty
    private String email;

}
