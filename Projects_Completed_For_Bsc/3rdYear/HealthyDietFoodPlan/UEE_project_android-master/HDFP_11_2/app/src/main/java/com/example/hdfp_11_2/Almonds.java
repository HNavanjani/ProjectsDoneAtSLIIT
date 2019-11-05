package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Almonds extends AppCompatActivity {

    ViewFlipper almond_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almonds);

        //images for flip
        int images[] = {R.drawable.benefitsamd1, R.drawable.benefitsamd2};
        almond_flipper = findViewById(R.id.almond_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesAlmond(images[i]);
        }
    }
    public void flipImagesAlmond(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        almond_flipper.addView(imageView);
        almond_flipper.setFlipInterval(1500);//15 seconds
        almond_flipper.setAutoStart(true);

        //animation
        almond_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        almond_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
