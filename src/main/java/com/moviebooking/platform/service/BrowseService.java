package com.moviebooking.platform.service;

import com.moviebooking.platform.entity.Show;
import com.moviebooking.platform.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BrowseService {

    private final ShowRepository showRepository;

    public BrowseService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> browseShows(Long movieId, String city, LocalDate date) {
        return showRepository.findShows(movieId, city, date);
    }
}
