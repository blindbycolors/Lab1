package com.example.yangm89.myfirstapplication;

import android.content.res.Configuration;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_landscape);
        } else {
            setContentView(R.layout.activity_portrait);
        }
        //this leaves the keyboard hidden on load
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        //random image generator
        generateRandomImg();
    }

    public void selectCard(View view){
        ImageView imageView = (ImageView) view;
        ImageView c1 = (ImageView) findViewById(R.id.imageView_card1);
        ImageView c2 = (ImageView) findViewById(R.id.imageView_card2);
        ImageView c3 = (ImageView) findViewById(R.id.imageView_card3);
        Log.e("imageview", imageView.getId()+"");

        if(imageView.equals(c1)){
            Log.e("c1",c1.getId()+"");
            if(((ColorDrawable)c1.getBackground()) != null) {

            }
            else {
                c1.setBackgroundColor(ContextCompat.getColor(this, R.color.cardBackgroundSkyBlue));
                if(((ColorDrawable)c2.getBackground()) != null) {
                    c2.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
                }
            }
        }
        if(imageView.equals(c2)) {
            Log.e("c2",c2.getId()+"");
            if(((ColorDrawable)c2.getBackground()) != null) {

            }
            else {
                imageView.setBackgroundColor(ContextCompat.getColor(this, R.color.cardBackgroundSkyBlue));
                if(((ColorDrawable)c1.getBackground()) != null) {
                    c1.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
                }
            }
        }




    }

    public void generateRandomImg() {
        TypedArray cards = getResources().obtainTypedArray(R.array.my_cards);
        Random random = new Random();
        Log.e("cards", cards.length()+"");
        int randomIndexOne = random.nextInt(53);
        int randomIndexTwo = random.nextInt(53);
        while(randomIndexOne == randomIndexTwo) {
            randomIndexTwo = random.nextInt(53);
        }
        int randomIndexThree = random.nextInt(53);
        while(randomIndexOne == randomIndexThree || randomIndexTwo == randomIndexOne) {
            randomIndexThree = random.nextInt(53);
        }

        int rndImageC1 = cards.getResourceId(randomIndexOne, 0);
        int rndImageC2 = cards.getResourceId(randomIndexTwo, 0);
        int rndImageC3 = cards.getResourceId(randomIndexThree, 0);

        ImageView viewC1 = (ImageView) findViewById(R.id.imageView_card1);
        ImageView viewC2 = (ImageView) findViewById(R.id.imageView_card2);
        ImageView viewC3 = (ImageView) findViewById(R.id.imageView_card3);
        viewC1.setImageResource(rndImageC1);
        viewC2.setImageResource(rndImageC2);
        viewC3.setImageResource(rndImageC3);


    }
}
