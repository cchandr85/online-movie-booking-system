package com.moviebooking.platform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToOne
    @JoinColumn(name = "show_seats_id", nullable = false)
    private ShowSeats showSeats;

   // private List<Integer> seatNumbers;

    @Column(name = "status", nullable = false)
    private String status;

    // Getters and Setters
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

  /*  public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShowSeats getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(ShowSeats showSeats) {
        this.showSeats = showSeats;
    }
}