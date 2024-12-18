package com.UserMicroServices.Registration_Service.DTO;

public class BookingDetailsDTO {
    private int id;
    private int roomNo;
    private int tableNo;
    // Constructors, getters, and setters
    public BookingDetailsDTO(int id, int roomNo, int tableNo) {
        this.id = id;
        this.roomNo = roomNo;
        this.tableNo = tableNo;
    }

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
