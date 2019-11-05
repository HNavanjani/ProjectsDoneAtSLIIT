package com.example.hdfp_11_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Day03TipsToFollow extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day03_tips_to_follow);

        textView1=(TextView)findViewById(R.id.tiptext1);
        textView2=(TextView)findViewById(R.id.tiptext2);
        textView3=(TextView)findViewById(R.id.tiptext3);
        textView4=(TextView)findViewById(R.id.tiptext4);
        textView5=(TextView)findViewById(R.id.tiptext5);
        textView6=(TextView)findViewById(R.id.tiptext6);

        textView1.setText("It isAdvisable to eat some apples and drink a coulpe of water for breakfast\n");
        textView2.setText("Melons are also a good choice.\nYou can loose up to three pounds by the end of day 1\n");
        textView3.setText("Eating good and less will help you to a certain extent\n");
        textView4.setText("To activate the lipid mobilization, you have to exercise\n");
        textView5.setText("High amount of water intake will flush out the toxins and prepare your body for the next six days of dieting\n");
        textView6.setText("watermelon and cantaloupes are the recomended fruits as they are high in fiber\n");
    }
}
