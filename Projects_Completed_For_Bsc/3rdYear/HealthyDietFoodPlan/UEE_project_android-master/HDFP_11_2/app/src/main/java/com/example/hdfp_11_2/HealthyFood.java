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

public class HealthyFood extends AppCompatActivity {

    ViewFlipper food_image_flipper;
    Button answer1, answer2, answer3;
    TextView question;

    //create questionnaire
    McqQuestions mcq = new McqQuestions();

    private String mAnswer;
    private String preferences[] = null;
    private int mQuestionLen = mcq.mQuestionsForFood.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_food);

        //images for flip
        int images[] = {R.drawable.apples, R.drawable.tomatoes};
        food_image_flipper = findViewById(R.id.food_image_flipper);

        for (int i=0; i<images.length; i++){
            flipFoodImages(images[i]);
        }

        //regarding questionnair
        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);

        question = (TextView) findViewById(R.id.questions_text_view);

        updateQuestion(r.nextInt(mQuestionLen));

        //navigate to pure vegetables
        answer1 = (Button)findViewById(R.id.answer1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPureVegetables();
            }
        });
        //navigate to pure fruits
        answer2 = (Button)findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPureFruits();
            }
        });
        //navigate to other food
        answer3 = (Button)findViewById(R.id.answer3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchOtherFood();
            }
        });
    }
    //method to update questions
    private void updateQuestion(int num){
        question.setText(mcq.getQuestionFood(num));
        answer1.setText(mcq.getFoodChoice1(num));
        answer2.setText(mcq.getFoodChoice2(num));
        answer3.setText(mcq.getFoodChoice3(num));
    }
    //image flipper
    public void flipFoodImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        food_image_flipper.addView(imageView);
        food_image_flipper.setFlipInterval(1500);//15 seconds
        food_image_flipper.setAutoStart(true);

        //animation
        food_image_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        food_image_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void launchPureVegetables(){
        Intent intent = new Intent(this, PureVegetables.class);
        startActivity(intent);
    }
    public void launchPureFruits(){
        Intent intent = new Intent(this, PureFruits.class);
        startActivity(intent);
    }
    public void launchOtherFood(){
        Intent intent = new Intent(this, OtherFood.class);
        startActivity(intent);
    }
}
