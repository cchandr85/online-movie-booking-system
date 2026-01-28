package com.moviebooking.platform.repository;

import com.moviebooking.platform.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

   // boolean existsByShowIdAndSeatNumbersIn(Long showId, List<Integer> seatNumbers);
}
