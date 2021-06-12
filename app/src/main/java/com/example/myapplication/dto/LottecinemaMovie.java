package com.example.myapplication.dto;


import com.google.android.gms.common.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            //해쉬셋 선언(movieNames)
            Set<String> movieNames = new HashSet<>();
            //해쉬셋 값 추가(해쉬셋에 얻은 영화이름을 추가)
            for (LottecinemaMovieItem item : Items) {
                movieNames.add(item.getMovieNameKR());
            }

            return movieNames;
        }

        public ArrayList<String> movieStartTimesBy(String movieName) {
            ArrayList<String> movieTimes = new ArrayList<>();
            for (LottecinemaMovieItem item : Items) {
                //영화이름이 롯데시네마아이템과 같을경우 해쉬셋 값 추가(해쉬셋에 얻은 영화시간을 추가)
                if(item.isSame(movieName)) {
                    movieTimes.add(item.getStartTime());
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
