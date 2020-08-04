package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

public class TutorProfileActivity extends AppCompatActivity {

    private Button mEdit;


    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorprofileview);
        boolean tutor;
        mEdit = (Button) findViewById(R.id.edit_profile);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        tutor = sharedPref.getBoolean("Student", false);

        if (!tutor){
            mEdit.setVisibility(View.VISIBLE);
            mEdit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(TutorProfileActivity.this, TutorInfoActivity.class);
                    startActivity(intent);
                    return;
                }
            });

        }

    }
}
