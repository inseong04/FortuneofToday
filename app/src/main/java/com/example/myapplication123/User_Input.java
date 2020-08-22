package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class User_Input extends AppCompatActivity {
    private TextView textView1;


    //옥인성
    Button main_activation_nextscreen_btn,main_not_activation_nextscreen_btn,main_datepicker_btn;
    TextView main_text_year;
    TextView main_text_month;
    TextView main_text_day;
    EditText main_edit_name;
    TextView main_text_title;
    TextView main_datepicker_move;
    String year, month, day;
    int run = 0; // 생년월일 정보 입력여부
    //옥인성



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__input);


        //옥인성
        main_datepicker_btn = findViewById(R.id.datepicker_btn);
        main_text_year = findViewById(R.id.main_text_year);
        main_text_month = findViewById(R.id.main_text_month);
        main_text_day = findViewById(R.id.main_text_day);
        main_edit_name = findViewById(R.id.main_edit_name);
        main_text_title = findViewById(R.id.main_text_title);
        main_datepicker_move = findViewById(R.id.datepicker_move);
        main_activation_nextscreen_btn = findViewById(R.id.main_activation_nextscreen_btn);
        main_not_activation_nextscreen_btn = findViewById(R.id.main_not_activation_nextscreen_btn);
        Intent intent = getIntent(); // DatePicker -> MainActivity 로 전달된 값을 받는다.
        if (intent.getStringExtra("year") != null) { // DatePicker -> MainActivity 전달된 값이 0이 아닐 경우 변수에 저장한다.

            year = intent.getStringExtra("year");
            month = intent.getStringExtra("month");
            day = intent.getStringExtra("day");
        }

        run = intent.getIntExtra("run", 0);

        if (run != 0) {
            main_text_year.setVisibility(View.VISIBLE); //
            main_text_month.setVisibility(View.VISIBLE);
            main_text_day.setVisibility(View.VISIBLE); // 년,월,일 을 보여줌
            main_datepicker_move.setVisibility(View.INVISIBLE); // main_datepicker_move를 숨겨줌

            main_text_year.setText(year + "년");
            main_text_month.setText(month + "월");
            main_text_day.setText(day + "일");

        }

        // 년 월 일 코드
        //화면이동코드
        main_activation_nextscreen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                SharedPreferences year_save = getSharedPreferences("user_year",MODE_PRIVATE);
                SharedPreferences month_save = getSharedPreferences("user_month",MODE_PRIVATE);
                SharedPreferences day_save = getSharedPreferences("user_day",MODE_PRIVATE);
                SharedPreferences.Editor editor2 = year_save.edit();
                SharedPreferences.Editor editor3 = month_save.edit();
                SharedPreferences.Editor editor4 = day_save.edit();
                editor2.commit();
                editor3.commit();
                editor4.commit();

            }
        }); // MainActivity 이동 &&생년월일 전달

        main_datepicker_move.setOnClickListener(new View.OnClickListener() {// DatePicker로 이동
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(getApplicationContext(), DatePicker.class);
                startActivity(nextscreen);
            }
        });//datepicker이동
        //화면이동코드



        // 이름저장코드
        String text = main_edit_name.getText().toString(); // text에 edit_text내용을 저장
        SharedPreferences name_save = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = name_save.edit();
        String name_data = name_save.getString("text", "");
        editor.commit();
        // 이름저장코드

        main_edit_name.addTextChangedListener(new TextWatcher() { // edit_text가 입력이 끝나야 버튼활성화시키는 코드
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (run != 0) { // Datepicker 에서 생년월일까지 입력해야 버튼을 활성화 시킨다.
                    main_not_activation_nextscreen_btn.setVisibility(View.GONE);
                    main_activation_nextscreen_btn.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}