package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Calorie_Result extends AppCompatActivity {

    private TextView ptextResultCalorie;
    private Button pbuttonCalorieTryAgain,pButtonCalorieShare;
    private ImageButton phomebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie__result);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        ptextResultCalorie = (TextView) findViewById(R.id.textResultCalorie);
        pbuttonCalorieTryAgain = (Button) findViewById(R.id.buttonCalorieTryAgain);
        pButtonCalorieShare = (Button) findViewById(R.id.ButtonCalorieShare);

        Intent intent = getIntent();

        String CalorieResult = intent.getStringExtra(Intent.EXTRA_TEXT);
        ptextResultCalorie.setText(CalorieResult+" Calories");

        pbuttonCalorieTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalorieTryAgain();
            }
        });

        pButtonCalorieShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalorieShare();
            }
        });



        TextView ptextinfoCalorie = (TextView)findViewById(R.id.textinfoCalorie);

        InputStream inputStream = getResources().openRawResource(R.raw.calorieinfo);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String myText = "";

        int in;
        try {
            in = inputStream.read();
            while (in != -1)
            {
                byteArrayOutputStream.write(in);
                in = inputStream.read();
            }
            inputStream.close();

            myText = byteArrayOutputStream.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }

        ptextinfoCalorie.setText(myText);
    }



    public void CalorieTryAgain(){
        Intent intent = new Intent(this,Calorie_Calculator.class);
        startActivity(intent);
    }

    public void CalorieShare(){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String shareResult = ("To Maintain Current Weight, You Need Daily Calorie Intake of :")+ptextResultCalorie.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareResult);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }

}
