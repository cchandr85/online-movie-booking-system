package com.moviebooking.platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Show {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(name = "show_date", nullable = false)
    private LocalDate show_date;
    @Column(name = "show_time", nullable = false)
    private LocalTime show_time;

    public int getId() {
        return id;
    }


    public Movie getMovie_id() {
        return movie;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie = movie_id;
    }

    public Screen getScreen_id() {
        return screen;
    }

    public void setScreen_id(Screen screen_id) {
        this.screen = screen_id;
    }

    public LocalDate getShow_date() {
        return show_date;
    }

    public void setShow_date(LocalDate show_date) {
        this.show_date = show_date;
    }

    public LocalTime getShow_time() {
        return show_time;
    }

    public void setShow_time(LocalTime show_time) {
        this.show_time = show_time;
    }
}
