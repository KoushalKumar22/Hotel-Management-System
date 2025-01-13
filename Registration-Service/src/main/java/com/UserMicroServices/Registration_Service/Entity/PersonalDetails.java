package com.UserMicroServices.Registration_Service.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_details") // Set table name specifically for users
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    // Constructors, getters, setters

    public PersonalDetails(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
}
