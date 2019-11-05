package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendedDrinks extends AppCompatActivity {

    Button green_tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_drinks);

        //navigate to green tea
        green_tea = (Button)findViewById(R.id.green_tea_button);
        green_tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGreenTea();
            }
        });

    }
    public void launchGreenTea(){
        Intent intent = new Intent(this, LWGreenTea.class);
        startActivity(intent);
    }
}
