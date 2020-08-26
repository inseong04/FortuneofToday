package com.example.myapplication123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    TextView background2,background3,background4,background5,
            information_username,information_year,information_month,information_day;
    SharedPreferences first_action,user_name,user_year,user_month,user_day;
    Button test_btn;
    String name,year,month,day;
    private static final String TAG = "MainActivity";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    background2 = findViewById(R.id.background_2);
        background3 = findViewById(R.id.background_3);
        background4 = findViewById(R.id.background_4);
        background5 = findViewById(R.id.background_5);
        first_action = getSharedPreferences("first_action",MODE_PRIVATE);
        information_username =findViewById(R.id.username);
        information_year = findViewById(R.id.main_year);
        information_month = findViewById(R.id.main_month);
        information_day = findViewById(R.id.main_day);

        user_name = getSharedPreferences("user_name",MODE_PRIVATE);
        user_year = getSharedPreferences("user_year",MODE_PRIVATE);
        user_month = getSharedPreferences("user_month",MODE_PRIVATE);
        user_day = getSharedPreferences("user_day",MODE_PRIVATE);
        name = user_name.getString("name","ERROR");
        year = user_year.getString("year","ERROR");
        month = user_month.getString("month","ERROR");
        day = user_day.getString("day","ERROR");
        information_username.setText(name);
        information_year.setText(year + ".");
        information_month.setText(month + ".");
        information_day.setText(day);//정보가 받아와지지않음. 해결해야함
        //첫실행체크코드
        boolean first_value = first_action.getBoolean("first_value",true);
        if(first_value){

            Intent go_user_input = new Intent(getApplicationContext(),User_Input.class);
            startActivity(go_user_input);
            first_action.edit().putBoolean("first_value",false).apply();
        }
        // test
        test_btn = findViewById(R.id.test);
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(getApplicationContext(),User_Input.class);
                startActivity(test);
            }
        });

        //박윤수 화면이동 코드
        background2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent name = new Intent(getApplicationContext(), Print.class);
                startActivity(name);
            }
        });
        background3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent school = new Intent(getApplicationContext(), Schoolprint.class);
                startActivity(school);
            }
        });
        background4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent job = new Intent(getApplicationContext(),Jobluck.class);
                startActivity(job);
            }
        });
    }

}