package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class timer extends AppCompatActivity {
    TextView textimer;
    Button buttonstart,buttonstop;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Log.i("D3MI01","Activity Oncreate");

        init();
    }
    private void init(){
        textimer = findViewById(R.id.tv_timer);
        buttonstart = findViewById(R.id.bt_start);
        buttonstop = findViewById(R.id.bt_stop);

        if (isMyServiceRunning(timerservice.class)){
            buttonstart.setText("Restart");
        }else{
            buttonstart.setText("Start");
        }

        registerReceiver(broadcastReceiver,new IntentFilter(timerservice.BROADCAST_ACTION));
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceint = new Intent(timer.this,timerservice.class);

                if ( isMyServiceRunning(timerservice.class)){
                    stopService(serviceint);
                }
                startService(serviceint);
                buttonstart.setText("Restart");
                }
        });
    }
    private void updateUI(Intent intent) {
        int mins = intent.getIntExtra("mins", 0);
        int secs = intent.getIntExtra("secs", 0);

        textimer.setText("" + mins + ":" + String.format("%02d", secs));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("D3MI01", "Activity onDestroy");
    }

    private boolean isMyServiceRunning(Class<timerservice> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}