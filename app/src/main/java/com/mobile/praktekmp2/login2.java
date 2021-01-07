package com.mobile.praktekmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class login2 extends AppCompatActivity {
    sharedprefmanager sharedPrefManager;
    Handler handler = new Handler();
    EditText User,Pass;
    Button btnLogin;
    ProgressBar pbLogin;
    ImageView ivLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        sharedPrefManager = new sharedprefmanager(this);
        User = findViewById(R.id.User);
        Pass = findViewById(R.id.Pass);
        btnLogin = findViewById(R.id.btnSignIn);
        pbLogin = findViewById(R.id.pBLogin);
        ivLogin = findViewById(R.id.ivLogin);
        login();

    }
    private void login(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = User.getText().toString();
                final String password = Pass.getText().toString();

                pbLogin.setVisibility(View.VISIBLE);
                ivLogin.setVisibility(View.GONE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String spuser = sharedPrefManager.getUsername();
                        String sppass = sharedPrefManager.getPassword();

                        Log.d("username","user"+username);
                        Log.d("password","pass"+password);

                        if (username.equals(spuser) && password.equals(sppass)){
                            Intent a = new Intent(login2.this, profile.class);
                            sharedPrefManager.saveIsLogin(true);
                            finishAffinity();
                            startActivity(a);
                        }else {
                            pbLogin.setVisibility(View.GONE);
                            ivLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(login2.this, "username dan password salah lur", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });
    }
}