package com.UserMicroServices.Registration_Service.Controller;


import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import com.UserMicroServices.Registration_Service.Entity.PersonalDetails;
import com.UserMicroServices.Registration_Service.Entity.BookingResponse;
import com.UserMicroServices.Registration_Service.Repository.PersonalUserRepository;
import com.UserMicroServices.Registration_Service.Services.ConfigurationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    PersonalUserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    private final ConfigurationService configurationService;
    @Autowired
    public UserController(ConfigurationService configurationService){
        this.configurationService = configurationService;
    }

    @GetMapping("/test")
    public String test(){
        return "This Is a Test Run From registration service";
    }

    @PostMapping("/save")
    public String save(@RequestBody PersonalDetails personalDetails){
        userRepository.save(personalDetails);
        return "Data Saved";
    }

    @GetMapping("/all")
    public List<PersonalDetails> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/Id/{id}")
    public Optional<PersonalDetails> findUserById(@PathVariable int id){
        return userRepository.findById(id);
    }


    @GetMapping("/registrationId/{id}")
    //@CircuitBreaker(name = "registrationIdEvent", fallbackMethod = "registrationFallback")
    @Retry(name = "registrationIdEvent", fallbackMethod = "registrationFallback")
    public BookingResponse findById(@PathVariable int id){
        return configurationService.findById(id);
    }

    //fallback method for circuit breaker
    public BookingResponse registrationFallback(int id, Throwable throwable){
        PersonalDetails personalDetails= new PersonalDetails();
        personalDetails.setId(id);
        personalDetails.setName("Fallback User");
        personalDetails.setAddress("Fallback Address");
        BookingDetailsDTO bookingDetails= new BookingDetailsDTO();
        bookingDetails.getId();
        bookingDetails.setRoomNo(0);
        bookingDetails.setTableNo(0);
        return new BookingResponse(personalDetails, bookingDetails);
    }


    @GetMapping("/allRegistrations")
    public List<BookingResponse> findAllRegistrations(){
        return configurationService.findAllRegistrations();
    }

    //Alternate Approach for Finding all registration

//        @GetMapping("/allRegistrations")
//    public List<BookingResponse> findAllRegistrations() {
//        List<PersonalDetails> registrations = userRepository.findAll();
//        String bookingServiceUrl = "http://BOOKING-SERVICE/booking/all";
//        ResponseEntity<List<BookingDetailsDTO>> response = restTemplate.exchange(
//                bookingServiceUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<BookingDetailsDTO>>() {}
//        );
//        List<BookingDetailsDTO> bookingDetailsList = response.getBody();
//        return registrations.stream()
//                .map(registration -> {
//                    BookingDetailsDTO bookingDetails = bookingDetailsList.stream()
//                            .filter(booking -> booking.getId() == registration.getBookingId())
//                            .findFirst()
//                            .orElse(null);
//                    return new BookingResponse(registration, bookingDetails);
//                })
//                .toList();
//    }

    //Alternate Approach for finding registrations by id

//        @GetMapping("/registrationId/{id}")
//    //@CircuitBreaker(name = "registrationIdEvent", fallbackMethod = "registrationFallback")
//    @Retry(name = "registrationIdEvent", fallbackMethod = "registrationFallback")
//    public BookingResponse findById(@PathVariable int id) {
//        PersonalDetails personalDetails = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Booking not found"));
//        String userServiceUrl = "http://BOOKING-SERVICE/booking/bookingId/" + personalDetails.getId();
//        BookingDetailsDTO bookingDetails = restTemplate.getForObject(userServiceUrl, BookingDetailsDTO.class);
//        return new BookingResponse(personalDetails, bookingDetails);
//    }
}
