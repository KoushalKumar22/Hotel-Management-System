package com.UserMicroServices.Registration_Service.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "personal_details") // Set table name specifically for users
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    private int id;
    @Column(name = "name",nullable = false)
    @NotBlank(message = "Please Provide An Name!")
    private String name;
    @Column(name = "Address",nullable = false)
    @NotEmpty(message = "Address Cannot Be Empty!")
    private String address;
    @Column(name = "PhoneNo",unique = true,nullable = false)
    @NotEmpty(message = "Please Enter an Phone Number!")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Please Enter An Valid Phone Number!")
    String phone;

    // Constructors, getters, setters

    public PersonalDetails(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public PersonalDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
