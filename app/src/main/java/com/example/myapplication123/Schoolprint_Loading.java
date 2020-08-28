package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Schoolprint_Loading extends AppCompatActivity {

    TextView Schoolprint_name,Schoolprint_tv1,Schoolprint_tv2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolprint__loading);
        Schoolprint_name = findViewById(R.id.schoolprint_name);
        Schoolprint_tv1 = findViewById(R.id.schoolprint_tv1);
        Schoolprint_tv2 = findViewById(R.id.schoolprint_tv2);
        SharedPreferences shared_name = getSharedPreferences("name_save",MODE_PRIVATE);
        name = shared_name.getString("name_save","ERROR");
        Schoolprint_name.setText(name);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Schoolprint.class);
                startActivity(intent);
            }
        }, 2000);
    }
}