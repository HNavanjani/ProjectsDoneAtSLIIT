package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PureVegetables extends AppCompatActivity {

    Button cauliflower_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pure_vegetables);

        //navigate to cauliflower
        cauliflower_btn = (Button)findViewById(R.id.cauliflower_button);
        cauliflower_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCauliflower();
            }
        });
    }
    public void launchCauliflower(){
        Intent intent = new Intent(this, Cauliflower.class);
        startActivity(intent);
    }
}
