package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Fortunecookie extends AppCompatActivity {

    TextView fortunecookie_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortunecookie);
        fortunecookie_close = findViewById(R.id.fortunecookie_close);

        fortunecookie_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent close = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(close);
            }
        });
    }
}