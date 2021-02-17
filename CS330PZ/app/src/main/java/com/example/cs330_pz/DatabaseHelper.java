package com.example.cs330_pz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "korisnik.db";
    public static final String TABLE_NAME = "korisnik";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE korisnik(ID INTEGER PRIMARY KEY AUTOINCREMENT,username VARCHAR,password VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,  int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public long addUser(String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long res = db.insert("korisnik", null, contentValues);
      db.close();
      return res;
    }
    public boolean checkUser(String username, String password){
        String[] columns ={ COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "= ?" + " and " + COL_3 +"= ?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();


        if(count>0)
            return true;
        else
            return false;

    }
}