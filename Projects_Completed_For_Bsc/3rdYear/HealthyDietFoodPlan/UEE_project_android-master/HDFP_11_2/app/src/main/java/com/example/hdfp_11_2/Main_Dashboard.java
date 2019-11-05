package com.example.hdfp_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main_Dashboard extends AppCompatActivity {

    private Button pmenu3,food_drinks,loosingtummy;
    private ImageButton phomebutton;
    private Button dietplan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        phomebutton = (ImageButton) findViewById(R.id.homebutton);
        phomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToHome();
            }
        });

        pmenu3 = (Button)findViewById(R.id.menu3);

        pmenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalculatorsView();
            }
        });

        //navigate to healthy drinks and food
        food_drinks = (Button)findViewById(R.id.menu2);
        food_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFoodAndDrinks();
            }
        });

        dietplan = (Button)findViewById(R.id.menuu1);
        dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDietPlan();
            }
        });

        loosingtummy = (Button) findViewById(R.id.menu4);
        loosingtummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchloosingtummy();
            }
        });
    }
    //search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        MenuItem item =menu.findItem(R.id.search);
        android.widget.SearchView searchView=(android.widget.SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String submitText) {



                // Log.e("submit","submit text " + submitText);

                //String a= "Activity2";

                // for (int i=0;i<Activity_Names.length;i++) {

                if (submitText.equals("Food Drinks")||submitText.equals("food drinks")) {
                    Intent intent = new Intent(Main_Dashboard.this,FoodDrinks.class);
                    startActivity(intent);
                    //break;

                }

                else if(submitText.equals("Calculators") || submitText.equals("calculators")){

                    Intent intent = new Intent(Main_Dashboard.this, Calculators_Home.class);
                    startActivity(intent);

                }
                else if(submitText.equals("diet plan") || submitText.equals("Diet plan")){

                    Intent intent = new Intent(Main_Dashboard.this, DietPlanHome.class);
                    startActivity(intent);

                }

                else {
                    Toast.makeText(getApplicationContext(),"Wrong Activity Name", Toast.LENGTH_SHORT).show();
                }

                //}

                //reqActivity = submitText;

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                //Log.e("change","Text changed to "+s);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void launchCalculatorsView(){
        Intent intent = new Intent(this,Calculators_Home.class);
        startActivity(intent);
    }

    public void redirectToHome(){
        Intent intent = new Intent(this,Main_Dashboard.class);
        startActivity(intent);
    }
    public void launchFoodAndDrinks(){
        Intent intent = new Intent(this, FoodDrinks.class);
        startActivity(intent);
    }

    public void launchDietPlan(){
        Intent intent = new Intent(this, DietPlanHome.class);
        startActivity(intent);
    }
    public void launchloosingtummy(){
        Intent intent = new Intent(this,loosing_tummy1.class);
        startActivity(intent);
    }
}
