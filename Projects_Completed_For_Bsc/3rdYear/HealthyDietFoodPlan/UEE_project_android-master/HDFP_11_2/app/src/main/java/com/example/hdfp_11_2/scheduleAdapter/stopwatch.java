package com.example.hdfp_11_2.scheduleAdapter;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hdfp_11_2.R;

public class stopwatch extends AppCompatActivity {

    private Button buttonstart,buttonstop,btnpuse;
    Animation rota;
    ImageView icanchr;
    Chronometer timmer;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        buttonstart = (Button) findViewById(R.id.button25);
        buttonstop = (Button) findViewById(R.id.button26);
        icanchr = findViewById(R.id.imageView5);
        timmer = findViewById(R.id.timmer);
        btnpuse = findViewById(R.id.button26);
        buttonstop.setAlpha(0);


//button stop
        //  button16.setAlpha(0);
        rota = AnimationUtils.loadAnimation(this, R.anim.rota);

        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchr.startAnimation(rota);
                buttonstop.animate().alpha(1).setDuration(600).start();
                buttonstart.animate().alpha(0).setDuration(300).start();

                //timmer set
                timmer.setBase(SystemClock.elapsedRealtime());
                timmer.start();


            }
        });

    }
    public void pusebutton(View view) {
        if (running) {
            timmer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - timmer.getBase();
            running = false;
        }
    }
    public void stoptime(View view) {
        timmer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        timmer.stop();
    }
}
