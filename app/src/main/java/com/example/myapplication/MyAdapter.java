package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //    private ArrayList<StorageReference> itemList;
    private ArrayList<String> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public MyAdapter(Context context, ArrayList<String /*StorageReference*/> itemList, View.OnClickListener onClickItem) {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // context 와 parent.getContext() 는 같다.
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_imageview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        StorageReference item = itemList.get(position);
        String item = itemList.get(position);

//        int resourceId = context.getResources().getIdentifier("sample_001", "drawable",
//                context.getPackageName());
//        holder.imageView.setImageResource(resourceId);

        // Load the image using Glide
        Glide.with(holder.itemView.getContext())
                .load(item)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textview;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.item_iv);
        }
    }
}