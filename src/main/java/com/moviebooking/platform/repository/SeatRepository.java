package com.moviebooking.platform.repository;

import com.moviebooking.platform.entity.Booking;
import com.moviebooking.platform.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
