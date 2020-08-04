package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.R;

public class TutorListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private Database_Helper db;
    private TextView mField1;
    private Button b1;
    private Button b2;
    private Button b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorlistview);

        //Set variables
        db = new Database_Helper(this);
        mField1 = (TextView) findViewById(R.id.Field1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);

        getTutorInfo();
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
                Intent intent = new Intent(TutorListActivity.this, StudentProfileActivity.class);
                startActivity(intent);

                return true;

            case R.id.logout:
                //Needs to be updated
                Intent intent2 = new Intent(TutorListActivity.this, LoginActivity.class);
                startActivity(intent2);
                return true;
            default:
                return false;
        }
    }

    public void getTutorInfo()
    {
        Cursor cursor = null;

        //Get the cursor
        cursor = db.getTutorLCursor();

        b1.setText("");         //For testing purposes
        int i=0;

        //Get an array of the buttons and iterate through that
        Button[] buttonArray = new Button[3];
        buttonArray[0] = b1;
        buttonArray[1]= b2;
        buttonArray[2] = b3;

        //The columns in the database
        String[] columns = {"Tutor_id","Last_Name", "First_Name", "Program","Date_Of_Birth","Email",};

        int index;

        //Iterate through the cursor
        while (cursor.moveToNext())
        {
            index = cursor.getColumnIndexOrThrow("First_Name");
            buttonArray[i].setText( buttonArray[i].getText() +" "+ cursor.getString(index));   //First_Name

            index = cursor.getColumnIndexOrThrow("Last_Name");
            buttonArray[i].setText( buttonArray[i].getText() +" "+ cursor.getString(index));   //Last_Name

            buttonArray[i].setText( buttonArray[i].getText() +"\n");

            index = cursor.getColumnIndexOrThrow("Program");
            buttonArray[i].setText( buttonArray[i].getText() +" "+ cursor.getString(index));   //Program

            buttonArray[i].setTextSize(24);
            i++;
            //mField1.setText(mField1.getText() + cursor.getColumnIndex("Last_Name");
            //Buttons will connect to profile
        }

    }


}
