package com.UserMicroServices.Registration_Service.External;

import com.UserMicroServices.Booking_Service.Entity.Booking;
import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import com.UserMicroServices.Registration_Service.Entity.PersonalDetails;

public class BookingResponse {
    private PersonalDetails personalDetails;
    private BookingDetailsDTO bookingDetails;
    //constructor and getter,setter

    public BookingResponse(PersonalDetails personalDetails, BookingDetailsDTO bookingDetails) {
        this.personalDetails = personalDetails;
        this.bookingDetails = bookingDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public BookingDetailsDTO getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetailsDTO bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}
