package com.example.hdfp_11_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hdfp_11_2.scheduleAdapter.ScheduleAdapterFive;

public class NonVegDayFive extends AppCompatActivity {
    private Button bottumbuttonday01;
    private Button bottumbuttonday02;
    private Button bottumbuttonday03;
    private Button bottumbuttonday04;
    private Button bottumbuttonday05;
    private Button bottumbuttonday06;
    private Button bottumbuttonday07;

    private Button foodAvoid;

    private Button tip1;

    private Button exercise;

    Spinner spinner;
    String foods []={"6 tomatoes","Once cup of brown rice","12 to 15 glasses of water"};
    ArrayAdapter<String> arrayAdapter;
    ViewPager mviewPager;
    ScheduleAdapterFive scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_day_five);

        spinner=(Spinner)findViewById(R.id.nonvegfood_snipper5);
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"selected"+foods[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mviewPager=findViewById(R.id.scheduleflipper5);
        scheduleAdapter = new ScheduleAdapterFive(getSupportFragmentManager());
        mviewPager.setAdapter(scheduleAdapter);


        //bottum buttons
        bottumbuttonday01=(Button) findViewById(R.id.bottom_btn_day1);
        bottumbuttonday01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome1();
            }
        });

        bottumbuttonday02=(Button) findViewById(R.id.bottom_btn_day2);
        bottumbuttonday02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome2();
            }
        });

        bottumbuttonday03=(Button) findViewById(R.id.bottom_btn_day3);
        bottumbuttonday03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome3();
            }
        });

        bottumbuttonday04=(Button) findViewById(R.id.bottom_btn_day4);
        bottumbuttonday04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome4();
            }
        });

        bottumbuttonday05=(Button) findViewById(R.id.bottom_btn_day5);
        bottumbuttonday05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome5();
            }
        });

        bottumbuttonday06=(Button) findViewById(R.id.bottom_btn_day6);
        bottumbuttonday06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome6();
            }
        });

        bottumbuttonday07=(Button) findViewById(R.id.bottom_btn_day7);
        bottumbuttonday07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNonVegHome7();
            }
        });

        foodAvoid=(Button)findViewById(R.id.foodstoavoid);
        foodAvoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFoodsToAvoid();
            }
        });

        foodAvoid=(Button)findViewById(R.id.foodstoavoid);
        foodAvoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFoodsToAvoid();
            }
        });

        tip1=(Button)findViewById(R.id.tip_day);
        tip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchtip();
            }
        });

        exercise=(Button)findViewById(R.id.exercise_btn);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchExercise();
            }
        });

    }
    public void launchNonVegHome1(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this, NonVegDayOne.class);
        startActivity(intent);
    }

    public void launchNonVegHome2(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this, NonVegDayTwo.class);
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
        Intent intent=new Intent(this, NonVegDayFive.class);
        startActivity(intent);
    }

    public void launchNonVegHome6(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this,NonVegDaySix.class);
        startActivity(intent);
    }

    public void launchNonVegHome7(){
        //here we open our activity which needs to be open when we press on the button
        Intent intent=new Intent(this, NonVegDaySeven.class);
        startActivity(intent);
    }

    public void launchFoodsToAvoid(){
        Intent intent=new Intent(this, FoodsToAvoidDay05.class);
        startActivity(intent);
    }
    public void launchtip(){
        Intent intent=new Intent(this, Day05TipsToFollow.class);
        startActivity(intent);
    }

    public void launchExercise(){
        Intent intent=new Intent(this, ExerciseHome.class);
        startActivity(intent);
    }

}
