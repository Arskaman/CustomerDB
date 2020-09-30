package com.example.customerdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "CustomerDB.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "my_customers";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "customer_name";
    public static final String COLUMN_COMPANY = "customer_company";
    public static final String COLUMN_CITY = "customer_city";
    public static final String COLUMN_PHONE = "customer_phone";
    public static final String COLUMN_EMAIL = "customer_email";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
