package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MBFlavouredWater extends AppCompatActivity {

    ViewFlipper flavoured_water_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbflavoured_water);

        //images for flip
        int images[] = {R.drawable.flavored_water, R.drawable.ginger, R.drawable.cucumber, R.drawable.mint};
        flavoured_water_flipper = findViewById(R.id.flavoured_water_flipper);

        for (int i=0; i<images.length; i++){
            flipImagesLWFlavouredWater(images[i]);
        }
    }

    public void flipImagesLWFlavouredWater(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        flavoured_water_flipper.addView(imageView);
        flavoured_water_flipper.setFlipInterval(1500);//15 seconds
        flavoured_water_flipper.setAutoStart(true);

        //animation
        flavoured_water_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flavoured_water_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
