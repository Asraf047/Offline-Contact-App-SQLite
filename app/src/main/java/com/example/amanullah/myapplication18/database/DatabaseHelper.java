package com.example.amanullah.myapplication18.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "FRIENDS";

    // Table columns
    public static final String _ID = "_id";
    public static final String ROLL = "roll";
    public static final String NAME = "subject";
    public static final String NICK_NAME = "nickname";
    public static final String DESC = "description";
    public static final String PHONE = "phone";
    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String WORK = "work";
    public static final String HOME = "home";
    public static final String FB = "fb";
    public static final String IMG = "image";

    // Database Information
    static final String DB_NAME = "FRIENDS_DB";

    // database version
    static final int DB_VERSION = 27;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ROLL + " TEXT, " + NAME + " TEXT NOT NULL, "
            + NICK_NAME + " TEXT, " +
            PHONE + " TEXT, " + MOBILE + " TEXT, " + EMAIL + " TEXT, " + WORK + " TEXT, "
            + HOME + " TEXT, " + FB + " TEXT, " + IMG + " blob not null, " + DESC + " TEXT);";

    private static final String[] COLUMNS = {_ID, ROLL, NAME, NICK_NAME, PHONE, MOBILE,EMAIL,WORK,HOME,FB, IMG ,DESC};

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Bitmap getImage(String genId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Bitmap photo = null;
        // 2. build query
        Cursor cursor =
                db.query(TABLE_NAME, // a. table
                        COLUMNS, // b. column names
                        "genId = ?", // c. selections
                        new String[]{genId}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        Log.d(TAG, "Exception occur 2= " + db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                "genId = ?", // c. selections
                new String[]{genId}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null));
        // 3. if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();
            {
                //byte[] image = cursor.getBlob(0);
                //Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
                //image_list.setImageBitmap(bmp);

                photo=Utility.getPhoto(cursor.getBlob(cursor.getColumnIndex(IMG)));
                //image_list.setImageBitmap(photo);
                //Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            }

        }
        return photo;
    }
}
