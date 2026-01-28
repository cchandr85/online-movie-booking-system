package com.moviebooking.platform.dto;

public class BookingRequest {
    private Long showId;
    private java.util.List<Integer> seats;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public java.util.List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(java.util.List<Integer> seats) {
        this.seats = seats;
    }
}
