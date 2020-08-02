package com.CP317.tutorloo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Date;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Users.db";


    public static final String Table_Name_Student = "Student";
    public static final String Table_Name_tutor = "tutor";
    public static final String Table_Name_user_course = "user_course";
    public static final String Table_Name_user_photo = "user_photo";
    public static final String Table_Name_user_program = "user_program";
    public static final String Table_Name_courses = "courses";
    public static final String Table_Name_programs = "programs";


    public static final String col_1 = "Student_id";
    public static final String col_2 = "Last_Name";
    public static final String col_3 = "First_Name";
    public static final String col_4 = "Date_Of_Birth";
    public static final String col_5 = "Email";
    public static final String col_6 = "Encrypt_Pass";



    public Database_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_Student+" (Student_id INTEGER,Last_Name VARCHAR,First_Name VARCHAR,Date_Of_Birth DATE,Email STRING,Encrypt_Pass VARCHAR) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_tutor+" (Tutor_id INTEGER PRIMARY KEY AUTOINCREMENT,Last_Name VARCHAR,First_Name VARCHAR,Date_Of_Birth DATE,Email STRING,Encrypt_Pass VARCHAR,Biography LONGTEXT,Year_Of_Study INTEGER,Hourly_Fee INTEGER,Rating INTERGER) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_course+" (Course_id SMALLINT,Tutor_id SMALLINT) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_photo+" (Photo_id SMALLINT,Tutor_id SMALLINT,Link TEXT, Time_Added TIMESTAMP, Active BOOLEAN) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_program+" (Program_id SMALLINT,Tutor_id SMALLINT) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_courses+" (Course_id SMALLINT,Name VARCHAR) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_programs+" (Program_id SMALLINT,Name VARCHAR) ");




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Table_Name_Student);
        onCreate(sqLiteDatabase);


    }

    public boolean insertStudent(String firstName, String lastName, String email, String password, Date dateOfBirth) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("First_Name", firstName);
        contentValues.put("Last_Name", lastName);
        contentValues.put("Email", email);
        contentValues.put("Date_of_Birth", String.valueOf(dateOfBirth));


        //Password encryption goes here? also student id gen
        contentValues.put("Encrypt_Pass", password);
        long result = db.insert("Student", null, contentValues);
        if (result == 1) {
            return false;
        } else {
            return true;
        }


    }
    //checking if user exists
    public boolean checkStudent(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Student where Email=? and Encrypt_Pass=?", new String[]{email, password});
        int count = cursor.getCount();

        boolean exists;
        if (count > 0) {
            exists  = true;
        }
        else {
            exists = false;
        }

        return exists;
    }
}