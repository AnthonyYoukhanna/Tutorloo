package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ImageButton;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.R;

public class StudentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //THIS ARRAY IS ONLY FOR TESTING PURPOSES. IT MUST BE UPDATED TO PULL INFO FROM THE DB- REGINA
    private static final String[] COURSES = new String[] {
            "CP104", "CP164", "CP264", "CP216", "CP220", "CP317", "CP386"
    };

    private static final String[] PROGRAMS = new String[] {
            "Computer Science", "BBA & CS", "Psychology & CS", "Math and CS"
    };


    private ImageButton mSearch;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentview);

        //FOR TESTING PURPOSED. MUST BE UPDATED TO TALK TO DB- REGINA
        AutoCompleteTextView searchCourse = findViewById(R.id.searchByCourse);
        ArrayAdapter<String> course_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COURSES);
        searchCourse.setAdapter(course_adapter);

        //FOR TESTING PURPOSED. MUST BE UPDATED TO TALK TO DB- REGINA
        AutoCompleteTextView searchProgram = findViewById(R.id.searchByProgram);
        ArrayAdapter<String> program_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PROGRAMS);
        searchProgram.setAdapter(program_adapter);

        //Search button functionality
        mSearch = (ImageButton) findViewById(R.id.searchButton);

        //Must be updated to show error message if search field is empty. - Regina
        mSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                sendCriteria();
                Intent intent = new Intent(StudentActivity.this, TutorListActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.profile_popup);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent intent = new Intent(StudentActivity.this, StudentProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.logout:
                //Needs to be updated
                Intent intent2 = new Intent(StudentActivity.this, LoginActivity.class);
                startActivity(intent2);
                return true;
            default:
                return false;
        }
    }

    /*This method will send the criteria to the DB_Helper class
      in the form on an array
      array[0] = Name
      array[1] = Course
      array[2] = Program
     */
    public void sendCriteria()
    {
        //Take all the textboxes and put them in an array with 3 indexes
    }


    //Add function here --
    //Create searchByName textbox attribute
    //create searchByCourse textbox attrbiute
    //Create searchByProgram textbox attribute
    //Create searchButton button
    //When button is clicked you, must go tot the next view


}
