package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BodyFat_Home extends AppCompatActivity {

    private Button LaunchBodyFatCalculator;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat__home);

        getSupportActionBar().hide();


        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        LaunchBodyFatCalculator = (Button) findViewById(R.id.buttonLaunchBodyFatCalculator);
        LaunchBodyFatCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBodyFatCalculator();
            }
        });

    }

    public void launchBodyFatCalculator() {
        Intent intent = new Intent(this, BodyFat_Calculator.class);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }
}