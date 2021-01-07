package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sharedprefence extends AppCompatActivity {
    private Button simpan;
    private EditText masukandata;
    private TextView output;

    private sharedprefmanager sharedprefmanager;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefence);
        simpan = findViewById(R.id.simpan);
        masukandata = findViewById(R.id.masukandata);
        output = findViewById(R.id.output);

        sharedprefmanager = new sharedprefmanager(this);
        output.setText(sharedprefmanager.getString());
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                Toast.makeText(getApplicationContext(),"Data tersimpan bro!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData(){
        String getkonten = masukandata.getText().toString();
        sharedprefmanager.saveString(getkonten);

        output.setText(sharedprefmanager.getString());

    }
}