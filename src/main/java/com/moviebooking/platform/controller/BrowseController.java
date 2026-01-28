package com.moviebooking.platform.controller;

import com.moviebooking.platform.dto.ShowResponse;
import com.moviebooking.platform.entity.Show;
import com.moviebooking.platform.service.BrowseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/browse")
public class BrowseController {

    private final BrowseService browseService;

    public BrowseController(BrowseService browseService) {
        this.browseService = browseService;
    }

    @GetMapping("/shows")
    public List<ShowResponse> browseShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return browseService.browseShows(movieId, city, date).stream().map( show -> {
            ShowResponse showResponse = new ShowResponse();
            showResponse.setShowId(show.getId());
            showResponse.setMovie(show.getMovie_id().getName());
            showResponse.setShowDate(show.getShow_date().toString());
            showResponse.setShowTime(show.getShow_time().toString());
            showResponse.setScreen(show.getScreen_id().getName());
            showResponse.setTheatre(show.getScreen_id().getTheatre().getName());
           return showResponse;
        }).toList();


    }
}
