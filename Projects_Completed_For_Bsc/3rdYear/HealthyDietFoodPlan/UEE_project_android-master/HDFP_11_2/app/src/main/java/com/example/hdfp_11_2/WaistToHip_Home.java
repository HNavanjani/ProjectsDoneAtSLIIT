package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WaistToHip_Home extends AppCompatActivity {

    private Button LaunchWaistToHipCalculator;
    private ImageButton phomebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waist_to_hip__home);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });


        LaunchWaistToHipCalculator = (Button)findViewById(R.id.buttonLaunchWaistToHipCalculator);
        LaunchWaistToHipCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchWaistToHipCalculator();
            }
        });

    }

    public void launchWaistToHipCalculator(){
        Intent intent = new Intent(this,WaistToHip_Calculator.class);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }


}