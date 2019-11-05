package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class BodyFat_Result extends AppCompatActivity {

    private TextView ptextResultBodyFat;
    private Button pbuttonBodyFatTryAgain,pButtonBodyFatShare;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat__result);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        ptextResultBodyFat = (TextView) findViewById(R.id.textResultBodyFat);
        pbuttonBodyFatTryAgain = (Button)findViewById(R.id.buttonBodyFatTryAgain);
        pButtonBodyFatShare = (Button)findViewById(R.id.ButtonBodyFatShare);

        Intent intent = getIntent();

        String bodyFatResult = intent.getStringExtra(Intent.EXTRA_TEXT);
        ptextResultBodyFat.setText(bodyFatResult+" %");


        pbuttonBodyFatTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyfatTryAgain();
            }
        });


        pButtonBodyFatShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyFatShare();
            }
        });

    }


    public void BodyfatTryAgain(){
        Intent intent = new Intent(this,BodyFat_Calculator.class);
        startActivity(intent);
    }

    public void BodyFatShare(){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String shareResult = ("Your Body Fat Precentage is : ")+ptextResultBodyFat.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareResult);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }

}
