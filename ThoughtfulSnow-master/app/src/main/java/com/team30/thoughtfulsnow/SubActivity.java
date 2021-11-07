package com.team30.thoughtfulsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class SubActivity<clickImageView> extends AppCompatActivity {
    private TextView clickTextView1;
    private TextView clickTextView;  //클릭된 카드의 숫자를 받아 오는 곳
    //private TextView clickTextView;  //클릭된 카드의 숫자를 받아 오는 곳
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main);

        //int sub_d;

        int[] imagesources = {R.drawable.aa, R.drawable.ab, R.drawable.ac, R.drawable.ad,
                R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.bd, R.drawable.be,
                R.drawable.ca, R.drawable.cb, R.drawable.cc, R.drawable.cd,
                R.drawable.da, R.drawable.db, R.drawable.dc, R.drawable.dd, R.drawable.de,
                R.drawable.ea, R.drawable.eb, R.drawable.ec, R.drawable.ed,};  //카드의 앞면을 4장의 이미지를 이용해 랜덤 하게 표시하기 위한 곳

        int[] images_back1 = {R.drawable.aa1, R.drawable.ab1, R.drawable.ac1, R.drawable.ad1,
                R.drawable.ba1, R.drawable.bb1, R.drawable.bc1, R.drawable.bd1, R.drawable.be1,
                R.drawable.ca1, R.drawable.cb1, R.drawable.cc1, R.drawable.cd1,
                R.drawable.da1, R.drawable.db1, R.drawable.dc1, R.drawable.dd1, R.drawable.de1,
                R.drawable.ea1, R.drawable.eb1, R.drawable.ec1, R.drawable.ed1,};  //카드의 앞면을 4장의 이미지를 이용해 랜덤 하게 표시하기 위한 곳

        Intent intent = getIntent();
        int sub_d = intent.getIntExtra("랜덤값", -1);

        System.out.println(sub_d);


        clickTextView = findViewById(R.id.image_23);
        clickTextView.setBackgroundResource(imagesources[(int) sub_d]);

        clickTextView.setOnClickListener(new View.OnClickListener() {
            int k = 1;

            @Override
            public void onClick(View view) {
                float scale = getApplicationContext().getResources().getDisplayMetrics().density;
                final float distance = clickTextView.getCameraDistance() * (scale + (scale / 3));
                clickTextView.setCameraDistance(distance);
                clickTextView.animate().withLayer()
                        .rotationY(90)
                        .setDuration(300);
                if (k == 1) {
                    clickTextView.setBackgroundResource(images_back1[(int) sub_d]);
                    k = 0;
                }
                else {
                    clickTextView.setBackgroundResource(imagesources[(int) sub_d]);
                    k = 1;
                }
                clickTextView.setRotationY(-90);
                clickTextView.animate().withLayer()
                        .rotationY(0)
                        .setDuration(300)
                        .start();


                //protected AlphaAnimation
//                new Handler().postDelayed(new Runnable() {
//                    public void run() {
//                        Intent intent1 = new Intent(SubActivity.this, foodfinal.class);
//                        intent1.putExtra("랜덤값", sub_d);
//                        startActivity(intent1);
//                    }
//                 }, 2000);
            }


        });
        clickTextView1 = findViewById(R.id.again);
        clickTextView1.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //startLoading();
            }// onCreate()..
        });


    }


}




