package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyTimeActivity extends AppCompatActivity {

    private ListView listview;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        // 지역 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list = new ArrayList<>();

        list.add("서울") ;

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.title_area) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 MyAreaAdapter 객체 지정.
        MyAreaAdapter adapter = new MyAreaAdapter(list) ;
        recyclerView.setAdapter(adapter) ;

        //아이템 사이 구분선 추가
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



        // 영화관 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("가산디지털") ;
        list2.add("가양") ;
        list2.add("강동") ;
        list2.add("건대입구") ;
        list2.add("김포공항") ;
        list2.add("노원") ;
        list2.add("도곡") ;
        list2.add("독산");
        list2.add("브로드웨이(신사)");
        list2.add("서울대입구") ;
        list2.add("신사") ;
        list2.add("에비뉴엘(명동)") ;
        list2.add("영등포") ;
        list2.add("용산") ;
        list2.add("월드타워") ;
        list2.add("은평(롯데몰)") ;
        list2.add("장안");
        list2.add("중랑");
        list2.add("청량리") ;
        list2.add("합청") ;
        list2.add("홍대입구") ;



        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView2 = findViewById(R.id.title_theater) ;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this)) ;

        //아이템 사이 구분선 추가
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(recyclerView2.getContext(),new LinearLayoutManager(this).getOrientation());
        recyclerView2.addItemDecoration(dividerItemDecoration2);

        // 리사이클러뷰에 MyTheaterAdapter 객체 지정.
        MyTheaterAdapter adapter2 = new MyTheaterAdapter(list2) ;
        recyclerView2.setAdapter(adapter2) ;

    }
}
