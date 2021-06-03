package com.example.myapplication;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieTimeAdapter extends RecyclerView.Adapter<MovieTimeAdapter.ItemViewHolder> {

    private ArrayList<String> times;
    private Context mContext;

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView timeView;


        public ItemViewHolder(View itemView) {
            super(itemView);
            timeView = itemView.findViewById(R.id.textView_time);
        }

    }

    public MovieTimeAdapter(ArrayList<String> times, Context mContext) {
        this.times = times;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MovieTimeAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킨다.
        // return 인자는 ViewHolder 이다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time, parent, false);
        return new MovieTimeAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTimeAdapter.ItemViewHolder holder, int position) {
        holder.timeView.setText(times.get(position));
    }


    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수
        return times.size();
    }

//    //아이템 우측간격 조절
//    public static class Decoration extends RecyclerView.ItemDecoration {
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            outRect.right = 15;
//        }
//    }

}
