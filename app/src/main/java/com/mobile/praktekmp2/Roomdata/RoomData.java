package com.mobile.praktekmp2.Roomdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobile.praktekmp2.R;

public class RoomData extends AppCompatActivity {
    Button buttambah,buttampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);

        buttambah = findViewById(R.id.buttambah);
        buttampil = findViewById(R.id.buttampil);

        buttambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(RoomData.this,Tambahdata.class);
                startActivity(h);
            }
        });
        buttampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(RoomData.this,Viewdata.class);
                startActivity(l);
            }
        });
    }

}