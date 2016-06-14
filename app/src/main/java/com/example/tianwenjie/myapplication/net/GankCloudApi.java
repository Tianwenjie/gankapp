package com.example.tianwenjie.myapplication.net;

import android.database.Observable;

import com.example.tianwenjie.myapplication.model.GoodsResult;

/**
 * Created by tianwenjie on 6/12/16.
 */
public class GankCloudApi {
    public static GankCloudApi instance;

    public static GankCloudApi getIns() {
        if (null == instance) {
            synchronized (GankCloudApi.class) {
                if (null == instance) {
                    instance = new GankCloudApi();
                }
            }
        }
        return instance;
   }
  /* public Observable<GoodsResult> getCommonGoods(String type, int limit, int page) {
        if("Android".equalsIgnoreCase(type)){
            return mWebService.getAndroidGoods(limit, page);
        }
        if("IOS".equalsIgnoreCase(type)){
            return mWebService.getIosGoods(limit, page);
        }
        return mWebService.getAndroidGoods(limit, page);
    }*/

   /* public Observable<GoodsResult> getAndroidGoods(int limit, int page) {
        return mWebService.getAndroidGoods(limit, page);
    }

    public Observable<GoodsResult> getIosGoods(int limit, int page) {
        return mWebService.getIosGoods(limit, page);
    }

    public Observable<GoodsResult> getAllGoods(int limit, int page) {
        return mWebService.getAllGoods(limit, page);
    }

    public Observable<GoodsResult> getBenefitsGoods(int limit, int page) {
        return mWebService.getBenefitsGoods(limit, page);
    }

    public Observable<DayGoodsResult> getGoodsByDay(int year,int month,int day) {
        return mWebService.getGoodsByDay(year, month,day);
    }*/

}

