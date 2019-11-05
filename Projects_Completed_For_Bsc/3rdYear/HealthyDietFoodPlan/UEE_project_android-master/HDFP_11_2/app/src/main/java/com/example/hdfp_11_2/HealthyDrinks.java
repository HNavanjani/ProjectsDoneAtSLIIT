package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Random;

public class HealthyDrinks extends AppCompatActivity {

    ViewFlipper drinks_image_flipper;
    Button answer1, answer2, answer3;
    TextView question;

    //create questionnaire
    McqQuestions mcq = new McqQuestions();

    private String mAnswer;
    private String preferences[] = null;
    private int mQuestionLen = mcq.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_drinks);

        //images for flip
        int images[] = {R.drawable.juiceslide1, R.drawable.juiceslide2, R.drawable.juiceslide3};
        drinks_image_flipper = findViewById(R.id.drinks_image_flipper);

        for (int i=0; i<images.length; i++){
            flipDrinkImages(images[i]);
        }

        //regarding questionnair
        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);

        question = (TextView) findViewById(R.id.questions_text_view);

        updateQuestion(r.nextInt(mQuestionLen));

        //navigate to lose weight
        answer1 = (Button)findViewById(R.id.answer1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchLoseWeight();
            }
        });
        //navigate to Metabolism Boosting
        answer2 = (Button)findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMetabolismBoosting();
            }
        });
        //navigate to Gut Cleansing
        answer3 = (Button)findViewById(R.id.answer3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGutCleansing();
            }
        });

    }
    public void flipDrinkImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        drinks_image_flipper.addView(imageView);
        drinks_image_flipper.setFlipInterval(1500);//15 seconds
        drinks_image_flipper.setAutoStart(true);

        //animation
        drinks_image_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        drinks_image_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    //method to update questions
    private void updateQuestion(int num){
        question.setText(mcq.getQuestion(num));
        answer1.setText(mcq.getChoice1(num));
        answer2.setText(mcq.getChoice2(num));
        answer3.setText(mcq.getChoice3(num));
    }
    public void launchLoseWeight(){
        Intent intent = new Intent(this, WeightLoseDrinks.class);
        startActivity(intent);
    }
    public void launchMetabolismBoosting(){
        Intent intent = new Intent(this, MetabolismBoostingDrinks.class);
        startActivity(intent);
    }
    public void launchGutCleansing(){
        Intent intent = new Intent(this, GutCleanserDrinks.class);
        startActivity(intent);
    }
}
