package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activitywithfragment extends AppCompatActivity {
    Button but1,but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitywithfragment);

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfragment(new FragmentSatu());
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfragment(new FragmentKedua());
            }
        });
    }
    private void loadfragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container_frag,fragment);
        fragmentTransaction.commit();
    }
}
