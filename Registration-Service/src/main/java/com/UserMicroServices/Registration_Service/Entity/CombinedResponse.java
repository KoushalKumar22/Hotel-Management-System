package com.UserMicroServices.Registration_Service.Entity;

import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import com.UserMicroServices.Registration_Service.DTO.RatingsDTO;

import java.util.List;

public class CombinedResponse {
    private PersonalDetails personalDetails;
    private BookingDetailsDTO bookingDetails;
    private List<RatingsDTO> rating;
    //constructor and getter,setter

    public CombinedResponse(PersonalDetails personalDetails, BookingDetailsDTO bookingDetails, List<RatingsDTO> rating) {
        this.personalDetails = personalDetails;
        this.bookingDetails = bookingDetails;
        this.rating = rating;
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

    public List<RatingsDTO> getRating() {
        return rating;
    }

    public void setRating(List<RatingsDTO> rating) {
        this.rating = rating;
    }
}
