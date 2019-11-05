package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Apples extends AppCompatActivity {

    ViewFlipper apples_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);

        //images for flip
        int images[] = {R.drawable.benefitsap, R.drawable.benefitsap2};
        apples_flipper = findViewById(R.id.apples_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesApples(images[i]);
        }
    }
    public void flipImagesApples(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        apples_flipper.addView(imageView);
        apples_flipper.setFlipInterval(1500);//15 seconds
        apples_flipper.setAutoStart(true);

        //animation
        apples_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        apples_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
