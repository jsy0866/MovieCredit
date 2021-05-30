package com.example.myapplication;

import java.util.List;

//영화제목, 시간리스트 클래스
public class MovieClass {
    private String title;
    private List<String> times;

    public MovieClass(String title, List<String> times) {
        this.title = title;
        this.times = times;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }


}
