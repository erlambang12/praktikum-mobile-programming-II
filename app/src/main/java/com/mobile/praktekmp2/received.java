package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class received extends AppCompatActivity {
    String contoh;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received);

        test = findViewById(R.id.test);

        Intent a = getIntent();
        contoh = a.getStringExtra("praktek");
    }
    @Override
    protected void onResume(){
        super.onResume();
        test.setText(contoh);
    }
}
