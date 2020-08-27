package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fortunecookie extends AppCompatActivity {

    Button fortunecookie_close;
    TextView fortunecookie_tv1,fortunecookie_tv2,fortunecookie_bottom_tv,fortunecookie_capture_bottom_tv,fortune_text;
    ImageView cookie_image,cookie_open_image;

    int click_num = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortunecookie);
        fortunecookie_close = findViewById(R.id.fortunecookie_close);
        fortunecookie_tv1 = findViewById(R.id.fortunecookie_tv1);
        fortunecookie_tv2 = findViewById(R.id.fortunecookie_tv2);
        fortunecookie_bottom_tv = findViewById(R.id.fortunecookie_bottom_tv);
        cookie_image = findViewById(R.id.cookie_image);
        cookie_open_image = findViewById(R.id.cookie_open_image);
        fortunecookie_capture_bottom_tv.findViewById(R.id.fortunecookie_capture_bottom_tv);
        fortune_text.findViewById(R.id.fortune_text);
        fortunecookie_bottom_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            click_num++;
            }
        });

        if (click_num == 4){
            Toast.makeText(Fortunecookie.this,"조금만 더 눌러주세요!",Toast.LENGTH_SHORT).show();
        }

        if (click_num == 7){
            Toast.makeText(Fortunecookie.this, "포춘쿠키가 열렸습니다!", Toast.LENGTH_SHORT).show();
            cookie_image.setVisibility(View.GONE);
            cookie_open_image.setVisibility(View.VISIBLE);
            fortunecookie_tv1.setVisibility(View.GONE);
            fortunecookie_tv2.setVisibility(View.GONE);
            fortunecookie_bottom_tv.setVisibility(View.GONE);
            fortunecookie_capture_bottom_tv.setVisibility(View.VISIBLE);
            fortune_text.setVisibility(View.VISIBLE);
        }

        fortunecookie_close.setOnClickListener(new View.OnClickListener() { // 닫기버튼
            @Override
            public void onClick(View v) {
                Intent close = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(close);
            }
        });

        fortunecookie_capture_bottom_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}