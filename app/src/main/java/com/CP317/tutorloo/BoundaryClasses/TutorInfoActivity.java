package com.CP317.tutorloo.BoundaryClasses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
<<<<<<< HEAD
import android.preference.PreferenceManager;
=======
import android.view.MotionEvent;
>>>>>>> 474094235314ffaf8dae51f21e1b50d3a43c8962
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.EntityClasses.Tutor;
import com.CP317.tutorloo.R;

public class TutorInfoActivity extends AppCompatActivity {
   private ImageButton mPrevious;
   private Button mSave;
   private EditText mYearofStudy, mProgram, mCourse, mHourlyfee, mBio;
   Database_Helper db;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorinfoview);

        mPrevious = (ImageButton) findViewById(R.id.previous5);
        mSave = (Button) findViewById(R.id.button2);
        mYearofStudy = (EditText) findViewById(R.id.yearofstudy);
        mProgram = (EditText) findViewById(R.id.programofstudy);
        mCourse = (EditText) findViewById(R.id.course);
        mHourlyfee = (EditText) findViewById(R.id.hourlyfee);
        mBio = (EditText) findViewById(R.id.Bio);

        mPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TutorInfoActivity.this, TutorRegisterActivity.class);
                startActivity(intent);
                return;
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                infoValidation();
                return;
            }
        });
    }

    //Hides keyboard when clicking off edit text box
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    //validate information
    public void infoValidation() {
        String program = mProgram.getText().toString();
        String course = mCourse.getText().toString();
        String bio = mBio.getText().toString();
        String yearofstudy = mYearofStudy.getText().toString();
        String hourlyfee = mHourlyfee.getText().toString();

        boolean p_entered, c_entered, y_entered, h_entered, b_entered;

        //Check to see if the bio was entered
        if (bio.isEmpty()) {
            mBio.setError("Field cannot be empty");
            b_entered = false;
        }
        else {
            b_entered = true;
        }


        //Check to see if the program was entered
        if (program.isEmpty()) {
            mProgram.setError("Field cannot be empty");
            p_entered = false;
        }
        else {
            p_entered = true;
        }

        //Check to see if the courses were entered (only 1 course can be entered
        if (course.isEmpty()) {
            mCourse.setError("Field cannot be empty");
            c_entered = false;
        }
        else {
            c_entered = true;
        }

        //Check to see if the year of study is empty
        if (mYearofStudy.getText().toString().isEmpty()){
            mYearofStudy.setError("Field cannot be empty");
            y_entered = false;
        }
        else {
            y_entered = true;
        }


        //Check to see if the hourly fee has been entered
        if(mHourlyfee.getText().toString().isEmpty()){
            mHourlyfee.setError("Field cannot be empty");
            h_entered = false;
        }
        else {
            h_entered = true;
        }
        //If all required information has been entered
        if(p_entered && c_entered && y_entered && h_entered)
        {
            Tutor tutor = new Tutor();
            tutor.setCourses(course);
            tutor.setProgram(program);
            tutor.setYear_of_study(yearofstudy);
            tutor.setBiography(bio);
            tutor.setHourlyRate(hourlyfee);

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            String email = sharedPref.getString("Username", null);


            boolean insert = db.insertTutorInfo(tutor, email);
            if (insert){
                Toast.makeText(TutorInfoActivity.this, "Successfully Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TutorInfoActivity.this, TutorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        }
    }
}
