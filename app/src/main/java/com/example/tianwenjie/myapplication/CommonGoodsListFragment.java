package com.example.tianwenjie.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tianwenjie on 6/2/16.
 */
public class CommonGoodsListFragment extends BaseLoadingFragment {
    public static CommonGoodsListFragment newFragment(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        CommonGoodsListFragment fragment = new CommonGoodsListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common_list,container, false);
    }
}
