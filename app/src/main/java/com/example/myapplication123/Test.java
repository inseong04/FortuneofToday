package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Test extends AppCompatActivity {

    TextView test_textView1,test_textView2,test_textView3;
    Button test_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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


        test_textView1 = (TextView)findViewById(R.id.test_textView1);
        test_textView1.setText(story);
        test_textView2 = (TextView)findViewById(R.id.test_textView2);
        test_textView2.setText(main);
        test_textView3 = (TextView)findViewById(R.id.test_textView3);
        test_textView3.setText(name);

    test_close.findViewById(R.id.test_close);
    test_close.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent test_intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(test_intent);
        }
    });
    }
}