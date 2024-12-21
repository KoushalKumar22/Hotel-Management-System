package com.HotelManagementSystem.Rating_Service.Services;

import com.HotelManagementSystem.Rating_Service.DTO.RatingDTO;
import com.HotelManagementSystem.Rating_Service.Entity.Rating;
import com.HotelManagementSystem.Rating_Service.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void saveRatings(RatingDTO ratingRequest) {
        List<Rating> ratings = ratingRequest.getCategoryRatings().stream().map(categoryRating -> {
            Rating rating = new Rating();
            rating.setUserId(ratingRequest.getUserId());
            rating.setCategory(categoryRating.getCategory());
            rating.setRatingScore(categoryRating.getRatingScore());
            rating.setComment(categoryRating.getComment());
            return rating;
        }).collect(Collectors.toList());

        ratingRepository.saveAll(ratings);
    }

    public List<Rating> findByUserId(int userId) {
        return ratingRepository.findByUserId(userId);
    }
    public List<Rating> findAllRatings(){
        return ratingRepository.findAll();
    }
}

