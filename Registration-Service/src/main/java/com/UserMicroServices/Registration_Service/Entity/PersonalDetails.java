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
    @Column(name = "booking_id")
    private int bookingId;
    // Constructors, getters, setters
    public PersonalDetails(int id, String name, String address, int bookingId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookingId = bookingId;
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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
