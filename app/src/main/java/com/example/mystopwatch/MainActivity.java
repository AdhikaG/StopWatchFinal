package com.example.mystopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean Run;
    private long pauseOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");

        chronometer.setBase(SystemClock.elapsedRealtime());

/*        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime() - chronometer.getBase())) >= 10000000

            }
        });*/
    }

    public void startChronometer(View view) {

        if (!Run) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOff);
            chronometer.start();
            Run = true;

        }

    }

    public void pauseChronometer(View view) {

        if (Run) {
            chronometer.stop();
            pauseOff = SystemClock.elapsedRealtime() - chronometer.getBase();
             Run = false;

        }
    }

    public void resetChronometer(View view) {

        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOff=0;

    }

}