package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class BMI_Result extends AppCompatActivity {

    private EditText pbmimtericResult;
    private TextView pvalueBMIResult,pvalueAge,pvalueHeight,pvalueWeight,pvalueGender;
    public double BMIValueDouble;
    private Button pbuttonBMITryAgain,pButtonBMIShare;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__result);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        pbmimtericResult = (EditText) findViewById(R.id.bmimtericResult);
        pvalueBMIResult = (TextView) findViewById(R.id.valueBMIResult);
        pvalueAge = (TextView)findViewById(R.id.valueAge);
        pvalueHeight = (TextView)findViewById(R.id.valueHeight);
        pvalueWeight = (TextView)findViewById(R.id.valueWeight);
        pvalueGender = (TextView)findViewById(R.id.valueGender);
        pbuttonBMITryAgain = (Button)findViewById(R.id.buttonBMITryAgain);
        pButtonBMIShare = (Button) findViewById(R.id.ButtonBMIShare);

        Intent intent = getIntent();

        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        pvalueBMIResult.setText(text);
        BMIValueDouble = Double.parseDouble(text);

        String pResultStatusBMI = intent.getStringExtra(Intent.EXTRA_RETURN_RESULT);
        pbmimtericResult.setText(pResultStatusBMI);

        String gender = intent.getStringExtra(Intent.EXTRA_REFERRER);
        pvalueGender.setText(gender+"|");

        String age = intent.getStringExtra(Intent.EXTRA_TITLE);
        pvalueAge.setText(age+"yr|");

        String height= intent.getStringExtra(Intent.EXTRA_STREAM);
        pvalueHeight.setText(height+"cm|");

        String weight= intent.getStringExtra(Intent.EXTRA_SUBJECT);
        pvalueWeight.setText(weight+"kg");

        pbuttonBMITryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMITryAgain();
            }
        });


        pButtonBMIShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMIShare();
            }
        });



    }


    public void BMITryAgain(){
        Intent intent = new Intent(this,BMI_Calculator.class);
        startActivity(intent);
    }



    public void BMIShare(){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String shareResult = pbmimtericResult.getText().toString()+pvalueBMIResult.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareResult);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }


}