package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.R;

public class TutorProfileActivity extends AppCompatActivity {

    private Button mEdit;
    private Database_Helper db;
    private EditText mYear;
    private EditText mName;
    private EditText mProgram;
    private EditText mBio;
    private EditText mRate;
    private EditText mCourses;


    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorprofileview);
        boolean tutor;

        mEdit = (Button) findViewById(R.id.edit_profile);
        mYear = (EditText) findViewById(R.id.tutor_year);
        mName = (EditText) findViewById((R.id.tutor_name));
        mProgram = (EditText) findViewById(R.id.tutor_program);
        mBio = (EditText) findViewById(R.id.white_backer_bio);
        mRate = (EditText) findViewById((R.id.white_backer_hourlyrate));
        mCourses = (EditText) findViewById(R.id.white_backer_courses);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        tutor = sharedPref.getBoolean("Student", false);

        if (!tutor){
            mEdit.setVisibility(View.VISIBLE);
            mEdit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(TutorProfileActivity.this, EditProfileTutorActivity.class);
                    startActivity(intent);
                    return;
                }
            });

        }

        //call display profile
        displayProfile();            //Might not work since we are using another db object

    }


    public void displayProfile()
    {
        Cursor cursor = db.getTutorProfileButton1();
        int index;

        //Iterate through the cursor and display info in the text boxes
        while(cursor.moveToNext())
        {
            //DISPLAY THE NAME
            index = cursor.getColumnIndexOrThrow("First_Name");
            mName.setText(cursor.getString(index));

            //DISPLAY THE LAST NAME
            index = cursor.getColumnIndexOrThrow("Last_Name");
            mName.setText( mName.getText() +" "+ cursor.getString(index));

            //DISPLAY THE YEAR
            index = cursor.getColumnIndexOrThrow("Year_Of_Study");
            mYear.setText(cursor.getString(index));

            //DISPLAY THE PROGRAM
            index = cursor.getColumnIndexOrThrow("Program");
            mProgram.setText(cursor.getString(index));

            //DISPLAY THE BIO
            index = cursor.getColumnIndexOrThrow("Biography");
            mBio.setText(cursor.getString(index));

            //DISPLAY THE HOURLY_FEE
            index = cursor.getColumnIndexOrThrow("Hourly_Fee");
            mRate.setText(cursor.getString(index));

            //DISPLAY THE COURSES
            index = cursor.getColumnIndexOrThrow("Courses");
            mCourses.setText(cursor.getString(index));
        }
    }
}
