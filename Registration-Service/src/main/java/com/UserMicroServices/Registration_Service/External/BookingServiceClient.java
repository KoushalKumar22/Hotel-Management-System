package com.UserMicroServices.Registration_Service.External;

import com.UserMicroServices.Registration_Service.DTO.BookingDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "booking-service")
public interface BookingServiceClient {

    @GetMapping("/booking/all")
    List<BookingDetailsDTO> getAllBookings();
}
