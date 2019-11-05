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

import com.example.hdfp_11_2.scheduleAdapter.ScheduleAdapterOne;

public class NonVegDayOne extends AppCompatActivity {
    private Button bottumbuttonday01;
    private Button bottumbuttonday02;
    private Button bottumbuttonday03;
    private Button bottumbuttonday04;
    private Button bottumbuttonday05;
    private Button bottumbuttonday06;
    private Button bottumbuttonday07;

    private Button tip1;

    private Button foodAvoid;

    private Button exercise;



    Spinner spinner;
    String foods []={"Apple","Oranges","Watermelon","Kiwi","Papaya","Canataloupe","8 to 12 glass of water"};
    ArrayAdapter<String>arrayAdapter;
    ViewPager mviewPager;
    ScheduleAdapterOne scheduleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_day_one);
        spinner=(Spinner)findViewById(R.id.nonvegfood_snipper1);
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

        mviewPager=findViewById(R.id.scheduleflipper1);
        scheduleAdapter = new ScheduleAdapterOne(getSupportFragmentManager());
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

        tip1=(Button)findViewById(R.id.tip_day);
        tip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchtip();
            }
        });

        foodAvoid=(Button)findViewById(R.id.foodstoavoid);
        foodAvoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFoodsToAvoid();
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

    public void launchtip(){
        Intent intent=new Intent(this, Day01TipsToFollow.class);
        startActivity(intent);
    }

    public void launchFoodsToAvoid(){
        Intent intent=new Intent(this, FoodsToAvoidDay01.class);
        startActivity(intent);
    }

    public void launchExercise(){
        Intent intent=new Intent(this, ExerciseHome.class);
        startActivity(intent);
    }
}
