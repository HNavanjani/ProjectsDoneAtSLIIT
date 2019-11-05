package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class WaistToHip_Result extends AppCompatActivity {

    private EditText pwaistToHipRatio;
    private Button pbuttonWaistToHipTryAgain,pButtonWaistToHipShare;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waist_to_hip__result);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        pwaistToHipRatio = (EditText) findViewById(R.id.waistToHipRatio);
        pbuttonWaistToHipTryAgain = (Button) findViewById(R.id.buttonWaistToHipTryAgain);
        pButtonWaistToHipShare = (Button) findViewById(R.id.ButtonWaistToHipShare);

        Intent intent = getIntent();

        String waistToHipRatioResult = intent.getStringExtra(Intent.EXTRA_TEXT);
        pwaistToHipRatio.setText(waistToHipRatioResult);


        pbuttonWaistToHipTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WaistToHipTryAgain();
            }
        });

        pButtonWaistToHipShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WaistToHipShare();
            }
        });

    }

    public void WaistToHipTryAgain(){
        Intent intent = new Intent(this,WaistToHip_Calculator.class);
        startActivity(intent);
    }

    public void WaistToHipShare(){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String shareResult = ("Your Waist To Hip Ratio is : ")+pwaistToHipRatio.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareResult);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }

}
