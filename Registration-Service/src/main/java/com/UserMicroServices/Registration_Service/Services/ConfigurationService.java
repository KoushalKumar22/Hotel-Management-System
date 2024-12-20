package com.UserMicroServices.Registration_Service.Services;

import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import com.UserMicroServices.Registration_Service.Entity.BookingResponse;
import com.UserMicroServices.Registration_Service.Entity.PersonalDetails;
import com.UserMicroServices.Registration_Service.External.BookingServiceClient;
import com.UserMicroServices.Registration_Service.Repository.PersonalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ConfigurationService {

    private final RestTemplate restTemplate;
    private final BookingServiceClient bookingServiceClient;

    @Autowired
    public ConfigurationService(RestTemplate restTemplate , BookingServiceClient bookingServiceClient){
        this.restTemplate = restTemplate;
        this.bookingServiceClient = bookingServiceClient;
    }

    @Autowired
    private PersonalUserRepository userRepository;

    public List<BookingResponse> findAllRegistrations(){
        List<PersonalDetails> registrations = userRepository.findAll();

        //use of feign client to fetch booking details
        List<BookingDetailsDTO> bookingDetailsList = bookingServiceClient.getAllBookings();

        //map registrations and booking details
        return registrations.stream()
                .map(registration ->{
                    BookingDetailsDTO bookingDetails = bookingDetailsList.stream()
                            .filter(booking -> booking.getId() == registration.getBookingId())
                            .findFirst()
                            .orElse(null);
                    return new
                            BookingResponse(registration, bookingDetails);
                })
                .toList();
    }
}
