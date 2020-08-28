package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fortunecookie extends AppCompatActivity {

    Button fortunecookie_close,fortunecookie_bottom_btn,fortunecookie_capture_bottom_btn;
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
        // Error Part
//        fortunecookie_capture_bottom_btn.findViewById(R.id.fortunecookie_capture_bottom_btn);
//        fortune_text.findViewById(R.id.fortune_text);


        fortunecookie_bottom_btn.setOnClickListener(new View.OnClickListener() {
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
            fortunecookie_bottom_btn.setVisibility(View.GONE);
            fortunecookie_capture_bottom_btn.setVisibility(View.VISIBLE);
            fortune_text.setVisibility(View.VISIBLE);
        }

        fortunecookie_close.setOnClickListener(new View.OnClickListener() { // 닫기버튼
            @Override
            public void onClick(View v) {
                Intent close = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(close);
            }
        });
    }
    public void mOnCaptureClick(View v){
        //전체화면
        View rootView = getWindow().getDecorView();

        File screenShot = ScreenShot(rootView);
        if(screenShot!=null){
            //갤러리에 추가
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(screenShot)));
        }
    }
    public File ScreenShot(View view){
        view.setDrawingCacheEnabled(true);  //화면에 뿌릴때 캐시를 사용하게 한다

        Bitmap screenBitmap = view.getDrawingCache();   //캐시를 비트맵으로 변환

        String filename = "screenshot.png";
        File file = new File(Environment.getExternalStorageDirectory()+"/Pictures", filename);  //Pictures폴더 screenshot.png 파일
        FileOutputStream os = null;
        try{
            os = new FileOutputStream(file);
            screenBitmap.compress(Bitmap.CompressFormat.PNG, 90, os);   //비트맵을 PNG파일로 변환
            os.close();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        view.setDrawingCacheEnabled(false);
        return file;
    }


}