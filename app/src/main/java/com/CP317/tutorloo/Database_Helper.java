package com.CP317.tutorloo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.CP317.tutorloo.EntityClasses.Student;
import com.CP317.tutorloo.EntityClasses.Tutor;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Users.db";


    public static final String Table_Name_Student = "Student";
    public static final String Table_Name_tutor = "tutor";
    public static final String Table_Name_user_course = "user_course";
    public static final String Table_Name_user_photo = "user_photo";
    public static final String Table_Name_user_program = "user_program";
    public static final String Table_Name_courses = "courses";
    public static final String Table_Name_programs = "programs";


    public Database_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_Student+" (Student_id INTEGER,Last_Name VARCHAR,First_Name VARCHAR,Date_Of_Birth DATE,Email STRING,Encrypt_Pass VARCHAR) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_tutor+" (Tutor_id INTEGER PRIMARY KEY AUTOINCREMENT,Last_Name VARCHAR,First_Name VARCHAR,Date_Of_Birth DATE,Email STRING,Encrypt_Pass VARCHAR,Biography LONGTEXT,Year_Of_Study INTEGER,Hourly_Fee INTEGER,Rating INTEGER, Course VARCHAR, Program VARCHAR) ");
//        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_course+" (Course_id SMALLINT,Tutor_id SMALLINT) ");
//        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_photo+" (Photo_id SMALLINT,Tutor_id SMALLINT,Link TEXT, Time_Added TIMESTAMP, Active BOOLEAN) ");
//        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_user_program+" (Program_id SMALLINT,Tutor_id SMALLINT) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_courses+" (Course_id SMALLINT,Name VARCHAR) ");
        sqLiteDatabase.execSQL("CREATE TABLE "+ Table_Name_programs+" (Program_id SMALLINT,Name VARCHAR) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Table_Name_Student);
        onCreate(sqLiteDatabase);


    }

    public boolean insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("First_Name", student.getfirstName());
        contentValues.put("Last_Name", student.getlastName());
        contentValues.put("Email", student.getEmail());
        contentValues.put("Date_of_Birth", String.valueOf(student.getdob()));
        contentValues.put("Encrypt_Pass", student.getPassword());
        long result = db.insert("Student", null, contentValues);
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertTutor(Tutor tutor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("First_Name", tutor.getfirstName());
        contentValues.put("Last_Name", tutor.getlastName());
        contentValues.put("Email", tutor.getEmail());
        contentValues.put("Date_of_Birth", String.valueOf(tutor.getdob()));
        contentValues.put("Encrypt_Pass", tutor.getPassword());
        long result = db.insert("tutor", null, contentValues);
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertTutorInfo(Tutor tutor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Course", tutor.getCourse());
        contentValues.put("Program", tutor.getProgram());

        long result = db.insert("tutor", null, contentValues);
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

    //checking if tutor exists
    public boolean checkTutor(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tutor where Email=? and Encrypt_Pass=?", new String[]{email, password});
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


    //Input: String of criteria array from (StudentActivity)
    //Output: Returns an array of tutorID's containing all of the matches
    //Finds the tutor id based on the criteria given
    public int[] findTutors(String[] criteriaArray) {
        SQLiteDatabase db = this.getReadableDatabase();
        //Can only store 100 tutors
        int[] tutorIDs = new int[100];

        //Depending on how the array is filled, there will be 7 SQL statements
        //Each SQL statement searches the database and returns tutorIDs
        //Note: !criteraArray[i] MAY NOT WORK TO CHECK IF IT IS NULL
        //      may have to fill the array with zeros in Student Activity and
        //      check if it is non zero here.

        String name = criteriaArray[0];
        String course = criteriaArray[1];
        String program = criteriaArray[2];

        Cursor cursor = null;

        //IF WE ARE ONLY SEARCHING BY TUTOR NAME
        if (name != null && course == null && program == null)
        {
            cursor = db.rawQuery("Select Tutor_id from tutor where First_Name=?", new String[]{name});
        }

        //IF WE ARE ONLY SEARCHING BY COURSE
        else if (name == null && course != null && program == null)
        {
            cursor = db.rawQuery("Select Tutor_id from tutor where Course=?", new String[]{course});
        }

        //IF WE ARE ONLY SEARCHING BY TUTOR PROGRAM
        else if (name == null && course == null && program != null)
        {
            cursor = db.rawQuery("Select Tutor_id from tutor where Program=?", new String[]{program});
        }

        //IF WE ARE ONLY SEARCHING BY TUTOR NAME & COURSE
        else if (name != null && course != null && program==null)
        {
            cursor = db.rawQuery("Select tutor_id from tutor where Name=? and Course=?", new String[]{name, course});
        }

        //IF WE ARE ONLY SEARCHING BY TUTOR NAME & PROGRAM
        else if (name != null && course == null && program != null) {
            cursor = db.rawQuery("Select tutor_id from tutor where Name=? and Program=?", new String[]{name, program});
        }

        //IF WE ARE ONLY SEARCHING BY COURSE AND PROGRAM
        else if (name == null && course != null && program != null) {
            cursor = db.rawQuery("Select tutor_id from tutor where Course=? and Program=?", new String[]{course, program});
        }

        //IF WE ARE ONLY SEARCHING BY ALL CRITERIA
        else if (name != null && course != null && program != null) {
            cursor = db.rawQuery("Select tutor_id from tutor where Name= ? and Course=? and Program=?", new String[]{name, course, program});
        }

        //iterate through cursor and put all results into the tutorIDs array
        int i=0;

        while (cursor.moveToNext())
        {
            //0- because we need the tutor id which is in column 0
            tutorIDs[i] = Integer.parseInt(cursor.getString(0));
            Log log = null;
            log.e("Success:",Integer.toString(tutorIDs[i]));
            //i++;
        }

        return tutorIDs;


    }

}