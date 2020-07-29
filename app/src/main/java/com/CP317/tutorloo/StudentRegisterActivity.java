package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentRegisterActivity extends AppCompatActivity {

    Database_Helper db;
    private ImageButton mPrevious;
    private Button mSubmit;
    private EditText mEmail;
    private EditText mFirst;
    private EditText mLast;
    private EditText mPassword;
    private EditText mDOB;
    private EditText mConPass;



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregisterview);
        db = new Database_Helper(this);

        mPrevious = (ImageButton) findViewById(R.id.RegisterPrevious);
        mSubmit = (Button) findViewById(R.id.submit);
        mEmail = (EditText) findViewById(R.id.email);
        mFirst = (EditText) findViewById(R.id.firstName);
        mLast = (EditText) findViewById(R.id.lastName);
        mPassword = (EditText) findViewById(R.id.password);
        mConPass = (EditText) findViewById(R.id.confirmpass);
        mDOB = (EditText) findViewById(R.id.dob);
        AddData();



        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                return;
            }
        });


    }

    public void AddData(){
        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String password = mPassword.getText().toString();
                String conPassword = mPassword.getText().toString();


                String stringDOB = mDOB.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

                java.util.Date DOB = new java.util.Date();
                try {
                    DOB = format.parse(stringDOB);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                final String email = mEmail.getText().toString();
                final String first = mFirst.getText().toString();
                final String last = mLast.getText().toString();
                final String pass = mPassword.getText().toString();
                final java.sql.Date finalDOB = new java.sql.Date(DOB.getTime());
                boolean insert = db.insertStudent(first,last,email,pass, finalDOB);
                if (insert == true){
                    Toast.makeText(StudentRegisterActivity.this, "Successfully Created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentRegisterActivity.this, StudentActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
//                if (password == conPassword){
//
//                }
//                else{
//                    Toast.makeText(StudentRegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }
}
