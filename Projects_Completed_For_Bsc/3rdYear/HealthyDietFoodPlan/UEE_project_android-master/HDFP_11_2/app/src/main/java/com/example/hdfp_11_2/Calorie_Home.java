package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Calorie_Home extends AppCompatActivity {

    private Button LaunchCalorieCalculator;
    private ImageButton phomebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie__home);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        LaunchCalorieCalculator = (Button) findViewById(R.id.buttonLaunchCalorieCalculator);
        LaunchCalorieCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalorieCalculator();
            }
        });

    }

    public void launchCalorieCalculator() {
        Intent intent = new Intent(this, Calorie_Calculator.class);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }
}
