package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class    Print extends AppCompatActivity {
    //윤수
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button print_close;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);




        Random random = new Random();
        int number = random.nextInt(45);
        String[] fortune1 = getResources().getStringArray(R.array.LUCK);
        String fortune;   fortune = fortune1[number];
        String main = fortune.split("\\.")[0];
        String story = "";
        Intent intent = getIntent();
        //String name = intent.getStringExtra("name") + "님의 오늘의 운세";

        print_close = findViewById(R.id.print_close);

        for(String i : fortune.split("\\."))
        {
            if(main.equals(i))
            {
                continue;
            }
            story += i + ".";
        }


        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(story);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(main);
        textView3 = (TextView)findViewById(R.id.textView3);

        SharedPreferences name_save = getSharedPreferences("name_save",MODE_PRIVATE);
        name = name_save.getString("name_save","ERROR") + "님의 오늘의 운세";
        textView3.setText(name);

        print_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent print_intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(print_intent);
            }
        });

    }
    //윤수
}