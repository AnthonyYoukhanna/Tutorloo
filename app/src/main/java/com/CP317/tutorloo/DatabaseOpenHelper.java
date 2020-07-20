package com.CP317.tutorloo;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "User.db";
    private static final int DATAVASE_VERSION =1;


    //constructor
    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATAVASE_VERSION);

    }
}
