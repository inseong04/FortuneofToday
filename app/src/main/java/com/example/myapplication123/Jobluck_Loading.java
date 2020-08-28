package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Jobluck_Loading extends AppCompatActivity {

    TextView Jobluck_name,Jobluck_tv1,Jobluck_tv2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobluck_loading);
        Jobluck_name = findViewById(R.id.Jobluck_name);
        Jobluck_tv1 = findViewById(R.id.Jobluck_tv1);
        Jobluck_tv2 = findViewById(R.id.Jobluck_tv2);
        SharedPreferences shared_name = getSharedPreferences("name_save",MODE_PRIVATE);
        name = shared_name.getString("name_save","ERROR");
        Jobluck_name.setText(name);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Jobluck.class);
                startActivity(intent);
            }
        }, 2000);
    }

}