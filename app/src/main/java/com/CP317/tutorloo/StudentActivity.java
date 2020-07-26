package com.CP317.tutorloo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentview);


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
                Toast.makeText(this, "Profile button clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout button clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
