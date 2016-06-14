package com.example.tianwenjie.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import com.example.tianwenjie.myapplication.MyApp;
import com.example.tianwenjie.myapplication.SQList.SQLUtils;
import com.example.tianwenjie.myapplication.SQList.SQtool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by tianwenjie on 6/6/16.
 */
public class Utils {

    public static void onLoadImage(final String bitmapUrl, final OnLoadImageListener onLoadImageListener) {

        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                onLoadImageListener.OnLoadImage((Bitmap) msg.obj, null);
            }
        };
        new Thread(new Runnable() {

            @Override
            public void run() {
                SQLUtils utils = new SQLUtils(MyApp.gContext);
                SQtool sqtool = new SQtool();


//                System.out.println(utils.query());

                List<SQtool> all = utils.query();

                if (all != null) {
                    for (SQtool tool: all) {
                        if (bitmapUrl.equals(tool.getUrl())) {
                            //fuyong huancun复用缓存
                            postBitmap(tool.getLocalurl(),handler);
                            return;
                        }
                    }
                }

                URL url = null;
                try {
                    url = new URL(bitmapUrl);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }



                    try {
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = conn.getInputStream();
                        //图片保存在sd卡的路径
                        String savePath = Environment.getExternalStorageDirectory() + "/" + getLastParagraph(url.getPath());
                        readAsFile(inputStream, new File(savePath));
                        //把图平的地址存在进数据库
                        sqtool.setUrl(bitmapUrl);
                        sqtool.setLocalurl(savePath);
                        utils.add(sqtool);

                        //获取图片
                        postBitmap(savePath, handler);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }).start();

    }

    private static void postBitmap(String savePath, Handler handler) {
        Bitmap bitmap = BitmapFactory.decodeFile(savePath);
        Message msg = new Message();
        msg.obj = bitmap;
        handler.sendMessage(msg);
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

