package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class FoodDrinks extends AppCompatActivity {

    ViewFlipper image_flipper;
    Button food_button,drink_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_drinks);

        //navigate to healthy drinks
        drink_button = (Button)findViewById(R.id.button_id_drink);
        drink_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHealthyDrinks();
            }
        });
        //navigate to healthy food
        food_button = (Button)findViewById(R.id.button_id_food);
        food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHealthyFood();
            }
        });
        //image flipper
        int images[] = {R.drawable.food, R.drawable.juice, R.drawable.blackcoffee};
        image_flipper = findViewById(R.id.flipper_image);

        for (int i=0; i<images.length; i++){
            flipperImages(images[i]);
        }
    }
    public void launchHealthyDrinks(){
        Intent intent = new Intent(this, HealthyDrinks.class);
        startActivity(intent);
    }
    public void launchHealthyFood(){
        Intent intent = new Intent(this, HealthyFood.class);
        startActivity(intent);
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        image_flipper.addView(imageView);
        image_flipper.setFlipInterval(1500);//15 seconds
        image_flipper.setAutoStart(true);

        //animation
        image_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        image_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
