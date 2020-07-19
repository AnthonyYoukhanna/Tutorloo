package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TutorInfoActivity extends AppCompatActivity {
   private ImageButton mInfo;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorinfoview);

        mInfo = (ImageButton) findViewById(R.id.HelpButton);

        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorInfoActivity.this, HelpViewActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}
