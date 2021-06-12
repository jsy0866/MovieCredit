package com.example.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MovieDayAdapter extends RecyclerView.Adapter<MovieDayAdapter.Holder> {

    private List<LocalDate> days;

    @SuppressLint("NewApi")
    public MovieDayAdapter() {
        //당일 기준으로 날짜 가져오기
        LocalDate now = LocalDate.now();
        //당일로부터 +4일까지
        this.days = Arrays.asList(
                now,
                now.plusDays(1L),
                now.plusDays(2L),
                now.plusDays(3L),
                now.plusDays(4L)
        );
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_day, parent, false);
        return new Holder(view);
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.day.setText(days.get(position).toString());
    }

    // getItemCount() - 전체 날짜 개수 리턴
    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        private TextView day;

        public Holder(View view) {
            super(view);
            day = (TextView)view.findViewById(R.id.textView_day);
        }



    }
}
