package com.UserMicroServices.Booking_Service.DTO;

public class BookingDTO {

    private int userId;
    private int roomNo;
    private int tableNo;

    public BookingDTO(int userId, int roomNo, int tableNo) {
        this.userId = userId;
        this.roomNo = roomNo;
        this.tableNo = tableNo;
    }

    public BookingDTO() {
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
