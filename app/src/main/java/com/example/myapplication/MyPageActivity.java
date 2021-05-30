package com.example.myapplication;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MyPageActivity extends AppCompatActivity implements OnItemClickListener, OnClickListener

{

    // 추가될 아이템 내용을 입력받는 EditText
    private EditText mEtInputText;

    // 아이템 추가 버튼
    private Button mBInputToList;

    // 리스트뷰
    private ListView mLvList;

    // 데이터 리스트
    private ArrayList<String> mAlData;

    // 리스트뷰에 사용되는 ArrayAdapter
    private ArrayAdapter<String> mAaString;


    @Override

    public void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_page);



        //////////////////////////////////////////////////////////////

        // 위젯 레퍼런스

        mEtInputText = (EditText)findViewById(R.id.add_text);
        mBInputToList = (Button)findViewById(R.id.add_list_btn);
        mLvList = (ListView)findViewById(R.id.my_list);



        // 아이템 추가 버튼에 클릭리스너를 등록한다.

        mBInputToList.setOnClickListener(this);

        // ArrayList 생성

        mAlData = new ArrayList<String>();

        // ArrayAdapter 생성

        mAaString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mAlData);



        // 어뎁터를 리스트뷰에 세팅한다.

        mLvList.setAdapter(mAaString);



        // 리스트뷰에 아이템클릭리스너를 등록한다.

        mLvList.setOnItemClickListener(this);

    }



    @Override

    protected void onResume()

    {

        super.onResume();



        // ArrayList 초기화

        mAlData.clear();



        // ArrayList에 더미 데이터 입력

        defaultData();

    }





    private void defaultData()

    {

        mAlData.add("아이템 00");

        mAlData.add("아이템 01");

        mAlData.add("아이템 02");

        mAlData.add("아이템 03");

        mAlData.add("아이템 04");

        mAlData.add("아이템 05");

        mAlData.add("아이템 06");

        mAlData.add("아이템 07");

        mAlData.add("아이템 08");

        mAlData.add("아이템 09");

        mAlData.add("아이템 10");

        mAlData.add("아이템 11");

        mAlData.add("아이템 12");

        mAlData.add("아이템 13");

        mAlData.add("아이템 14");

        mAlData.add("아이템 15");

        mAlData.add("아이템 16");

        mAlData.add("아이템 17");

        mAlData.add("아이템 18");

        mAlData.add("아이템 19");

    }



    public void onItemClick(AdapterView<?> parent, View v, final int position, long id)

    {





        // 리스트에서 데이터를 받아온다.

//      String data = (String) parent.getItemAtPosition(position);

        String data = mAlData.get(position);



        // 삭제 다이얼로그에 보여줄 메시지를 만든다.

        String message = "해당 데이터를 삭제하시겠습니까?<br />" +

                "position : " + position + "<br />" +

                "data : " + data + "<br />";



        DialogInterface.OnClickListener deleteListener = new DialogInterface.OnClickListener()

        {

            @Override

            public void onClick(DialogInterface arg0, int arg1)

            {

                // 선택된 아이템을 리스트에서 삭제한다.

                mAlData.remove(position);



                // Adapter에 데이터가 바뀐걸 알리고 리스트뷰에 다시 그린다.

                mAaString.notifyDataSetChanged();

            }

        };



        // 삭제를 물어보는 다이얼로그를 생성한다.

        new AlertDialog.Builder(this)

                .setTitle("http://croute.me - 예제")

                .setMessage(Html.fromHtml(message))

                .setPositiveButton("삭제", deleteListener)

                .show();

    }



    public void onClick(View v)

    {





        switch(v.getId())

        {

            // 리스트에 추가 버튼이 클릭되었을때의 처리

            case R.id.add_list_btn:

                if(mEtInputText.getText().length() == 0)

                {

                    // 데이터를 입력하라는 메시지 토스트를 출력한다.

                    Toast.makeText(this, "데이터를 입력하세요.", Toast.LENGTH_SHORT).show();

                }

                else

                {

                    // 입력할 데이터를 받아온다.

                    String data = mEtInputText.getText().toString();



                    // 리스트에 데이터를 입력한다.

                    mAlData.add(data);



                    // Adapter에 데이터가 바뀐걸 알리고 리스트뷰에 다시 그린다.

                    mAaString.notifyDataSetChanged();



                    // 데이터 추가 성공 메시지 토스트를 출력한다.

                    Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show();



                    // EditText의 내용을 지운다.

                    mEtInputText.setText("");



                    // 데이터가 추가된 위치(리스트뷰의 마지막)으로 포커스를 이동시킨다.

                    mLvList.setSelection(mAlData.size()-1);

                }

                break;

        }

    }

}

