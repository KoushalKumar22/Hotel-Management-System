package com.UserMicroServices.Registration_Service.DTO;

public class BookingDetailsDTO {
    private int userId;
    private int roomNo;
    private int tableNo;
    // Constructors, getters, and setters
    public BookingDetailsDTO(int userId, int roomNo, int tableNo) {
        this.userId = userId;
        this.roomNo = roomNo;
        this.tableNo = tableNo;
    }

    public BookingDetailsDTO() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
