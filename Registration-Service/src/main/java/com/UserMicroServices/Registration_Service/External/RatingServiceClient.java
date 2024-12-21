package com.UserMicroServices.Registration_Service.External;

import com.UserMicroServices.Registration_Service.DTO.RatingsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rating-service")
public interface RatingServiceClient {

    @GetMapping("/rating/user/{userId}")
    List<RatingsDTO> getRatingsByUserId(@PathVariable int userId);

    @GetMapping("/rating/all")
    List<RatingsDTO> getAllRatings();
}
