package com.example.tianwenjie.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tianwenjie.myapplication.adap.BenefitGoodsItemAdapter;
import com.example.tianwenjie.myapplication.db.ImageBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tianwenjie on 6/2/16.
 */
             //对列表有好处的片段
public class BenefitListFragment extends BaseFragment {

    @Bind(R.id.benefit_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.benefit_swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private BenefitGoodsItemAdapter mAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_benifit_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void initData() {
        mRecyclerView.setLayoutManager(new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAdapter = new BenefitGoodsItemAdapter(mActivity);
        mRecyclerView.setAdapter(mAdapter);
        getJsonData();

    }

    private void getJsonData() {
        String url = "http://c.3g.163.com/recommend/getChanListNews?" +
                "channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D" +
                "&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D" +
                "&version=9.0&net=wifi&ts=1464769308" +
                "&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I" +
                "&encryption=1&canal=meizu_store2014_news" +
                "&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D";

        //
        RequestQueue requestQueue = Volley.newRequestQueue(mActivity);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                try {
                    List<ImageBean> list = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray array = jsonObject.optJSONArray("美女");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.optJSONObject(i);
                        String imgsrc = item.optString("imgsrc");
                        String title = item.optString("title");
                        ImageBean bean = new ImageBean();
                        bean.setImgsrc(imgsrc);
                        bean.setTitle(title);
                        list.add(bean);
                        Log.d("img", "imgsrc=" + imgsrc);
                    }

                    mAdapter.getList().addAll(list);
                    mAdapter.getRandomHeight(list);
                    mAdapter.notifyDataSetChanged();


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
    }
}