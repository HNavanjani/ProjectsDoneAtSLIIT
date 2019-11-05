package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MetabolismBoostingDrinks extends AppCompatActivity {

    Button recom_drinks,flwater_drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metabolism_boosting_drinks);

        //navigate to Recommended drinks
        recom_drinks = (Button)findViewById(R.id.recom_best_drinks);
        recom_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRecommendedDrinks();
            }
        });
        //navigate to flwater drinks
        flwater_drink = (Button)findViewById(R.id.flwater_drink_button);
        flwater_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFlwaterDrinks();
            }
        });
    }
    public void launchRecommendedDrinks(){
        Intent intent = new Intent(this, RecommendedDrinks.class);
        startActivity(intent);
    }
    public void launchFlwaterDrinks(){
        Intent intent = new Intent(this, MBFlavouredWater.class);
        startActivity(intent);
    }
}
