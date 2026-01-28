package com.moviebooking.platform.repository;

import com.moviebooking.platform.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("""
        SELECT s FROM Show s
        WHERE s.movie.id = :movieId
        AND s.screen.theatre.city = :city
        AND s.show_date = :date
    """)
    List<Show> findShows(Long movieId, String city, LocalDate date);
}
