package com.lentcoding.notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;
    static final String TABLE_NOTES = "notes";
    static final String NOTE_ID = "_id";
    static final String NOTE_SUBJECT = "subject";
    static final String NOTE_TEXT = "noteText";
    static final String NOTE_CREATED = "noteCreated";
    static final String[] ALL_COLUMNS = {NOTE_ID, NOTE_SUBJECT, NOTE_TEXT, NOTE_CREATED};
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NOTES + " (" + NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOTE_SUBJECT + " TEXT, " + NOTE_TEXT + " TEXT, " + NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" + ")";

    DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
