package com.example.user.gogogogogogogogigigigigigigi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for(int i = 0; i < 9; i++)
            voteCount[i]=0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"독서","꽃장식","부채","이레느깡","잠자는","테라스","피아노","소녀들","해변"};

        for(int i = 0; i < imageId.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index] + ": 총 " + voteCount[index] + " 표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), FlipActivity.class);
                intent.putExtra("VoteCount", voteCount);
//                intent.putExtra("ImageName",imgName);
                startActivity(intent);
            }
        });
    }
}
