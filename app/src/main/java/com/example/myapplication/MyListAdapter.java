package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.dto.MovieSchedule;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    List<MovieSchedule> myList;

    public MyListAdapter(Context mContext, List<MovieSchedule> myList) {
        this.mContext = mContext;
        this.myList = myList == null ? new ArrayList<>() : myList;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        //상영시간표
        View view = mLayoutInflater.inflate(R.layout.my_list_item, null);
        TextView movieName = view.findViewById(R.id.movieName);
        TextView movieDeadLine = view.findViewById(R.id.movieDeadLine);
        MovieSchedule movieSchedule = myList.get(position);
        movieName.setText(movieSchedule.getMovieName());
        movieDeadLine.setText(movieSchedule.getFormattingDeadLine());
        return view;
    }

}
