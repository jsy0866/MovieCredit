package com.example.myapplication.dto;

public class MovieSchedule {

    private Integer deadLine;

    private String movieName;

    public MovieSchedule(Integer deadLine, String movieName) {
        this.deadLine = deadLine;
        this.movieName = movieName;
    }

    public String getFormattingDeadLine() {
        return String.format("%d일전", deadLine);
    }

    public Integer getDeadLine() {
        return deadLine;
    }

    public String getMovieName() {
        return movieName;
    }
}
