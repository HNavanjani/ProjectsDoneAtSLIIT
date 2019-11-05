package com.example.hdfp_11_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DietPlanHome extends AppCompatActivity {
    private Button btn_day1;
    private Button btn_day2;
    private Button btn_day3;
    private Button btn_day4;
    private Button btn_day5;
    private Button btn_day6;
    private Button btn_day7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_home);

        btn_day1=(Button) findViewById(R.id.btn_day1);
        btn_day2=(Button) findViewById(R.id.btn_day2);
        btn_day3=(Button) findViewById(R.id.btn_day3);
        btn_day4=(Button) findViewById(R.id.btn_day4);
        btn_day5=(Button) findViewById(R.id.btn_day5);
        btn_day6=(Button) findViewById(R.id.btn_day6);
        btn_day7=(Button) findViewById(R.id.btn_day7);

        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome1();
            }
        });

        btn_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome2();
            }
        });

        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome3();
            }
        });

        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome4();
            }
        });

        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome5();
            }
        });

        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome6();
            }
        });

        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome7();
            }
        });

    }

    public void launchNonVegHome1(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDayOne.class);
        startActivity(intent);
    }

    public void launchNonVegHome2(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDayTwo.class);
        startActivity(intent);
    }

    public void launchNonVegHome3(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDayThree.class);
        startActivity(intent);
    }

    public void launchNonVegHome4(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDayFour.class);
        startActivity(intent);
    }

    public void launchNonVegHome5(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDayFive.class);
        startActivity(intent);
    }

    public void launchNonVegHome6(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDaySix.class);
        startActivity(intent);
    }

    public void launchNonVegHome7(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDaySeven.class);
        startActivity(intent);
    }
}
