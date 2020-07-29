package com.CP317.tutorloo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class TutorListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorlistview);

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
}