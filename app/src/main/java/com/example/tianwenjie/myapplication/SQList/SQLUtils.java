package com.example.tianwenjie.myapplication.SQList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianwenjie on 6/14/16.
 */
public class SQLUtils {
    SQListHelper helper;


    public SQLUtils (Context context){
        this.helper=new SQListHelper(context);
    }
    public void add(SQtool  tool){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues valuew=new ContentValues();
        valuew.put("url",tool.getUrl());
        valuew.put("localurl",tool.getLocalurl());
        db.insert("SQLpicture",null,valuew);

    }

//    public void uery(){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        Cursor c=db.query("SQLpicture", null, null, null, null, null,null);
//        String[] url = c.getString(c.getColumnIndex("url"));
//    }

    public List<SQtool> query(){
        List<SQtool> list = new ArrayList<SQtool>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query("SQLpicture", null, null, null, null, null, null);
        while (c.moveToNext()) {
            SQtool s = new SQtool();
            int id = c.getInt(c.getColumnIndex("_id"));
            String url = c.getString(c.getColumnIndex("url"));
            String  localurl=c.getString(c.getColumnIndex("localurl"));
            s.set_id(id);
            s.setUrl(url);
            s.setLocalurl(localurl);
            list.add(s);
        }
        c.close();
        return list;

    }
}
