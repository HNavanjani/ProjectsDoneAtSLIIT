package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class LWGreenTea extends AppCompatActivity {
    ViewFlipper green_tea_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lwgreen_tea);

        //images for flip
        int images[] = {R.drawable.greenteaandmint, R.drawable.leaves, R.drawable.mint};
        green_tea_flipper = findViewById(R.id.green_tea_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesLWGreenTea(images[i]);
        }
    }
    public void flipImagesLWGreenTea(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        green_tea_flipper.addView(imageView);
        green_tea_flipper.setFlipInterval(1500);//15 seconds
        green_tea_flipper.setAutoStart(true);

        //animation
        green_tea_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        green_tea_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
