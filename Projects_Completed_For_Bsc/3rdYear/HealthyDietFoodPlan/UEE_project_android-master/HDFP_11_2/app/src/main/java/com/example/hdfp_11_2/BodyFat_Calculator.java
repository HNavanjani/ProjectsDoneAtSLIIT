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
import android.widget.Toast;

import java.text.DecimalFormat;

public class BodyFat_Calculator extends AppCompatActivity {

    public static String Gender,bodyfatpercentageResult;
    private Button pbuttonCalcBodyFatResult,pbuttonShowBodyFatResult,pbtnSetGender;
    private EditText ptextGenderBMI,ptextWeightBodyFat,ptextWaistCircumference,ptextWristCircumference,ptextHipCircumference,ptextForearmCircumference;
    public double leanbodymass,bodyfatweight,bodyfatpercentage;
    private RadioGroup pradioGrp;
    private RadioButton radioSexButton;
    private TextView ptextGenderbodyFatCalc;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat__calculator);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });


        pbuttonShowBodyFatResult = (Button) findViewById(R.id.buttonShowBodyFatResult);
        pbuttonCalcBodyFatResult = (Button)findViewById(R.id.buttonCalcBodyFatResult);
        ptextWeightBodyFat = (EditText)findViewById(R.id.textWeightBodyFat);
        ptextWaistCircumference = (EditText)findViewById(R.id.textWaistCircumference);
        ptextWristCircumference = (EditText)findViewById(R.id.textWristCircumference);
        ptextHipCircumference = (EditText)findViewById(R.id.textHipCircumference);
        ptextForearmCircumference = (EditText)findViewById(R.id.textForearmCircumference);
        ptextGenderbodyFatCalc = (TextView) findViewById(R.id.textGenderbodyFatCalc);


        addListenerOnButton();

        pbuttonShowBodyFatResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBodyFatResult();
            }
        });


        pbuttonCalcBodyFatResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcBodyFatResult();
            }
        });

    }


    double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }


    public void addListenerOnButton() {

        pradioGrp = (RadioGroup) findViewById(R.id.radioGrp);
        pbtnSetGender = (Button) findViewById(R.id.btnSetGender);


        pbtnSetGender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = pradioGrp.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                ptextGenderbodyFatCalc.setText(radioSexButton.getText());

            }

        });

    }


    public void calcBodyFatResult() {

        Gender = ptextGenderbodyFatCalc.getText().toString();

        double weight = Float.parseFloat(ptextWeightBodyFat.getText().toString());
        double waist = Float.parseFloat(ptextWaistCircumference.getText().toString());
        double wrist = Float.parseFloat(ptextWristCircumference.getText().toString());
        double hip = Float.parseFloat(ptextHipCircumference.getText().toString());
        double forearm = Float.parseFloat(ptextForearmCircumference.getText().toString());

        //For men
        if(Gender.equals("Male")) {

            double fac1 = (weight * 1.082) + 94.42;
            double fac2 = (waist * 4.15);

            leanbodymass = fac1 - fac2;
        }

        //For Women
        if(Gender.equalsIgnoreCase("Female")) {

            double fac1 = (weight * 0.732+8.987);
            double fac2 = (wrist / 3.140);
            double fac3 = (waist * 0.157);
            double fac4 = (hip * 0.249);
            double fac5 = (forearm * 0.434);

            leanbodymass = fac1 + fac2 - fac3 - fac4 + fac5;
        }

        bodyfatweight = (weight - leanbodymass);
        bodyfatpercentage = roundTwoDecimals(bodyfatweight*100 / weight);
        bodyfatpercentageResult = String.valueOf(bodyfatpercentage);


        AlertDialog.Builder builder = new AlertDialog.Builder(BodyFat_Calculator.this);
        builder.setTitle("Calculator Alert")
                .setMessage("Successfully calculated, click on SHOW RESULT button to view the detailed result.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BodyFat_Calculator.this,"Click on button: SHOW RESULT",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();


    }

    public void showBodyFatResult() {
        Intent intent = new Intent(this, BodyFat_Result.class);
        intent.putExtra(Intent.EXTRA_TEXT, bodyfatpercentageResult);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }


}
