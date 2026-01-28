package com.moviebooking.platform.repository;

import com.moviebooking.platform.entity.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeats, Integer> {
    Optional<ShowSeats> findByShowIdAndSeatId(Integer showId, Integer seatId);
}

