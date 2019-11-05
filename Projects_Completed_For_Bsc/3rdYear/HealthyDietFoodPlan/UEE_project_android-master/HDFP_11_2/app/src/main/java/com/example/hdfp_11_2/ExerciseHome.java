package com.example.hdfp_11_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ExerciseHome extends AppCompatActivity {

    ViewPager mviewPager;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_home);

        mviewPager=findViewById(R.id.exerciseviewpager);
        exerciseAdapter = new ExerciseAdapter(getSupportFragmentManager());
        mviewPager.setAdapter(exerciseAdapter);
    }
}
