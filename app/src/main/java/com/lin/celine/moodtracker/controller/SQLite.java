package com.lin.celine.moodtracker.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by celine on 30/03/2018.
 */

public class SQLite extends SQLiteOpenHelper {

    private static final String mood_key = "TABLE MOOD";
    private static final String mood_comment = "COMMENT";
    private static final String mood_date = "DATE";
    private static final String mood_mood = "MOOD";


    private static final String TABLE_MOOD = "TABLE MOOD " + mood_key + "("
            + mood_comment + " INTEGER COMMENT, " + mood_date + " DATE"
            + mood_mood + " MOOD)";

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_MOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("table mood " + mood_key + ";");
        onCreate(sqLiteDatabase);
    }

    public void insertValues(String mood, String comment, String date) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(mood_mood, mood);
        values.put(mood_comment, comment);
        values.put(mood_date, date);

        db.insert(TABLE_MOOD, null, values);
        db.close();

    }
}
