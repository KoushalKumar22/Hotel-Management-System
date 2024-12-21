package com.HotelManagementSystem.Rating_Service.Repository;

import com.HotelManagementSystem.Rating_Service.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findByUserId(int userId);
}
