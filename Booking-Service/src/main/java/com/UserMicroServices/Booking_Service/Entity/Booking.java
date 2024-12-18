package com.UserMicroServices.Booking_Service.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking") // Set table name specifically for bookings
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_no")
    private int roomNo;
    @Column(name = "table_no")
    private int tableNo;


    // Constructors, getters, setters
    public Booking(int id, int roomNo, int tableNo) {
        this.id = id;
        this.roomNo = roomNo;
        this.tableNo = tableNo;
    }

    public Booking() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

}
