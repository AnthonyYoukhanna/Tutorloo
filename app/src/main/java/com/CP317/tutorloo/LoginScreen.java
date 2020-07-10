package com.CP317.tutorloo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    private Button mLogin, mRegister;
    private EditText mEmail, mPassword;

    // private authentification through sqlite
    // private authentication listener?

    @Override

    protected  void oNCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);

            mLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

            mRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

}
