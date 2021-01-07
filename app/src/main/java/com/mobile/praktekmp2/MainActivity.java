package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobile.praktekmp2.Roomdata.RoomData;
import com.mobile.praktekmp2.Roomdata.crud_main;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 =  findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.crudbut);
        button7 = findViewById(R.id.timerbut);
    }
    @Override
    protected void onResume(){
        super.onResume();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(getApplicationContext(),received.class);
                a.putExtra("praktek", " hallo lur ");
                startActivity(a);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),activitywithfragment.class);
                startActivity(b);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),sharedprefence.class);
                startActivity(c);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(getApplicationContext(), RoomData.class);
                startActivity(d);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e= new Intent(getApplicationContext(), login2.class);
                startActivity(e);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f=new Intent(getApplicationContext(), crud_main.class);
                startActivity(f);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(getApplicationContext(),timer.class);
                startActivity(g);
            }
        });
    }
}
