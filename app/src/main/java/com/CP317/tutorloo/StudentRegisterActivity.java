package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StudentRegisterActivity extends AppCompatActivity {

    private ImageButton mInfo;
    private ImageButton mPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregisterview);

        mInfo = (ImageButton) findViewById(R.id.helpButton);
        mPrevious = (ImageButton) findViewById(R.id.previous2);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                return;
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this, HelpViewActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}
