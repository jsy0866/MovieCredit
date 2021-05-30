package com.example.myapplication.dto;

public class LottecinemaMovieItem {

    //영화이름, 날짜, 영화시작시간
    private String MovieNameKR;

    private String PlayDt;

    private String StartTime;


    //같은 값이 존재한다면 출력, 없으면 false
    public boolean isSame(String movieName) {
        if(MovieNameKR == null) {
            return false;
        }

        return MovieNameKR.equals(movieName);
    }

    public String getMovieNameKR() {
        return MovieNameKR;
    }

    public void setMovieNameKR(String movieNameKR) {
        MovieNameKR = movieNameKR;
    }

    public String getPlayDt() {
        return PlayDt;
    }

    public void setPlayDt(String playDt) {
        PlayDt = playDt;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }


}
