package com.UserMicroServices.Booking_Service.Repository;

import com.UserMicroServices.Booking_Service.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
