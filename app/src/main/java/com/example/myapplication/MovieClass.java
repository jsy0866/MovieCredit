package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

//영화제목, 시간리스트 클래스
public class MovieClass {
    private String title;
    private ArrayList<String> times;

    public MovieClass(String title){
        this.title=title;

    }

    public MovieClass(String title, ArrayList<String> times) {
        this.title = title;
        this.times = times;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

}
