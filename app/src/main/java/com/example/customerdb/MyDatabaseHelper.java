package com.example.customerdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "CustomerDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_customers";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "customer_name";
    private static final String COLUMN_COMPANY = "customer_company";
    private static final String COLUMN_CITY = "customer_city";
    private static final String COLUMN_PHONE = "customer_phone"; // INTEGER!
    private static final String COLUMN_EMAIL = "customer_email";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String guery =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_COMPANY + " TEXT, " +
                        COLUMN_CITY + " TEXT, " +
                        COLUMN_PHONE + " TEXT, " +
                        COLUMN_EMAIL + " TEXT);";
        db.execSQL(guery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addBook(String name, String company, String city, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_COMPANY, company);
        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_PHONE, phone);
        cv.put(COLUMN_EMAIL, email);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Succesfully", Toast.LENGTH_SHORT).show();
        }
    }
}
