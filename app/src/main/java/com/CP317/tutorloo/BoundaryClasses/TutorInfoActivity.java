package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

public class TutorInfoActivity extends AppCompatActivity {
   private ImageButton mPrevious;
   private Button mSave;
   private EditText mYearofStudy, mProgram, mCourse, mHourlyfee;
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
//    public void infoValidation() {
//        String program = mProgram.getText().toString();
//        String course = mCourse.getText().toString();
//        int yearofstudy = Integer.parseInt(String.valueOf(mYearofStudy.getText()));
//        double hourlyfee = Double.parseDouble(String.valueOf(mHourlyfee.getText()));
//        boolean p_entered, c_entered;
//
//        if (program.isEmpty()) {
//            mProgram.setError("Field cannot be empty");
//            p_entered = false;
//        }
//        else {
//            p_entered = true;
//        }
//
//        if (course.isEmpty()) {
//            mCourse.setError("Field cannot be empty");
//            c_entered = false;
//        }
//        else {
//            c_entered = true;
//        }
//
//
//        if (p_entered && c_entered) {
//
//        }
//
//    }
}
