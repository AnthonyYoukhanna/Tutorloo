package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

public class TutorInfoActivity extends AppCompatActivity {
   private ImageButton mPrevious;
   private Button mSave;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorinfoview);


        mPrevious = (ImageButton) findViewById(R.id.previous5);
        mSave = (Button) findViewById(R.id.button2);


        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorInfoActivity.this, TutorRegisterActivity.class);
                startActivity(intent);
                return;
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorInfoActivity.this, TutorActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}
