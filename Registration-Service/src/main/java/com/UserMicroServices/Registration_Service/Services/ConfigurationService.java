package com.UserMicroServices.Registration_Service.Services;

import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import com.UserMicroServices.Registration_Service.DTO.RatingsDTO;
import com.UserMicroServices.Registration_Service.Entity.CombinedResponse;
import com.UserMicroServices.Registration_Service.Entity.PersonalDetails;
import com.UserMicroServices.Registration_Service.External.BookingServiceClient;
import com.UserMicroServices.Registration_Service.External.RatingServiceClient;
import com.UserMicroServices.Registration_Service.Repository.PersonalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ConfigurationService {

    private final RestTemplate restTemplate;
    private final BookingServiceClient bookingServiceClient;
    private final RatingServiceClient ratingServiceClient;

    @Autowired
    public ConfigurationService(RestTemplate restTemplate, BookingServiceClient bookingServiceClient , RatingServiceClient ratingServiceClient) {
        this.restTemplate = restTemplate;
        this.bookingServiceClient = bookingServiceClient;
        this.ratingServiceClient = ratingServiceClient;
    }

    @Autowired
    private PersonalUserRepository userRepository;

    public void deleteAllRegistrations(){
        userRepository.deleteAll();
    }

    public List<CombinedResponse> findAllRegistrations() {
        List<PersonalDetails> registrations = userRepository.findAll();
        // Use Feign client to fetch booking details
        List<BookingDetailsDTO> bookingDetailsList = bookingServiceClient.getAllBookings();
        //use feign client to fetch ratings
        List<RatingsDTO> allRatings = ratingServiceClient.getAllRatings();

        // Map registrations, booking details and ratings
        return registrations.stream()
                .map(registration -> {
                    BookingDetailsDTO bookingDetails = bookingDetailsList.stream()
                            .filter(booking -> booking.getUserId() == registration.getId())
                            .findFirst()
                            .orElse(null);
                    List<RatingsDTO> userRatings = allRatings.stream()
                            .filter(rating -> rating.getUserId() == registration.getId())
                            .toList();

                    return new CombinedResponse(registration, bookingDetails ,userRatings);
                })
                .toList();
    }
    public CombinedResponse findById(int id) {
        PersonalDetails personalDetails = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));
        // Use Feign Client to fetch booking details
        BookingDetailsDTO bookingDetails = bookingServiceClient.getBookingDetailsByUserId(personalDetails.getId());
        // fetch data from Rating Service
        List<RatingsDTO> ratings = ratingServiceClient.getRatingsByUserId(personalDetails.getId());
        return new CombinedResponse(personalDetails, bookingDetails ,ratings);
    }
}

