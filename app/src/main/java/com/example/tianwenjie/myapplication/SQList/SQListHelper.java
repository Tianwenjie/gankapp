package com.example.tianwenjie.myapplication.SQList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianwenjie on 6/13/16.
 */

public class SQListHelper extends SQLiteOpenHelper {
    private static final String FILE_NEMA = "picture";
    private static final int VERSION = 1;

    public SQListHelper(Context context) {
        super(context, FILE_NEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL("CREATE TABLE SQLpicture(_id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT,localurl TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        if (i == 1 && i1 == 2) {
            db.execSQL("ALTER TABLE restaurants ADD phone TEXT;");
        }

    }
}
