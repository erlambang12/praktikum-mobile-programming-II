package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class timerr extends AppCompatActivity {
    private Chronometer chronometer;
    long pausechr;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timerr);

        chronometer = findViewById(R.id.chrono);
    }
    public void startchrono(View view){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime()- pausechr);
            chronometer.start();
            running = true;
        }
    }
    public void stopchrono(View view){
        if (running){
            chronometer.stop();
            pausechr = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void restartchrono(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pausechr = 0;
    }
}