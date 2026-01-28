package com.moviebooking.platform.dto;

public class ShowResponse {
    private Integer showId;
    private String movie;
    private String screen;
    private String showTime;
    private String showDate;
    private String theatre;

    // Getters and Setters
    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getScreen() {
        return screen;
    }
    public void setScreen(String screen) {
        this.screen = screen;

    }
    public String getShowTime() {
        return showTime;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;

    }
    public String getShowDate() {
        return showDate;
    }
    public void setShowDate(String showDate) {
        this.showDate = showDate;

    }
    public String getTheatre() {
        return theatre;
    }
    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }
}
