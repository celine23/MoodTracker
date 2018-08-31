package com.lin.celine.moodtracker.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by celine on 30/03/2018.
 */
//défini la table qui sera produite lors de l'instanciation.
public class SQLite extends SQLiteOpenHelper {

    public static final String TABLE_MOOD = "mood";
    public static final String KEY = "id";
    public static final String COMMENT = "comment";
    public static final String DATE = "date";
    public static final String MOOD = "mood";

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_MOOD + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MOOD + " TEXT," + COMMENT + " TEXT, " + DATE + " DATE);";

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("table mood " + KEY + ";");
        onCreate(sqLiteDatabase);
    }

}