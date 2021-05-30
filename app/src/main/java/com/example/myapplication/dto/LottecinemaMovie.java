package com.example.myapplication.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottecinemaMovie {

    private PlaySeqs PlaySeqs;

    public static class PlaySeqs {
        private Integer ItemCount;

        private List<LottecinemaMovieItem> Items;

        public Integer getItemCount() {
            return ItemCount;
        }

        public void setItemCount(Integer itemCount) {
            this.ItemCount = itemCount;
        }

        public List<LottecinemaMovieItem> getItems() {
            return Items;
        }


        public Set<String> getMovieNames() {
            Set<String> movieNames = new HashSet<>();   //객체 선언(영화이름)
            for (LottecinemaMovieItem item : Items) {
                movieNames.add(item.getMovieNameKR());  //데이터 삽입(영화이름)
            }

            return movieNames;
        }

        public List<String> movieStartTimesBy(String movieName) {
            List<String> movieTimes = new ArrayList<>();     //객체 선언(영화 시간)
            for (LottecinemaMovieItem item : Items) {
                if(item.isSame(movieName)) {       //영화이름이 롯데시네마아이템과 같을경우
                    movieTimes.add(item.getStartTime());    //데이터 삽입(영화 시작 시간)
                }
            }

            return movieTimes;
        }


        public void setItems(List<LottecinemaMovieItem> items) {
                this.Items = Items;
        }
    }


    public PlaySeqs getPlaySeqs() {
        return PlaySeqs;
    }

    public void setPlaySeqs(PlaySeqs playSeqs) {
        this.PlaySeqs = playSeqs;
    }
}
