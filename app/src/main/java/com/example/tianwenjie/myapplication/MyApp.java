package com.example.tianwenjie.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by tianwenjie on 6/14/16.
 */
public class MyApp extends Application{
    public static Context gContext;
    @Override
    public void onCreate() {
        super.onCreate();
        gContext=this;
    }
}
