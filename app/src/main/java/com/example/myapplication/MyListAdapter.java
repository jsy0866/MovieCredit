package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<String> myList;

    public MyListAdapter(Context mContext, ArrayList<String> myList) {
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

        movieName.setText(myList.get(position));
        return view;
    }

}
