package com.example.tianwenjie.myapplication;

import android.app.Activity;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tianwenjie.myapplication.adap.BenefitGoodsItemAdapter;
import com.example.tianwenjie.myapplication.db.ImageBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianwenjie on 6/16/16.
 */
public class Json extends InstrumentationTestCase {
    //      private String s;
    private BenefitGoodsItemAdapter mAdapter;


    public void testtData() {


        getJsonData();
    }


    public void getJsonData() {
        String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";


        RequestQueue requestQueue = Volley.newRequestQueue(getInstrumentation().getContext());
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {


            @Override
            public void onResponse(String s) {

                try {
                    List<ImageBean> list = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray array = jsonObject.optJSONArray("results");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.optJSONObject(i);
                        String imgsrc = item.optString("url");
                        String title = item.optString("who");
                        ImageBean bean = new ImageBean();
                        bean.setImgsrc(imgsrc);
                        bean.setTitle(title);
                        list.add(bean);
                        Log.d("img", "rul=" + imgsrc);

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(request);

        SystemClock.sleep(10000);
    }


}




