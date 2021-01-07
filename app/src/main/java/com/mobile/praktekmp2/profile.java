package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final sharedprefmanager sharedPrefManager = new sharedprefmanager(this);

        TextView username = findViewById(R.id.tvUser);
        TextView logout = findViewById(R.id.tvLogout);

        username.setText(sharedPrefManager.getUsername());


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(profile.this,login2.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(c);
            }
        });
    }
}