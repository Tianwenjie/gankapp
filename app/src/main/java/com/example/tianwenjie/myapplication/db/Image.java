package com.example.tianwenjie.myapplication.db;


import io.realm.RealmObject;

/**
 * Created by tianwenjie on 6/12/16.
 */
public class Image extends RealmObject {
    /**补充数据*/
    private int width = 0;
    private int height = 0;
    private int position = 0;

    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
