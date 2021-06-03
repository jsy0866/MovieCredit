package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyTheaterAdapter extends RecyclerView.Adapter<MyTheaterAdapter.ViewHolder> {
    private ArrayList<String> mData2 = null ;
    private Intent intent;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTheater ;

        ViewHolder(View itemView2) {
            super(itemView2) ;
            // 뷰 객체에 대한 참조. (hold strong reference)
            textTheater = itemView2.findViewById(R.id.item_text_theater) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        intent = new Intent(v.getContext(), TimeListActivity.class);    //activity 전환을 위해 intent 사용
                        v.getContext().startActivity(intent);   //액티비티 전환 실시
                    }
                }
            });


        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public MyTheaterAdapter(ArrayList<String> list) {
        this.mData2 = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public MyTheaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.item_theater, parent, false) ;
        MyTheaterAdapter.ViewHolder vh = new MyTheaterAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(MyTheaterAdapter.ViewHolder holder, int position) {
        String text = mData2.get(position) ;
        holder.textTheater.setText(text) ;
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData2.size() ;
    }
}
