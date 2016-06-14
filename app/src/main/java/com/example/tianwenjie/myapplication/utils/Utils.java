package com.example.tianwenjie.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tianwenjie on 6/6/16.
 */
public class Utils {

    public static void onLoadImage(final URL bitmapUrl, final OnLoadImageListener onLoadImageListener) {
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                onLoadImageListener.OnLoadImage((Bitmap) msg.obj, null);
            }
        };
        new Thread(new Runnable() {

            @Override
            public void run() {

                URL imageUrl = bitmapUrl;
                try {

                    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                    InputStream inputStream = conn.getInputStream();
                    //图片保存在sd卡的路径
                    String savePath = Environment.getExternalStorageDirectory() + "/" + getLastParagraph(imageUrl.getPath());
                    readAsFile(inputStream, new File(savePath));
                    //获取图片的路路径
                    Bitmap bitmap = BitmapFactory.decodeFile(savePath);
                    Message msg = new Message();
                    msg.obj = bitmap;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }


    private static void readAsFile(InputStream bitmap, File file) throws Exception {
        FileOutputStream outStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = bitmap.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        bitmap.close();
    }

    public interface OnLoadImageListener {
        void OnLoadImage(Bitmap bitmap, String bitmapPath);
    }

    public static String getLastParagraph(String url) {
        int index = url.lastIndexOf("/");
        //substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。
        String newString = url.substring(index + 1);
        return newString;
    }

}

