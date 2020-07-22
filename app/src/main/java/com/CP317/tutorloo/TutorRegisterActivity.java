package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TutorRegisterActivity extends AppCompatActivity {

    private ImageButton mPrevious;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorregisterview);

        mPrevious = (ImageButton) findViewById(R.id.RegisterPrevious);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}
