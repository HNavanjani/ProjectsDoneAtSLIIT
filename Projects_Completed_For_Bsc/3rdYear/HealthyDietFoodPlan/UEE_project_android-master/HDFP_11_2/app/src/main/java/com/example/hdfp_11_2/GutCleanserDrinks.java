package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GutCleanserDrinks extends AppCompatActivity {

    Button recom_drinks,wheat_grass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gut_cleanser_drinks);

        //navigate to Recommended drinks
        recom_drinks = (Button)findViewById(R.id.recom_best_drinks);
        recom_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRecommendedDrinks();
            }
        });
        //navigate to wheatgrass drink
        wheat_grass = (Button)findViewById(R.id.wheategrass_drink_button);
        wheat_grass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchWheatgrassDrinks();
            }
        });
    }
    public void launchRecommendedDrinks(){
        Intent intent = new Intent(this, RecommendedDrinks.class);
        startActivity(intent);
    }
    public void launchWheatgrassDrinks(){
        Intent intent = new Intent(this, GCWheatgrassDrink.class);
        startActivity(intent);
    }
}
