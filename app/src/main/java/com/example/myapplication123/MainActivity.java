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

    TextView background2;
    TextView background3;
    TextView background4;
    TextView background5;



    private static final String TAG = "MainActivity";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    background2 = findViewById(R.id.background_2);
        background3 = findViewById(R.id.background_3);
        background4 = findViewById(R.id.background_4);
        background5 = findViewById(R.id.background_5);


    }

}