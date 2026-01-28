package com.moviebooking.platform.controller;

import com.moviebooking.platform.dto.BookingRequest;
import com.moviebooking.platform.entity.Booking;
import com.moviebooking.platform.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return bookingService.bookTickets(
                request.getShowId(),
                request.getSeats()
        );
    }
}