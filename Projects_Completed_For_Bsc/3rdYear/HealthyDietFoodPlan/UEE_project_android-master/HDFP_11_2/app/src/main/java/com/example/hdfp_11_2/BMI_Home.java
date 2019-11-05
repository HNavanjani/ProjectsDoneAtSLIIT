package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BMI_Home extends AppCompatActivity {

    private Button launchBMICalculator;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__home);
        getSupportActionBar().hide();

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        //toolbar.setTitle("Helalthy Diet Food Plan");
        //toolbar.setLogo(R.drawable.ic_menu);

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        launchBMICalculator = (Button)findViewById(R.id.buttonLaunchBMICalculator);
        launchBMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBMICalculator();
            }
        });

    }

    public void launchBMICalculator(){
        Intent intent = new Intent(this,BMI_Calculator.class);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }



}

