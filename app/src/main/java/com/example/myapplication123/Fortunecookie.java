package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Fortunecookie extends AppCompatActivity {

    Button fortunecookie_close,fortunecookie_bottom_btn,fortunecookie_restart_btn;
    TextView fortunecookie_tv1,fortunecookie_tv2,fortune_text;
    ImageView cookie_image,cookie_open_image;

    int click_num = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortunecookie);
        fortunecookie_close = findViewById(R.id.fortunecookie_close);
        fortunecookie_tv1 = findViewById(R.id.fortunecookie_tv1);
        fortunecookie_tv2 = findViewById(R.id.fortunecookie_tv2);
        fortunecookie_bottom_btn = findViewById(R.id.fortunecookie_bottom_btn);
        cookie_image = findViewById(R.id.cookie_image);
        cookie_open_image = findViewById(R.id.cookie_open_image);
        fortunecookie_restart_btn = findViewById(R.id.fortunecookie_restart_btn);
        fortune_text = findViewById(R.id.fortune_text);


        fortunecookie_bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            click_num++;
                Log.e("클릭횟수",""+click_num);
                if (click_num == 4){
                    Toast.makeText(getApplicationContext(),"조금만 더 눌러주세요!",Toast.LENGTH_SHORT).show();
                }

                if (click_num == 7){
                    Toast.makeText(getApplicationContext(),"포춘쿠키가 열렸습니다!",Toast.LENGTH_SHORT).show();
                    cookie_image.setVisibility(View.GONE);
                    cookie_open_image.setVisibility(View.VISIBLE);
                    fortunecookie_tv1.setVisibility(View.GONE);
                    fortunecookie_tv2.setVisibility(View.GONE);
                    fortunecookie_bottom_btn.setVisibility(View.GONE);
                    fortune_text.setVisibility(View.VISIBLE);
                    fortunecookie_restart_btn.setVisibility(View.VISIBLE);
                    Random random = new Random();
                    int number = random.nextInt(25);
                    String[] fortune1 = getResources().getStringArray(R.array.cookie);
                    String fortune;   fortune = fortune1[number];
                    fortune_text = (TextView)findViewById(R.id.fortune_text);
                    fortune_text.setText(fortune);
                }
            }
        });

        fortunecookie_close.setOnClickListener(new View.OnClickListener() { // 닫기버튼
            @Override
            public void onClick(View v) {
                Intent close = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(close);
            }
        });

        fortunecookie_restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent restart_intent = new Intent(getApplicationContext(),Fortunecookie.class);
                startActivity(restart_intent);
            }
        });
    }



}