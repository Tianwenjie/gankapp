package com.example.tianwenjie.myapplication.SQList;

/**
 * Created by tianwenjie on 6/14/16.
 */
public class SQtool {
    private  int _id;
    private  String url;
    private  String localurl;

    public int get_id() {
        return _id;
    }

    public String getUrl() {
        return url;
    }

    public String getLocalurl() {
        return localurl;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocalurl(String localurl) {
        this.localurl = localurl;
    }

    @Override
    public String toString() {
        return "SQtool{" +
                "_id=" + _id +
                ", url='" + url + '\'' +
                ", localurl='" + localurl + '\'' +
                '}';
    }
}
