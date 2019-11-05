package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class LWCitrusDrink extends AppCompatActivity {

    ViewFlipper citrus_drink_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lwcitrus_drink);

        //images for flip
        int images[] = {R.drawable.belly_shrink_citrusy, R.drawable.grapefruit, R.drawable.pomegranate, R.drawable.honey};
        citrus_drink_flipper = findViewById(R.id.citrus_drink_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesLWCitrusDrink(images[i]);
        }
    }
    public void flipImagesLWCitrusDrink(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        citrus_drink_flipper.addView(imageView);
        citrus_drink_flipper.setFlipInterval(1500);//15 seconds
        citrus_drink_flipper.setAutoStart(true);

        //animation
        citrus_drink_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        citrus_drink_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
