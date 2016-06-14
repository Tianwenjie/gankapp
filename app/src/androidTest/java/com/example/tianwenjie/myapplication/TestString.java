package com.example.tianwenjie.myapplication;

import android.test.InstrumentationTestCase;

/**
 * Created by tianwenjie on 6/14/16.
 */
public class TestString extends InstrumentationTestCase {

    public void testGetName() {
        String str1 = "http://ww4.sinaimg.cn/large/610dc034jw1f47gspphiyj20ia0rf76w.jpg";

        int index = str1.lastIndexOf("/");
        //substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。
        String newString = str1.substring(index + 1);

        assertEquals(newString, "610dc034jw1f47gspphiyj20ia0rf76w.jpg");
    }
}
