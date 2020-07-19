package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TutorActivity extends AppCompatActivity {

    private Button mInfo;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorview);

        mInfo = (Button) findViewById(R.id.change_profile);

        mInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorActivity.this, TutorInfoActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }


}