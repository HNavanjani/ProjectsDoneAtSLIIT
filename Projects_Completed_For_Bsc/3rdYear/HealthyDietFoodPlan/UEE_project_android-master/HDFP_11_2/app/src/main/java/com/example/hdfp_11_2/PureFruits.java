package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PureFruits extends AppCompatActivity {

    Button apple_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pure_fruits);

        //navigate to apples
        apple_btn = (Button)findViewById(R.id.apples_button);
        apple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchApples();
            }
        });
    }
    public void launchApples(){
        Intent intent = new Intent(this, Apples.class);
        startActivity(intent);
    }
}
