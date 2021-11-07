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

public class SubActivity2<clickImageView> extends AppCompatActivity {
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


        int[] images_back2 = {R.drawable.aa2, R.drawable.ab2, R.drawable.ac2, R.drawable.ad2,
                R.drawable.ba2, R.drawable.bb2, R.drawable.bc2, R.drawable.bd2, R.drawable.be2,
                R.drawable.ca2, R.drawable.cb2, R.drawable.cc2, R.drawable.cd2,
                R.drawable.da2, R.drawable.db2, R.drawable.dc2, R.drawable.dd2, R.drawable.de2,
                R.drawable.ea2, R.drawable.eb2, R.drawable.ec2, R.drawable.ed2,};

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
                    clickTextView.setBackgroundResource(images_back2[(int) sub_d]);
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
                Intent intent7 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent7);
                //startLoading();
            }// onCreate()..
        });


    }


}
