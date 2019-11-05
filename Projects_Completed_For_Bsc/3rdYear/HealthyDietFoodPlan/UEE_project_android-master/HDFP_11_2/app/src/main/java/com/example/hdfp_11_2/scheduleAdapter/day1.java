package com.example.hdfp_11_2.scheduleAdapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hdfp_11_2.R;

public class day1 extends AppCompatActivity {

    private TextView value;
    private ViewFlipper flipper;
    private Button button;
    private VideoView vediosplay;
    private ViewFlipper exe_image_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);


        button = (Button) findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openstopwatch();
            }
        });


//images for flip
        int images[] = {R.drawable.ex1, R.drawable.ex2, R.drawable.ex3};
        exe_image_flipper = findViewById(R.id.exercise_image_flipper);

        for (int i = 0; i < images.length; i++) {
            flipExerciseImages(images[i]);
        }
    }
    public void openstopwatch(){

        Intent intent = new Intent(this,stopwatch.class);
        startActivity(intent);
    }
    public void flipExerciseImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        exe_image_flipper.addView(imageView);
        exe_image_flipper.setFlipInterval(1500);//15 seconds
        exe_image_flipper.setAutoStart(true);

        //animation
        exe_image_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        exe_image_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void youtubelink(View v){

        Intent youtubelog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VkBxPdqczzo&t=16s"));
        startActivity(youtubelog);
    }

    public void mealLink(View v){
        Intent youtubelog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://healthaegis.com/how-to-lose-belly-fat-in-10-days/"));
        startActivity(youtubelog);
    }
}
