package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Schoolprint extends AppCompatActivity {
    //윤수
    TextView textView4;
    TextView textView5;
    TextView textView6;
    Button schoolprint_close;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolprint);
        Random random = new Random();
        int number = random.nextInt(15);
        String[] fortune1 = getResources().getStringArray(R.array.SCHOOL);
        String fortune;   fortune = fortune1[number];
        String main = fortune.split("\\.")[0];
        String story = "";
        Intent intent = getIntent();
        // String name = intent.getStringExtra("name") + "님의 학업 운세";

        SharedPreferences name_save = getSharedPreferences("name_save",MODE_PRIVATE);
        name = name_save.getString("name_save","ERROR") + "님의 학업 운세";

        schoolprint_close = findViewById(R.id.schoolprint_close);


        for(String i : fortune.split("\\."))
        {
            if(main.equals(i))
            {
                continue;
            }
            story += i + ".";
        }


        textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setText(story);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setText(main);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setText(name);


        schoolprint_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent schoolprint_intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(schoolprint_intent);
            }
        });

    }
    //윤수
}