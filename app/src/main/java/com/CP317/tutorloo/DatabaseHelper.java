package com.CP317.tutorloo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    public static final String DB_NAME = "User.db";
    private static int DB_VERSION = 1; // Database version
    private final File DB_FILE;
    private SQLiteDatabase mDataBase;
    private final Context mContext;



    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        DB_FILE = new File(context.getDatabasePath(DB_NAME).getAbsolutePath());;
        this.mContext = context;
    }

    public void createDataBase() throws IOException {
        // If the database does not exist, copy it from the assets.
        boolean mDataBaseExist = checkDataBase();
        if(!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            // Copy the database from assests
            copyDataBase();
            Log.e(TAG, "createDatabase database created");
        }
    }

    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        OutputStream mOutput = new FileOutputStream(DB_FILE);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    private boolean checkDataBase() {
        return DB_FILE.exists();
    }

    public boolean openDataBase() throws SQLException {
        // Log.v("DB_PATH", DB_FILE.getAbsolutePath());
        mDataBase = SQLiteDatabase.openDatabase(String.valueOf(DB_FILE), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        // mDataBase = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    public synchronized void close() {
        if(mDataBase != null) {
            mDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {
    }


//    public boolean passAuth(String email, String password){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME='?' AND PASSWORD='?';",
//                new String[]{email,password});
//
//        if (mCursor != null) {
//            if(mCursor.getCount() > 0)
//            {
//                mCursor.close();
//                return true;
//            }
//        }
//        return false;
//    }
}
