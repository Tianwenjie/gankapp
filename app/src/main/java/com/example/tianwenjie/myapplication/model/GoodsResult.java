package com.example.tianwenjie.myapplication.model;

import com.example.tianwenjie.myapplication.Goods;

import java.util.ArrayList;

/**
 * Created by tianwenjie on 6/12/16.
 */
public class GoodsResult extends BaseResult{
    private ArrayList<Goods> results;

    public GoodsResult(ArrayList<Goods> results) {
        this.results = results;
    }

    public ArrayList<Goods> getResults() {
        return results;
    }

    public void setResults(ArrayList<Goods> results) {
        this.results = results;
    }

}
