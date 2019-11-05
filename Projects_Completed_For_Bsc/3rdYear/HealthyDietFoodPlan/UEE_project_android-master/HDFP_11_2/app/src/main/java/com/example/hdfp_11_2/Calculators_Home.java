package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Calculators_Home extends AppCompatActivity {

    private Button launchBMICalculatorView,LaunchCalorieCalculatorView,LaunchBodyFatCalculatorView,LaunchWaistToHipView;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_home);

        getSupportActionBar().hide();

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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



        launchBMICalculatorView = (Button)findViewById(R.id.buttonLaunchBMICalculatorView);
        launchBMICalculatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBMICalculatorView();
            }
        });

        LaunchCalorieCalculatorView = (Button)findViewById(R.id.buttonLaunchCalorieCalculatorView);
        LaunchCalorieCalculatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalorieCalculatorView();
            }
        });

        LaunchBodyFatCalculatorView = (Button)findViewById(R.id.buttonLaunchBodyFatCalculatorView);
        LaunchBodyFatCalculatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBodyFatCalculatorView();
            }
        });

        LaunchWaistToHipView = (Button)findViewById(R.id.buttonLaunchWaistToHipView);
        LaunchWaistToHipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchWaistToHipCalculatorView();
            }
        });






    }






    public void launchBMICalculatorView(){
        Intent intent = new Intent(this,BMI_Home.class);
        startActivity(intent);
    }

    public void launchBodyFatCalculatorView(){
        Intent intent = new Intent(this,BodyFat_Home.class);
        startActivity(intent);
    }

    public void launchCalorieCalculatorView(){
        Intent intent = new Intent(this,Calorie_Home.class);
        startActivity(intent);
    }

    public void launchWaistToHipCalculatorView(){
        Intent intent = new Intent(this,WaistToHip_Home.class);
        startActivity(intent);
    }



    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }





}

