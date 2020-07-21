package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private ImageButton mInfo;
    private ImageButton mPrevious;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerview);
        mInfo = (ImageButton) findViewById(R.id.HelpButton);
        mPrevious = (ImageButton) findViewById(R.id.previous);

        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, HelpViewActivity.class);
                startActivity(intent);
                return;
            }
        });

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}
