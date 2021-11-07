package com.team30.thoughtfulsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.team30.thoughtfulsnow.R;

public class chooseCard2 extends AppCompatActivity {

//    public static Context context_main;
//    public int d;

    int count = 0;
    int j = 0;
    private TextView[] cardText = new TextView[22];  //TextView의 아이디를 넣을 곳
    private TextView clickTextView;  //클릭된 카드의 숫자를 받아 오는 곳
    private boolean[] viewClickCheck = new boolean[22];  //카드가 앞면 또는 뒷면인지 구분하는 곳

    private List<Integer> listNum = new ArrayList<>();  //카드에 들어갈 숫자를 담을 곳

    int[] imagesources = {R.drawable.aa, R.drawable.ab, R.drawable.ac, R.drawable.ad,
            R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.bd, R.drawable.be,
            R.drawable.ca, R.drawable.cb, R.drawable.cc, R.drawable.cd,
            R.drawable.da, R.drawable.db, R.drawable.dc, R.drawable.dd, R.drawable.de,
            R.drawable.ea, R.drawable.eb, R.drawable.ec, R.drawable.ed,};  //카드의 앞면을 4장의 이미지를 이용해 랜덤 하게 표시하기 위한 곳
    //int count = 0;
    //int[] a = new int[22];
    //int k = 0;
    //double d = 0;
    //int count = 0;
    //int count2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_deck);


        //1~4번까지 숫자를 listNum에 넣어 Collections.shuffle(listNum)를 이용해 무작위로 섞어 줍니다.
        for (int i = 1; i < 23; i++) {
            listNum.add(i);
        }
        Collections.shuffle(listNum);

        //22장의 카드만큼 for문을 돌려 위에서 지정한  TextView [] cardText 에 아이디를 지정해 줍니다.
        //String viewName = "image_" + (i + 1) -> TextView의 아이디를 만들어 viewName에 넣어 줍니다.
        //getResources().getIdentifier를 이용해 Textview의 아이디를 가져 옵니다.
        //이렇게 찾은 아이디 값을 cardText배열에 하나씩 넣어 주면 됩니다.
        //listNum에 넣어 둔 숫자들을 cardText[i].setText(String.valueOf(listNum.get(i))) 로 화면에 표시합니다.
        //기본 Textview의 글자 색상은 투명으로 화면에는 보이지 않습니다.
        //viewClickCheck[i] = false -> 카드가 뒷면이면 false 앞면이면 true 입니다.
        for (int i = 0; i < cardText.length; i++) {
            String viewName = "image_" + (i + 1);
            cardText[i] = findViewById(getResources().getIdentifier(viewName, "id", getPackageName()));
            cardText[i].setText(String.valueOf(listNum.get(i)));
            viewClickCheck[i] = false;
        }


        textViewOnClickListener();




    }

    //cardText배열에 들어 있는 각각의 TextView에 setOnClickListener를 달아 줍니다.
    //카드 클릭 시 private View.OnClickListener cardClick로 넘어가 클릭에 관련된 처리를 합니다.
    private void textViewOnClickListener() {
        for (TextView v : cardText) {
            v.setOnClickListener(cardClick(v));
        }
    }

    private void reViewInit() {
        listNum.clear();
        for (int i = 1; i < 5; i++) {
            listNum.add(i);
        }
        Collections.shuffle(listNum);

        for (int i = 0; i < cardText.length; i++) {
            cardText[i].setText(String.valueOf(listNum.get(i)));
            cardText[i].setBackgroundResource(R.drawable.card_back);
            cardText[i].setTextColor(getResources().getColor(R.color.text_transparent));
            viewClickCheck[i] = false;
        }
        textViewOnClickListener();
    }
    //    public static View.OnClickListener context_main;
//    public int d;

//    Toast tMsg = Toast.makeText(chooseCard2.this, "카드는 한장만 선택하세요", Toast.LENGTH_SHORT);
//                        tMsg.show();
    private View.OnClickListener cardClick(final TextView textView) {
        //a[0] = 23;

        //count2 = count;
        return new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                    Random random = new Random();
                    final int d = random.nextInt(22);
                    //final double d = random.nextDouble(22);
                    //final int d = Math.random() * 22;
                    System.out.println(d);

                    //int test_number = 100;
                    Intent intent = new Intent(chooseCard2.this, SubActivity2.class);
                    intent.putExtra("랜덤값", d);
                    clickTextView = findViewById(view.getId());

                    //카드 클릭 시 회전하면 위쪽과 아래쪽 카드 모서리가 잘려서 돌게 됩니다.
                    //setCameraDistance 카메라의 거리 값을 주는 것인데 회전 시 잘리는 이미지를 방지해 줍니다.
                    float scale = getApplicationContext().getResources().getDisplayMetrics().density;
                    final float distance = clickTextView.getCameraDistance() * (scale + (scale / 3));
                    clickTextView.setCameraDistance(distance);

                    //클릭 시 처음 이미지가 회전하는 각도 및 회전하는 시간을 설정할 수 있습니다.
                    //처음 회전이 완료되면 withEndAction이 다음 이미지를 출력합니다.
                    clickTextView.animate().withLayer()
                            .rotationY(90)
                            .setDuration(150)
                            //현재 화면의 카드가 앞면 또는 뒷면인지를 구분한 후 카드의 이미지 교체 및 Textview의 글자 색상을 변경해 줍니다.
                            //!viewClickCheck[Integer.parseInt(clickTextView.getText().toString()) - 1]
                            //viewClickCheck 가 false면 (뒷면) 카드 이미지및 글자색상을 바꿔주며  앞면이 되었으니 viewClickCheck를 true로 변경해 줍니다.
                            //Textview의 숫자를  viewClickCheck의 배열 순서로 사용했습니다.
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    if (!viewClickCheck[Integer.parseInt(clickTextView.getText().toString()) - 1]) {
                                        clickTextView.setBackgroundResource(imagesources[(int) d]);
                                        //clickTextView.setTextColor(getResources().getColor(R.color.text_color));
                                        viewClickCheck[Integer.parseInt(clickTextView.getText().toString()) - 1] = true;
                                    } else {
                                        clickTextView.setBackgroundResource(R.drawable.card_back);
                                        clickTextView.setTextColor(getResources().getColor(R.color.text_transparent));
                                        viewClickCheck[Integer.parseInt(clickTextView.getText().toString()) - 1] = false;
                                    }
                                    clickTextView.setRotationY(-90);
                                    clickTextView.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(250)
                                            .start();
                                }
                            }).start();

                    //Intent intent1 = new Intent(getApplicationContext(), SubActivity.class);
                    //startActivity(intent1);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            startActivity(intent);
                        }

                    }, 490);


                }

        };

    }
}
