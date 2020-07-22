package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TutorActivity extends AppCompatActivity {

    private Button mTutorInfo;
    private ImageButton mInfo;
    private ImageButton mPrevious;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorview);

        mTutorInfo = (Button) findViewById(R.id.change_profile);
        mInfo = (ImageButton) findViewById(R.id.HelpButton);
        mPrevious = (ImageButton) findViewById(R.id.previous_tutorview);

        mTutorInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorActivity.this, TutorInfoActivity.class);
                startActivity(intent);
                return;
            }
        });

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorActivity.this, LoginActivity.class);
                startActivity(intent);
                return;
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorActivity.this, HelpViewActivity.class);
                startActivity(intent);
                return;
            }
        });

    }


}
