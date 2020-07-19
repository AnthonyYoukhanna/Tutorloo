package com.CP317.tutorloo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mRegister;
    private Button mTutorLogin;
    private ImageButton mInfo;
    private EditText mEmail, mPassword;
    //DatabaseHelper myDb = new DatabaseHelper(getApplicationContext());

    // private authentification through sqlite
    // private authentication listener?

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginview);

        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.RegisterButton);
        mTutorLogin = (Button) findViewById(R.id.tutor_login);
        mInfo = (ImageButton) findViewById(R.id.HelpButton);


        mEmail = (EditText) findViewById(R.id.Email_input);
        mPassword = (EditText) findViewById(R.id.password_input);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString(); //Add auth through sqlite db
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        mTutorLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, TutorActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HelpViewActivity.class);
                startActivity(intent);
                return;
            }
        });
    }

}
