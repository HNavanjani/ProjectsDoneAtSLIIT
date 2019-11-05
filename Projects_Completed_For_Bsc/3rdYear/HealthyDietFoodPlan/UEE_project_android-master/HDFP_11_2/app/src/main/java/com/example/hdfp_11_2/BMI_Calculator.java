package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import java.text.DecimalFormat;

public class BMI_Calculator extends AppCompatActivity {

    public static String ResultStatusBMI,ResultValueBMI,Age,Height,Weight,Gender;
    private EditText ptextHeightBMI,ptextWeightBMI,ptextAgeBMI,ptextGenderBMI;
    private TextView ptextResultBMI,pvalueGender;
    private Button pbuttonCalculateBMI,ShowBMIResultButton,pbtnSetGender;
    private RadioGroup pradioGrp;
    private RadioButton radioSexButton;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calculator);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });


        ShowBMIResultButton = (Button)findViewById(R.id.buttonShowResultValueBMI);

        ShowBMIResultButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowBMIResult();
            }
        });

        ptextHeightBMI = (EditText)findViewById(R.id.textHeightBMI);
        ptextWeightBMI = (EditText)findViewById(R.id.textWeightBMI);
        ptextGenderBMI = (EditText) findViewById(R.id.textGenderBMI);
        pvalueGender = (TextView) findViewById(R.id.valueGender);
        pbuttonCalculateBMI = (Button)findViewById(R.id.buttonCalculateBMI);
        ptextAgeBMI = (EditText)findViewById(R.id.textAgeBMI);

        pbuttonCalculateBMI.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        pradioGrp = (RadioGroup) findViewById(R.id.radioGrp);
        pbtnSetGender = (Button) findViewById(R.id.btnSetGender);
        ptextGenderBMI = (EditText) findViewById(R.id.textGenderBMI);

        pbtnSetGender.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = pradioGrp.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                ptextGenderBMI.setText(radioSexButton.getText());

            }

        });

    }


    private void calculateBMI() {

        Age = ptextAgeBMI.getText().toString();
        Height = ptextHeightBMI.getText().toString();
        Weight = ptextWeightBMI.getText().toString();
        Gender = ptextGenderBMI.getText().toString();
        float height, weight, bmi,ans;
        height = Float.parseFloat(ptextHeightBMI.getText().toString()) / 100;
        weight = Float.parseFloat(ptextWeightBMI.getText().toString());
        ans = weight / (height * height);
        bmi = roundTwoDecimals(ans);
        ResultValueBMI = String.valueOf(bmi);

        if (bmi < 18.00) {
            ResultStatusBMI = "You're in Under Weight range";
        }
        if ((bmi >= 18.00) && (bmi <= 24.90)) {
            ResultStatusBMI = "You're in Normal Weight range";
        }
        if ((bmi >= 25.00) && (bmi <= 29.90)) {
            ResultStatusBMI = "You're in Over Weight range";
        }
        if (bmi >= 30.00) {
            ResultStatusBMI = "You're in Obese range";
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(BMI_Calculator.this);
        builder.setTitle("Calculator Alert")
                .setMessage("Successfully calculated, click on SHOW RESULT button to view the detailed result.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BMI_Calculator.this,"Click on button: SHOW RESULT",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();


    }

    float roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Float.valueOf(twoDForm.format(d));
    }

    public void ShowBMIResult(){

        Intent intent = new Intent(this,BMI_Result.class);
        intent.putExtra(Intent.EXTRA_TEXT, ResultValueBMI);
        intent.putExtra(Intent.EXTRA_RETURN_RESULT ,ResultStatusBMI);
        intent.putExtra(Intent.EXTRA_TITLE,Age);
        intent.putExtra(Intent.EXTRA_STREAM,Height);
        intent.putExtra(Intent.EXTRA_SUBJECT,Weight);
        intent.putExtra(Intent.EXTRA_REFERRER,Gender);
        startActivity(intent);

    }


    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }




}