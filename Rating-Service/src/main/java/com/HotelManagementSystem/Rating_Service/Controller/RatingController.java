package com.HotelManagementSystem.Rating_Service.Controller;

import com.HotelManagementSystem.Rating_Service.DTO.RatingDTO;
import com.HotelManagementSystem.Rating_Service.Entity.Rating;
import com.HotelManagementSystem.Rating_Service.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public String saveRatings(@RequestBody RatingDTO rating) {
        ratingService.saveRatings(rating);
        return "Ratings saved successfully!";
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable int userId) {
        return ratingService.findByUserId(userId);
    }

    @GetMapping("/all")
    public List<Rating> findAll(){
        return ratingService.findAllRatings();
    }

    @GetMapping("/test")
    public String test(){
        return "This Is A Test RUN For Rating Service";
    }
}
