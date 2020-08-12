package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DatePicker extends AppCompatActivity {

    android.widget.DatePicker datepicker_birthday;
    Button datepicker_btn;


    String intent_year,intent_month,intent_day;
    int run = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        final Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class); // DatePicker -> MainActivity
        datepicker_birthday = findViewById(R.id.datepicker_birthday);
        datepicker_btn = findViewById(R.id.datepicker_btn);

        android.widget.DatePicker datepicker = findViewById(R.id.datepicker_birthday);

        datepicker.init(datepicker.getYear(), datepicker.getMonth(), datepicker.getDayOfMonth(),
                new android.widget.DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        intent_year = year+"";
                        intent_month = monthOfYear+"";
                        intent_day = dayOfMonth+"";

                    }
                });

                datepicker_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        mainactivity.putExtra("year",intent_year);
                        mainactivity.putExtra("month",intent_month);
                        mainactivity.putExtra("day",intent_day);
                        mainactivity.putExtra("run",run);
                        startActivity(mainactivity);
                        Toast.makeText(DatePicker.this, "생년월일을 성공적으로 입력하였습니다!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}