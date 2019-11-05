package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherFood extends AppCompatActivity {

    Button almond_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_food);

        //navigate to almonds
        almond_btn = (Button)findViewById(R.id.almond_button);
        almond_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAlmonds();
            }
        });
    }
    public void launchAlmonds(){
        Intent intent = new Intent(this, Almonds.class);
        startActivity(intent);
    }
}
