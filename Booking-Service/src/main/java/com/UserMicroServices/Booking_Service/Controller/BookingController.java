package com.UserMicroServices.Booking_Service.Controller;

import com.UserMicroServices.Booking_Service.Entity.Booking;
import com.UserMicroServices.Booking_Service.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    @GetMapping("/test")
    public String test(){
        return "This Is A Test Run Form Booking Service";
    }
    @PostMapping("/save")
    public String save(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return "Data Saved";
    }
    @GetMapping("/all")
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
    @GetMapping("/bookingId/{id}")
    public Booking findByBookingId(@PathVariable int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
