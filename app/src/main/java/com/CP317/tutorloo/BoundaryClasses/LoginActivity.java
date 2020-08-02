package com.CP317.tutorloo.BoundaryClasses;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.R;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mRegister;
    private Button mTutorLogin;
    private ImageButton mInfo;
    private EditText mEmail, mPassword;
    private Button mReset;
    Database_Helper db;
    //DatabaseHelper myDb = new DatabaseHelper(getApplicationContext());

    // private authentification through sqlite
    // private authentication listener?
    // zack test

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginview);

        db = new Database_Helper(this);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.RegisterButton);
        mTutorLogin = (Button) findViewById(R.id.tutor_login);
        mInfo = (ImageButton) findViewById(R.id.HelpButton);
        mReset = (Button) findViewById(R.id.resetpass);


        mEmail = (EditText) findViewById(R.id.Email_input);
        mPassword = (EditText) findViewById(R.id.password_input);


        //--------------Login Validation---------------------
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginValidation();
                return;
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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

        mReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
                return;
            }
        });

    }

    //Login validation
    public void loginValidation() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString(); //Add auth through sqlite db

        //Login validation
        boolean email_entered;
        boolean pass_entered;
        if (email.isEmpty()) {
            mEmail.setError("Please enter an email address");
            email_entered = false;
        }
        else {
            email_entered = true;
        }

        if (password.isEmpty()) {
            mPassword.setError("Please enter your password");
            pass_entered = false;
        }
        else {
            pass_entered = true;
        }

        if (pass_entered && email_entered) {
            boolean user_exists = db.checkStudent(email, password);
            if (user_exists == true) {
                Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
            }
        }

    }



}
