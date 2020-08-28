package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Jobluck extends AppCompatActivity {
    //윤수
    TextView textView7;
    TextView textView8;
    TextView textView9;
    Button jobluck_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        jobluck_close.findViewById(R.id.print_close);
        Random random = new Random();
        int number = random.nextInt(15);
        String[] fortune1 = getResources().getStringArray(R.array.JOB);
        String fortune;   fortune = fortune1[number];
        String main = fortune.split("\\.")[0];
        String story = "";
        Intent intent = getIntent();
        String name = intent.getStringExtra("name") + "님의 직업 운세";

        for(String i : fortune.split("\\."))
        {
            if(main.equals(i))
            {
                continue;
            }
            story += i + ".";
        }


        textView7 = (TextView)findViewById(R.id.textView1);
        textView7.setText(story);
        textView8 = (TextView)findViewById(R.id.textView2);
        textView8.setText(main);
        textView9 = (TextView)findViewById(R.id.textView3);
        textView9.setText(name);

        jobluck_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //윤수
}