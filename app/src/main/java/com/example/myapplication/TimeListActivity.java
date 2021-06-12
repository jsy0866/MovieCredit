package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.dto.LottecinemaMovie;
import com.google.gson.Gson;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeListActivity extends AppCompatActivity {
    public RecyclerView recycler1;
    private RecyclerView movieDaysView;
    public ArrayList<MovieClass> movieList = new ArrayList<>();
    private final Gson gson = new Gson();

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_list);

        recycler1= findViewById(R.id.list_movie);
        movieDaysView = findViewById(R.id.list_day);

        //날짜
        MovieDayAdapter movieDayAdapter = new MovieDayAdapter();
        movieDaysView.setLayoutManager(new LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false));
        movieDaysView.setAdapter(movieDayAdapter);
        movieDaysView.addItemDecoration(new MyListDecoration());
        //AsyncTask 작동시킴(파싱)
        new Description(LocalDate.now().toString()).execute();

    }
    public class Description extends AsyncTask<Void, Void, Void> {

        //진행바표시
        private ProgressDialog progressDialog;
        private String selectDate;

        public Description(String selectDate) {
            this.selectDate = selectDate;
        }


        //AsyncTask의 작업을 시작하기 전에 호출. AsyncTask에서 가장 먼저 한 번 호출
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //진행다일로그 시작
            progressDialog = new ProgressDialog(TimeListActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("잠시 기다려 주세요.");
            progressDialog.show();

        }

        //스레드에 의해 처리될 내용을 담기 위한 함수
        @Override
        protected Void doInBackground(Void... params) {
            LottecinemaMovie.PlaySeqs playList = getNowLotteCinemaMovies().getPlaySeqs();

            //movieName에 얻은 영화이름을 추가, movieList에 추가
            for (String movieName : playList.getMovieNames()) {
                movieList.add(new MovieClass(movieName, playList.movieStartTimesBy(movieName)));
            }

            return null;
        }

        // AsyncTask의 모든 작업이 완료된 후 가장 마지막에 한 번 호출. doInBackground() 함수의 최종 값을 받기 위해 사용
        @Override
        protected void onPostExecute(Void result) {
            //ArraList를 인자로 해서 어답터와 연결한다.
            MyTimeListAdapter myAdapter = new MyTimeListAdapter(movieList, TimeListActivity.this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recycler1.setLayoutManager(layoutManager);
            recycler1.setAdapter(myAdapter);

            progressDialog.dismiss();
        }


        @SuppressLint("NewApi")
        private LottecinemaMovie getNowLotteCinemaMovies() {
            //해쉬맵 생성 key-value 형태로 requestBody에 저장
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("MethodName", "GetPlaySequence");
            requestBody.put("channelType", "HO");
            requestBody.put("osType", "W");
            requestBody.put("osVersion", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.272 Whale/2.9.117.22 Safari/537.36");
            //Date를 사용해 날짜를 불러옴
            requestBody.put("playDate", LocalDate.now().toString());
            requestBody.put("cinemaID", "1|0001|1013");
            requestBody.put("representationMovieCode", "");

            try {
                Connection.Response execute = Jsoup
                        //Jsoup의 Conection 메소드를 이용해 '티켓팅'페이지에 접속해 Document를 얻어낸다.
                        .connect("https://www.lottecinema.co.kr/LCWS/Ticketing/TicketingData.aspx")
                        .method(Connection.Method.POST)
                        .header("Content-Type", " multipart/form-data")
                        .userAgent("Mozilla/5.0")
                        //자바 객체를 json 표현식으로 변환
                        .data("ParamList", gson.toJson(requestBody))
                        .execute();

                return gson.fromJson(execute.body(), LottecinemaMovie.class);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
