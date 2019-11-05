package com.example.hdfp_11_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class loosingtummy3 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loosingtummy3);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity1();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity2();
            }
        });

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity3();
            }
        });

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity4();
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity5();
            }
        });

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity6();
            }
        });

        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity7();
            }
        });

        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity8();
            }
        });

        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity9();
            }
        });

        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVedioactivity10();
            }
        });
    }
    public void openVedioactivity1(){
        String buttonvalue="1";
        Intent intent = new Intent(this, day1.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity2(){
        String buttonvalue="2";
        Intent intent = new Intent(this, day2.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity3(){
        String buttonvalue="3";
        Intent intent = new Intent(this, day3.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity4(){
        String buttonvalue="4";
        Intent intent = new Intent(this, day4.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity5(){
        String buttonvalue="5";
        Intent intent = new Intent(this, day5.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity6(){
        String buttonvalue="6";
        Intent intent = new Intent(this, day6.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity7(){
        String buttonvalue="7";
        Intent intent = new Intent(this, day7.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity8(){
        String buttonvalue="8";
        Intent intent = new Intent(this, day8.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity9(){
        String buttonvalue="9";
        Intent intent = new Intent(this, day9.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
    public void openVedioactivity10(){
        String buttonvalue="10";
        Intent intent = new Intent(this, day10.class);
        intent.putExtra("value",buttonvalue);
        startActivity(intent);
    }
}
