package com.example.hdfp_11_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class FoodsToAvoidDay03 extends AppCompatActivity {
    ViewPager mviewPager;
    FoodsToAvoidAdapter foodsToAvoidAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_to_avoid_day03);

        mviewPager=findViewById(R.id.foodsviewpager1);
        foodsToAvoidAdapter = new FoodsToAvoidAdapter(getSupportFragmentManager());
        mviewPager.setAdapter(foodsToAvoidAdapter);
    }
}
