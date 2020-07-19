package com.CP317.tutorloo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "FIRST NAME";
    public static final String COL_2 = "LAST NAME";
    public static final String COL_3 = "DOB";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5= "PASSWORD";
    public static final String COL_6 = "ID";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //database.execSQL(DATABASE_CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }

    public boolean passAuth(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME='?' AND PASSWORD='?';",
                new String[]{email,password});

        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                mCursor.close();
                return true;
            }
        }
        return false;
    }
}
