package com.example.tianwenjie.myapplication;


import android.os.Bundle;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tianwenjie.myapplication.adap.GoodsItemAdapter;
import com.example.tianwenjie.myapplication.net.GankCloudApi;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tianwenjie on 6/2/16.
 */

public class CommonGoodsListFragment extends BaseLoadingFragment implements  SwipeRefreshLayout.OnRefreshListener{
    @Bind(R.id.common_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.common_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

  /*  private GoodsItemAdapter mCommonItemAdapter;
    private ArrayList<Goods> mAllCommonGoods;
    private  String mType="android";
    private boolean isALlLoad = false;
    private int hasLoadPage = 0;

*/


    public static CommonGoodsListFragment newFragment(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        CommonGoodsListFragment fragment = new CommonGoodsListFragment();
        fragment.setArguments(bundle);
        return fragment;

    }



    @Override
     View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common_list, container, false); //加载为java对象
        //  return inflater.inflate(R.layout.fragment_common_list,container, false);

    }
    @Override
    public void onCompleted() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupBaseView();
    }

    private void setupBaseView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter( new GoodsItemAdapter(getActivity()));
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {

      //  reloadData();

    }
/*

    private void reloadData() {
        swipeRefreshLayout.setRefreshing(true);
        mAllCommonGoods.clear();
        isALlLoad = false;
        hasLoadPage = 0;
        loadData(1);
    }

    private void loadData(int startPage) {
     */
/*  GankCloudApi.getIns()
        .getCommonGoods(mType, GankCloudApi.LOAD_LIMIT, startPage)
                .cache()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getCommonGoodsObserver);*//*

    }
*/


}




