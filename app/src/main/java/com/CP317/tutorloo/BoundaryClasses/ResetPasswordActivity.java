package com.CP317.tutorloo.BoundaryClasses;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private ImageView mPrevious;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        mPrevious = (ImageView) findViewById(R.id.resetPrevious);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}