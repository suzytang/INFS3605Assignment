package com.example.infs3605assignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// The following code is modified from: Programming Knowledge (2015)
// Android SQLite Database Tutorial 5
// http://programmingknowledgeblog.blogspot.com/2015/05/android-sqlite-database-tutorial-5.html

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "uhifaifab.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MCQ (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER, QUESTION TEXT, OPT1 TEXT," +
                "OPT2 TEXT, OPT3 TEXT, OPT4 TEXT, CORRECT INTEGER, ANSWERED INTEGER)");
        db.execSQL("CREATE TABLE LEARN (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER," +
                "HEAD1 TEXT, CON1 TEXT, HEAD2 TEXT, CON2 TEXT, HEAD3 TEXT, CON3 TEXT, HEAD4, CON4)");

        db.execSQL("INSERT INTO MCQ (LEVEL, QUESTION, OPT1, OPT2, OPT3, OPT4, CORRECT, ANSWERED) VALUES " +
                "(1, 'Question', 'Option 1','Option 2','Option 3', 'Option 4', 2, 0)");

        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES " +
                "(1, '1 - Heading 1','Content 1','Heading 2','Content 2','Heading 3','Content 3','Heading 4','Content 4')");
        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES " +
                "(2, '2 - Heading 1','Content 1','Heading 2','Content 2','Heading 3','Content 3','Heading 4','Content 4')");
        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES " +
                "(3, '3 - Heading 1','Content 1','Heading 2','Content 2','Heading 3','Content 3','Heading 4','Content 4')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MCQ");
        db.execSQL("DROP TABLE IF EXISTS LEARN");
        onCreate(db);
    }
    // Modified code stops here
}