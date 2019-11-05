package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Cauliflower extends AppCompatActivity {

    ViewFlipper cauliflower_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauliflower);

        //images for flip
        int images[] = {R.drawable.benefitscf, R.drawable.benefitscf2};
        cauliflower_flipper = findViewById(R.id.cauliflower_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesCauliflower(images[i]);
        }
    }
    public void flipImagesCauliflower(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        cauliflower_flipper.addView(imageView);
        cauliflower_flipper.setFlipInterval(1500);//15 seconds
        cauliflower_flipper.setAutoStart(true);

        //animation
        cauliflower_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        cauliflower_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
