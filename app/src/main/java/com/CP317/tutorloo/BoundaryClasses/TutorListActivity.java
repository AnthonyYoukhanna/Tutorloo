package com.CP317.tutorloo.BoundaryClasses;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.CP317.tutorloo.Database_Helper;
import com.CP317.tutorloo.R;

public class TutorListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    Database_Helper db;
    private TextView mField1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorlistview);

        //Set variables
        db = new Database_Helper(this);
        mField1 = (TextView) findViewById(R.id.Field1);

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

        int i=0;
        //Iterate through the cursor
        while (cursor.moveToNext())
        {
            mField1.setText(cursor.getString(i));
        }

    }


}
