package com.example.amanullah.myapplication18.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void insert(String name, String desc, String phone, String mobile, String email, String home, String work, String fb, String roll, Bitmap image_bitmap) {
   // public void insert(String name, String desc,String phone) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NAME, name);
        contentValue.put(DatabaseHelper.NICK_NAME, desc);
         contentValue.put(DatabaseHelper.PHONE, phone);
         contentValue.put(DatabaseHelper.MOBILE, mobile);
         contentValue.put(DatabaseHelper.EMAIL, email);
         contentValue.put(DatabaseHelper.HOME, home);
         contentValue.put(DatabaseHelper.WORK, work);
         contentValue.put(DatabaseHelper.FB, fb);
        contentValue.put(DatabaseHelper.ROLL, roll);
        contentValue.put(DatabaseHelper.IMG, Utility.getBytes(image_bitmap));
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.NICK_NAME ,DatabaseHelper.PHONE,
                DatabaseHelper.MOBILE,DatabaseHelper.EMAIL,DatabaseHelper.HOME,DatabaseHelper.WORK,DatabaseHelper.FB,
                DatabaseHelper.ROLL,DatabaseHelper.IMG};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update(long _id, String name, String desc,String phone,String mobile,String email,String home,String work,String fb,String roll,Bitmap image_bitmap) {
    //public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.NICK_NAME, desc);
         contentValues.put(DatabaseHelper.PHONE, phone);
         contentValues.put(DatabaseHelper.MOBILE, mobile);
         contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.HOME, home);
         contentValues.put(DatabaseHelper.WORK, work);
         contentValues.put(DatabaseHelper.FB, fb);
        contentValues.put(DatabaseHelper.ROLL, roll);
        contentValues.put(DatabaseHelper.IMG, Utility.getBytes(image_bitmap));
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
