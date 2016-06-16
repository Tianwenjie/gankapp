package com.example.tianwenjie.myapplication;


import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlonjatg.progressactivity.ProgressActivity;


/**
 * Created by tianwenjie on 6/2/16.
 */
public abstract class BaseLoadingFragment extends Fragment {

    private ProgressActivity mProgressActivity;

    public abstract void onCompleted();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProgressActivity = (ProgressActivity) inflater.inflate(R.layout.fragment_base_loading_layout, container, false);
        mProgressActivity.addView(onCreateContentView(inflater, mProgressActivity, savedInstanceState));
        return mProgressActivity;
    }

    abstract View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}
