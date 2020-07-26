package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class StudentProfileActivity extends AppCompatActivity {

    private Button mEditProfile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofileview);

        mEditProfile = (Button) findViewById(R.id.Edit);

        mEditProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(StudentProfileActivity.this, EditProfileStudentActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}
