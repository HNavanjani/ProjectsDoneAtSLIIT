package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeightLoseDrinks extends AppCompatActivity {

   Button citrus_drink,recom_drinks,green_tea,tomato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_lose_drinks);

        //navigate to Citrus drink
        citrus_drink = (Button)findViewById(R.id.citrus_drink_button);
        citrus_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCitursDrink();
            }
        });
        //navigate to Recommended drinks
        recom_drinks = (Button)findViewById(R.id.recom_best_drinks);
        recom_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRecommendedDrinks();
            }
        });
        //navigate to green tea
        green_tea = (Button)findViewById(R.id.green_tea_button);
        green_tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGreenTea();
            }
        });
    }
    public void launchCitursDrink(){
        Intent intent = new Intent(this, LWCitrusDrink.class);
        startActivity(intent);
    }
    public void launchGreenTea(){
        Intent intent = new Intent(this, LWGreenTea.class);
        startActivity(intent);
    }
    public void launchRecommendedDrinks(){
        Intent intent = new Intent(this, RecommendedDrinks.class);
        startActivity(intent);
    }
}
