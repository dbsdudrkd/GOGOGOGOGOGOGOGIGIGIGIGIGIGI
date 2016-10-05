package com.example.user.gogogogogogogogigigigigigigi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

/**
 * Created by USER on 2016-10-05.
 */

public class FlipActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
//        String[] imageName = intent.getStringArrayExtra("ImageName");

        int[] picId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        int[] imgId = {
                R.id.img1,
                R.id.img2,
                R.id.img3,
                R.id.img4,
                R.id.img5,
                R.id.img6,
                R.id.img7,
                R.id.img8,
                R.id.img9,
        };

        int temp;
        for(int i = 0; i < voteResult.length-1; i++){
            for(int j = i+1; j < voteResult.length; j++){
                if(voteResult[i] < voteResult[j]){
                    temp = voteResult[i];
                    voteResult[i] = voteResult[j];
                    voteResult[j] = temp;

                    temp = picId[i];
                    picId[i] = picId[j];
                    picId[j] = temp;
                }
            }
        }

        for (int i = 0; i < voteResult.length; i++) {
            ((ImageView)findViewById(imgId[i])).setImageResource(picId[i]);

        }

        Button btn1, btn2;
        final ViewFlipper viewFlipper1;

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        viewFlipper1 = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                viewFlipper1.setFlipInterval(1000);
                viewFlipper1.startFlipping();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                viewFlipper1.stopFlipping();
            }
        });
    }



}
