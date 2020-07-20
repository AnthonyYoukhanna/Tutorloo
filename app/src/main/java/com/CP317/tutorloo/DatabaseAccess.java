package com.CP317.tutorloo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c= null;

    //Private constuctor so that objext creaction from outside is avoided.

    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);

    }
    //to return the single instance of DB

    public static  DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance  = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open DB

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    //closing db connection

    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    //methods to query and return the result. we need a lot of these

//    public String getAdress(String name){
//        c=db.rawQuery()
//
//    }


}
