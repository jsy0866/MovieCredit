package com.example.myapplication;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyTimeListAdapter extends RecyclerView.Adapter<MyTimeListAdapter.ItemViewHolder> {

    // adapter에 들어갈 list (데이터 배열 선언)
    private ArrayList<MovieClass> mList;
    private Context mContext;

    // RecyclerView의 핵심인 ViewHolder
    // 여기서 subView를 setting 해준다.
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_title;
        private final RecyclerView movieTimesView;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView)itemView.findViewById(R.id.textView_title);
            movieTimesView = (RecyclerView)itemView.findViewById(R.id.movie_time_list_view);
        }

    }

    //생성자
    public MyTimeListAdapter(ArrayList<MovieClass> movieList, Context mContext) {
        this.mList = movieList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyTimeListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킨다.
        // return 인자는 ViewHolder 이다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTimeListAdapter.ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수
        holder.textView_title.setText(String.valueOf(mList.get(position).getTitle()));
        holder.movieTimesView.setAdapter(new MovieTimeAdapter(mList.get(position).getTimes(), mContext));
//        holder.movieTimesView.addItemDecoration(new Decoration());
        holder.movieTimesView.setLayoutManager(new LinearLayoutManager(mContext,  LinearLayoutManager.HORIZONTAL, false));

    }


    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수
        return mList.size();
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

