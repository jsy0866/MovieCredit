package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieTimeAdapter extends BaseAdapter {

    private List<String> times;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MovieTimeAdapter(List<String> times, Context mContext) {
        this.times = times;
        this.mContext = mContext;
        this.mLayoutInflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);    //XML파일을 View객체로 만듦
    }

    //시간 데이터의 전체 개수 판단
    @Override
    public int getCount() {
        return times.size();
    }

    //전달받은 position의 위치의 item을 리턴
    @Override
    public String getItem(int position) {
        return times.get(position);
    }

    //해당 Item를 나타내는 고유한정보로 position을 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }


    //인자로 받은 위치의 데이터가 화면에 표시될 뷰 반환
    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder")
        View view = mLayoutInflater.inflate(R.layout.item_time, viewGroup, false);
        TextView movieTimeView = view.findViewById(R.id.textView_time);
        movieTimeView.setText(times.get(position));
        return view;
    }
}
