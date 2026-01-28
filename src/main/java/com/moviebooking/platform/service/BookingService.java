package com.moviebooking.platform.service;

import com.moviebooking.platform.entity.Booking;
import com.moviebooking.platform.entity.Seat;
import com.moviebooking.platform.entity.Show;
import com.moviebooking.platform.entity.ShowSeats;
import com.moviebooking.platform.repository.BookingRepository;
import com.moviebooking.platform.repository.SeatRepository;
import com.moviebooking.platform.repository.ShowRepository;
import com.moviebooking.platform.repository.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository,
                          ShowRepository showRepository,ShowSeatRepository showSeatRepository,
                          SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    public Booking bookTickets(Long showId, List<Integer> seats) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        List<ShowSeats> lockedSeats = new ArrayList<>();

        // 1️⃣ LOCK seats (insert or update show_seats)
        for (Integer seatId : seats) {

            Seat seat = seatRepository.findById(seatId.longValue())
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            ShowSeats showSeat = showSeatRepository
                    .findByShowIdAndSeatId(showId.intValue(), seatId)
                    .orElseGet(() -> {
                        ShowSeats ss = new ShowSeats();
                        ss.setShow(show);
                        ss.setSeat(seat);
                        ss.setStatus("LOCKED");
                        return ss;
                    });

            if (!"AVAILABLE".equals(showSeat.getStatus())
                    && showSeat.getId() != null) {
                throw new RuntimeException("Seat already booked or locked");
            }

            showSeat.setStatus("LOCKED");
            lockedSeats.add(showSeatRepository.save(showSeat));
        }

        // 2️⃣ CREATE booking (ID generated here)
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setShowSeats(lockedSeats.get(0));
        booking.setStatus("CONFIRMED");

        Booking savedBooking = bookingRepository.save(booking);

        // 3️⃣ MAP seats to booking
        for (ShowSeats ss : lockedSeats) {


            // Mark seat as BOOKED
            ss.setStatus("BOOKED");
            showSeatRepository.save(ss);
        }

        return savedBooking;
    }
}
