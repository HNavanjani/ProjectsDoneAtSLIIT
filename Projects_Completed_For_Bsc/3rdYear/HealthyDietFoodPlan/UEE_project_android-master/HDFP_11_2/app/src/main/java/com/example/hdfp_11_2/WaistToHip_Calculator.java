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
import android.widget.Toast;

import java.text.DecimalFormat;

public class WaistToHip_Calculator extends AppCompatActivity {

    private Button pbuttonCalcWaistToHipResult,pbuttonShowWaistToHipResult,pbtnSetGender;
    private EditText ptextHipCircumference,ptextWaistCircumference,ptextGenderWaistToHipCalc;
    public String ResultValueWaistToHipRatio;
    private RadioGroup pradioGrp;
    private RadioButton radioSexButton;
    private ImageButton phomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waist_to_hip__calculator);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        pbuttonCalcWaistToHipResult = (Button) findViewById(R.id.buttonCalcWaistToHipResult);
        pbuttonShowWaistToHipResult = (Button) findViewById(R.id.buttonShowWaistToHipResult);
        ptextHipCircumference = (EditText) findViewById(R.id.textHipCircumference);
        ptextWaistCircumference = (EditText)findViewById(R.id.textWaistCircumference);




        pbuttonCalcWaistToHipResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateWaistToHipRatio();
            }
        });

        pbuttonShowWaistToHipResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWaistToHipResult();
            }
        });

        addListenerOnButton();

    }



    public void addListenerOnButton() {

        pradioGrp = (RadioGroup) findViewById(R.id.radioGrp);
        pbtnSetGender = (Button) findViewById(R.id.btnSetGender);
        ptextGenderWaistToHipCalc = (EditText) findViewById(R.id.textGenderWaistToHipCalc);

        pbtnSetGender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = pradioGrp.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                ptextGenderWaistToHipCalc.setText(radioSexButton.getText());

            }

        });

    }


    float roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Float.valueOf(twoDForm.format(d));
    }

    public void calculateWaistToHipRatio() {
        float waistValue = Float.parseFloat(ptextWaistCircumference.getText().toString());
        float hipValue = Float.parseFloat(ptextHipCircumference.getText().toString());
        float waistToHipRatio = roundTwoDecimals(waistValue/hipValue);
        ResultValueWaistToHipRatio = String.valueOf(waistToHipRatio);


        AlertDialog.Builder builder = new AlertDialog.Builder(WaistToHip_Calculator.this);
        builder.setTitle("Calculator Alert")
                .setMessage("Successfully calculated, click on SHOW RESULT button to view the detailed result.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(WaistToHip_Calculator.this,"Click on button: SHOW RESULT",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();


    }





    public void showWaistToHipResult() {
        Intent intent = new Intent(this, WaistToHip_Result.class);
        intent.putExtra(Intent.EXTRA_TEXT, ResultValueWaistToHipRatio);
        startActivity(intent);
    }


    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }

}