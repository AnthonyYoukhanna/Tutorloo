package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import android.util.Patterns;

public class TutorRegisterActivity extends AppCompatActivity {

    private ImageButton mPrevious;
    private Button mContinue;
    private EditText mEmail, mFirst, mLast, mPassword, mDOB, mConPass;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorregisterview);

        mPrevious = (ImageButton) findViewById(R.id.RegisterPrevious);
        mContinue = (Button) findViewById(R.id.button3);
        mEmail = (EditText) findViewById(R.id.email);
        mFirst = (EditText) findViewById(R.id.firstName);
        mLast = (EditText) findViewById(R.id.lastName);
        mPassword = (EditText) findViewById(R.id.password);
        mConPass = (EditText) findViewById(R.id.confirmpass);
        mDOB = (EditText) findViewById(R.id.dob);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                return;
            }
        });

        mContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               SetValidation();
                return;
            }
        });
    }

    //-----------Validate email and password-------------
    public void SetValidation() {
        //set inputs to strings
        String email = mEmail.getText().toString();
        String firstname = mFirst.getText().toString();
        String lastname = mLast.getText().toString();
        String password = mPassword.getText().toString();
        String conPassword = mConPass.getText().toString();
        boolean isfirstnamevalid;
        boolean islastnamevalid;
        boolean isEmailValid;
        boolean isPasswordValid;
        boolean isdobValid;

        //validate date of birth
        String stringDOB = mDOB.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        java.util.Date DOB = new java.util.Date();
        try {
            DOB = format.parse(stringDOB);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final java.sql.Date finalDOB = new java.sql.Date(DOB.getTime());

        //Check for valid date of birth
        if (stringDOB.isEmpty()) {
            mDOB.setError("Field can't be empty");
            isdobValid = false;
        }
        else {
            isdobValid = true;
        }
        // Check for a valid first name
        if (firstname.isEmpty()) {
            mFirst.setError("Field can't be empty");
            isfirstnamevalid = false;
        } else  {
            isfirstnamevalid = true;
        }

        // Check for a valid last name
        if (lastname.isEmpty()) {
            mLast.setError("Field can't be empty");
            islastnamevalid = false;
        } else  {
            islastnamevalid = true;
        }

        // Check for a valid email address.
        if (email.isEmpty()) {
            mEmail.setError("Field can't be empty");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("Please enter a valid email address");
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }


        // Check for a valid password.
        if (password.isEmpty()) {
            mPassword.setError("Field can't be empty");
            isPasswordValid = false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            mPassword.setError("Must contain at least 4 characters, any letter, and any speical character");
            isPasswordValid = false;
        } else if(!conPassword.equals(password)) {
            mConPass.setError("Passwords do not match");
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isfirstnamevalid && isEmailValid && islastnamevalid && isPasswordValid && isdobValid) {
            //-----------------Check if user was inserted in the database------------
            //boolean insert = db.insertStudent(firstname,lastname,email,password, finalDOB);
            //if (insert == true){
                Toast.makeText(TutorRegisterActivity.this, "Successfully Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TutorRegisterActivity.this, TutorInfoActivity.class);
                startActivity(intent);
                finish();
                return;
            //}
        }

    }


}
