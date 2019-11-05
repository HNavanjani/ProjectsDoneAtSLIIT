package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Calorie_Calculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button ShowCalorieResultButton,pbuttonCalcCalorieResult,pbtnSetGender;
    private TextView plabelLevelOfactivity;
    public static String Gender,calorieIntakeResult;
    private EditText ptextAgeCalorie,ptextHeightCalorie,ptextWeightCalorie,ptextGenderCalorie;
    private RadioGroup pradioGrp;
    private RadioButton radioSexButton;
    public double dailyCalorieIntake,activitylevelrate,bmr;
    private ImageButton phomebutton;


    String[] activitytypes = { "Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Extra Active" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie__calculator);

        getSupportActionBar().hide();

        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.activitytype);
        plabelLevelOfactivity = (TextView)findViewById(R.id.labelLevelOfactivity);
        ptextAgeCalorie = (EditText)findViewById(R.id.textAgeCalorie);
        ptextHeightCalorie = (EditText)findViewById(R.id.textHeightCalorie);
        ptextWeightCalorie = (EditText)findViewById(R.id.textWeightCalorie);
        ptextGenderCalorie = (EditText)findViewById(R.id.textGenderCalorie);


        addListenerOnButton();



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activitytypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        ShowCalorieResultButton = (Button) findViewById(R.id.buttonShowCalorieResult);
        ShowCalorieResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalorieResult();
            }
        });


        pbuttonCalcCalorieResult = (Button)findViewById(R.id.buttonCalcCalorieResult);
        pbuttonCalcCalorieResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcCalorieResult();
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

                ptextGenderCalorie.setText(radioSexButton.getText());

            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        plabelLevelOfactivity.setText(activitytypes[position]);
        //Toast.makeText(getApplicationContext(), "Selected User: "+activitytypes[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        //
    }


    public void calcCalorieResult() {

        Gender = ptextGenderCalorie.getText().toString();

        double weight = Float.parseFloat(ptextWeightCalorie.getText().toString());
        double height = Float.parseFloat(ptextHeightCalorie.getText().toString());
        double age = Float.parseFloat(ptextAgeCalorie.getText().toString());
        String activitylevel = plabelLevelOfactivity.getText().toString();


        if(activitylevel.equals("Sedentary")){
            activitylevelrate=1.2;
        }
        if(activitylevel.equals("Lightly Active")){
            activitylevelrate=1.375;
        }
        if(activitylevel.equals("Moderately Active")){
            activitylevelrate=1.55;
        }
        if(activitylevel.equals("Very Active")){
            activitylevelrate=1.725;
        }
        if(activitylevel.equals("Extra Active")){
            activitylevelrate=1.9;
        }


        //For men
        if(Gender.equals("Male")) {

            bmr = (10*(weight) + 6.25*(height) - 5*(age) + 5);
        }

        //For Women
        if(Gender.equalsIgnoreCase("Female")) {

            bmr = (10*(weight) + 6.25*(height) - 5*(age) - 161);
        }

       dailyCalorieIntake = roundTwoDecimals((bmr * activitylevelrate));
        calorieIntakeResult = String.valueOf(dailyCalorieIntake);


        AlertDialog.Builder builder = new AlertDialog.Builder(Calorie_Calculator.this);
        builder.setTitle("Calculator Alert")
                .setMessage("Successfully calculated, click on SHOW RESULT button to view the detailed result.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Calorie_Calculator.this,"Click on button: SHOW RESULT",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();


    }



    public void showCalorieResult() {
        Intent intent = new Intent(this, Calorie_Result.class);
        intent.putExtra(Intent.EXTRA_TEXT, calorieIntakeResult);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }
}