package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView listview;
    private MyAdapter adapter;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mypage).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        listview = findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

//        StorageReference storageRef = storage.getReference();
//        StorageReference folderRef = storageRef.child("movie");
//        StorageReference pathRef = folderRef.child("001.jpg");

        // https://www.geeksforgeeks.org/how-to-view-all-the-uploaded-images-in-firebase-storage/
//        StorageReference listRef = FirebaseStorage.getInstance().getReference(); //.child("images");
//        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
//            @Override
//            public void onSuccess(ListResult listResult) {
//                for(StorageReference file:listResult.getItems()){
//                    file.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                        @Override
//                        public void onSuccess(Uri uri) {
//                            imagelist.add(uri.toString());
//                            Log.e("Itemvalue", uri.toString());
//                        }
//                    }).addOnSuccessListener(new OnSuccessListener<Uri>() {
//                        @Override
//                        public void onSuccess(Uri uri) {
//                            recyclerView.setAdapter(adapter);
//                            progressBar.setVisibility(View.GONE);
//                            Log.e("onSuccess", uri.toString());
//                        }
//                    });
//                }
//            }
//        });

        ArrayList<String> strList = new ArrayList<>();
        strList.add("https://firebasestorage.googleapis.com/v0/b/moviecredit-b50c2.appspot.com/o/Main-MovieImage%2F001.jpg?alt=media&token=2504a30e-bfc5-4e06-8a0e-92e58f9cf6ef");
        strList.add("https://firebasestorage.googleapis.com/v0/b/moviecredit-b50c2.appspot.com/o/Main-MovieImage%2F002.jpg?alt=media&token=fccff688-a2ae-4647-b757-5759299a3a98");
        strList.add("https://firebasestorage.googleapis.com/v0/b/moviecredit-b50c2.appspot.com/o/Main-MovieImage%2F003.jpg?alt=media&token=502936d8-ab86-4e08-8c4d-2b6f75128e6e");
        strList.add("https://firebasestorage.googleapis.com/v0/b/moviecredit-b50c2.appspot.com/o/Main-MovieImage%2F004.jpg?alt=media&token=8d0c0095-780d-47dd-ba51-d3c02e7d971f");


        adapter = new MyAdapter(this, strList, onClickItem);
        listview.setAdapter(adapter);

        MyListDecoration decoration = new MyListDecoration();
        listview.addItemDecoration(decoration);

    }

    private OnClickListener onClickItem = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };
}