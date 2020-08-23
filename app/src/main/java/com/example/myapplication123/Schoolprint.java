package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Schoolprint extends AppCompatActivity {
    //윤수
    TextView textView4;
    TextView textView5;
    TextView textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        Random random = new Random();
        int number = random.nextInt(15);
        String[] fortune1 = getResources().getStringArray(R.array.SCHOOL);
        String fortune;   fortune = fortune1[number];
        String main = fortune.split("\\.")[0];
        String story = "";
        Intent intent = getIntent();
        String name = intent.getStringExtra("name") + "님의 학업 운세";

        for(String i : fortune.split("\\."))
        {
            if(main.equals(i))
            {
                continue;
            }
            story += i + ".";
        }


        textView4 = (TextView)findViewById(R.id.textView1);
        textView4.setText(story);
        textView5 = (TextView)findViewById(R.id.textView2);
        textView5.setText(main);
        textView6 = (TextView)findViewById(R.id.textView3);
        textView6.setText(name);

    }
    //윤수
}