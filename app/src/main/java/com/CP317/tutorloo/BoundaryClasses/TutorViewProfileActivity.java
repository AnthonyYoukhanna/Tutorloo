package com.CP317.tutorloo.BoundaryClasses;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;


public class TutorViewProfileActivity extends AppCompatActivity {
    private Button mDone;
    private ImageButton mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorviewprofile);
        mDone = (Button) findViewById(R.id.Done);
        mBack = (ImageButton)findViewById(R.id.Back);

        mDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorViewProfileActivity.this, EditProfileTutorActivity.class);
                startActivity(intent);
                return;
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorViewProfileActivity.this, TutorActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}