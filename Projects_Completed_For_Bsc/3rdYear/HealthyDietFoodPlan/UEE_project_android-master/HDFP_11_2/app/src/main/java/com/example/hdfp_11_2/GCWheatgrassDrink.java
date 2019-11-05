package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class GCWheatgrassDrink extends AppCompatActivity {

    ViewFlipper wheatgrass_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcwheatgrass_drink);

        int images[] = {R.drawable.wheatgrass, R.drawable.grapes, R.drawable.waterglass, R.drawable.blacksalt};
        wheatgrass_flipper = findViewById(R.id.wheatgrass_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesWheatgrass(images[i]);
        }
    }
    public void flipImagesWheatgrass(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        wheatgrass_flipper.addView(imageView);
        wheatgrass_flipper.setFlipInterval(1500);//15 seconds
        wheatgrass_flipper.setAutoStart(true);

        //animation
        wheatgrass_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        wheatgrass_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
