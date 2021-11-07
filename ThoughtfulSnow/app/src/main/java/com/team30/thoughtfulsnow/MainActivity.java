package com.team30.thoughtfulsnow;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView clickTextView;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);


        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1500);
        animationDrawable.start();

        clickTextView = findViewById(R.id.textView2);

        clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ButtonActivity.class);
                startActivity(intent);


                //startLoading();
            }// onCreate()..

//    private void startLoading() {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Intent intent= new Intent(getApplicationContext(), ButtonActivity.class);
//                startActivity(intent);  //Loagin화면을 띄운다
//                // 현재 액티비티 종료
//            }
//        }, 3500); // 화면에 Logo 4초간 보이기
//    }// startLoading Method..
        });// MainActivity Class..
    }
}
