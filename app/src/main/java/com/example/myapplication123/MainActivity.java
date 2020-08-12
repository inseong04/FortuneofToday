package com.example.myapplication123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView textView1;


    //옥인성
    Button main_nextscreen_btn, main_datepicker_btn;
    TextView main_text_year;
    TextView main_text_month;
    TextView main_text_day;
    EditText main_edit_name;
    TextView main_text_title;
    TextView main_datepicker_move;

    String year,month,day;
    int run = 0; // 생년월일 정보 입력여부
    //옥인성

    private static final String TAG = "MainActivity";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Random random = new Random();
//        int number = random.nextInt(15);
//        String[] fortune1 = getResources().getStringArray(R.array.LUCK);
//        String fortune;   fortune = fortune1[number];




        //옥인성
        main_datepicker_btn = findViewById(R.id.datepicker_btn);
        main_nextscreen_btn = findViewById(R.id.main_nextscreen_btn);
        main_text_year = findViewById(R.id.main_text_year);
        main_text_month = findViewById(R.id.main_text_month);
        main_text_day = findViewById(R.id.main_text_day);
        main_edit_name = findViewById(R.id.main_edit_name);
        main_text_title = findViewById(R.id.main_text_title);
        main_datepicker_move = findViewById(R.id.datepicker_move);



        Intent intent = getIntent(); // DatePicker -> MainActivity 로 전달된 값을 받는다.
        if(intent.getStringExtra("year")!=null){ // DatePicker ->MainActivity 전달된 값이 0이 아닐 경우 변수에 저장한다.

            year = intent.getStringExtra("year");
            month = intent.getStringExtra("month");
            day = intent.getStringExtra("day");

        }

        run = intent.getIntExtra("run",0);

        if (run != 0){
        main_text_year.setVisibility(View.VISIBLE); //
        main_text_month.setVisibility(View.VISIBLE);
        main_text_day.setVisibility(View.VISIBLE); // 년,월,일 을 보여줌
            main_datepicker_move.setVisibility(View.INVISIBLE); // main_datepicker_move를 숨겨줌

            main_text_year.setText(year+"년");
            main_text_month.setText(month+"월");
            main_text_day.setText(day+"일");

        }

        //옥인성
        main_nextscreen_btn = findViewById(R.id.main_nextscreen_btn);
        main_nextscreen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Print.class);
                startActivity(intent);
            }
        });
//옥인성
        main_datepicker_move.setOnClickListener(new View.OnClickListener() {//"다음으로" 버튼 누르면 다음화면으로 이동하는거
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(getApplicationContext(), DatePicker.class);
                startActivity(nextscreen);
            }
        });
//옥인성
//        textView1 = (TextView)findViewById(R.id.textView1);
//        textView1.setText(fortune);
    }

}