package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StudentRegisterActivity extends AppCompatActivity {

    private ImageButton mPrevious;
    private Button mSubmit;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregisterview);

        mPrevious = (ImageButton) findViewById(R.id.RegisterPrevious);
        mSubmit = (Button) findViewById(R.id.submit);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                return;
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this, StudentActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}
