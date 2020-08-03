package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.R;

public class TutorInfoActivity extends AppCompatActivity {
   private ImageButton mPrevious;
   private Button mSave;
   private EditText mYearofStudy, mProgram, mCourse, mHourlyfee;
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
                //infoValidation();
                return;
            }
        });
    }

    //validate information
    /*public void infoValidation() {
        String program = mProgram.getText().toString();
        String course = mCourse.getText().toString();
        int yearofstudy = Integer.parseInt(String.valueOf(mYearofStudy.getText()));
        double hourlyfee = Double.parseDouble(String.valueOf(mHourlyfee.getText()));
        boolean p_entered, c_entered, y_entered, h_entered;

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

        if(course.contains(","))       //User can only enter 1 course
        {
            mCourse.setError("Enter 1 course");
            c_entered = false;
        }
        else {
            c_entered = true;
        }

        //Check to see if the year of study is empty
        if (mYearofStudy.getText().toString().isEmpty()){
            mYearofStudy.setError("Field cannot be empty");
        }
        y_entered = true;

        //Check to see if the hourly fee has been entered
        if(mHourlyfee.getText().toString().isEmpty()){
            mHourlyfee.setError("Field cannot be empty");
            h_entered = false;}
        else
            h_entered = true;

        //If all required information has been entered
        if(p_entered == true && c_entered == true && y_entered == true && h_entered == true)
        {




        }



    }*/
}
