package com.example.tianwenjie.myapplication.adap;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianwenjie.myapplication.R;
import com.example.tianwenjie.myapplication.utils.Utils;

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tianwenjie on 6/6/16.
 */
public class GoodsItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;

    private String[] string = {"http://ww4.sinaimg.cn/large/7a8aed7bgw1etdsksgctqj20hs0qowgy.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f4kron1wqaj20ia0rf436.jpg",
            "http://ww2.sinaimg.cn/large/610dc034gw1f4hvgpjjapj20ia0ur0vr.jpg",
            "http://ac-OLWHHM4o.clouddn.com/4063qegYjlC8nx6uEqxV0kT3hn6hdqJqVWPKpdrS",
            "http://ww3.sinaimg.cn/large/610dc034gw1f4fkmatcvdj20hs0qo78s.jpg" ,
            "http://ac-OLWHHM4o.clouddn.com/DPCY44vIYPjVPKNzfHjMdXd9bk27q0i1X2nIaO8Z" ,
            "http://ww1.sinaimg.cn/large/610dc034jw1f4d4iji38kj20sg0izdl1.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f49s6i5pg7j20go0p043b.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f48mxqcvkvj20lt0pyaed.jpg" ,
            "http://ww4.sinaimg.cn/large/610dc034jw1f47gspphiyj20ia0rf76w.jpg"   } ;
    public GoodsItemAdapter(Context context) {
        mContext = context;
        mLayoutInflater=LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ImageViewHolder(mLayoutInflater.inflate(R.layout.goods_item_layout, parent ,false));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        URL url = null;
        try {
            url = new URL(string[position]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
         String str=string[position];

       final ImageView imageview= ((ImageViewHolder) holder).imgGoodsImageBg;
        imageview.setImageBitmap(null);

        Utils.onLoadImage(str, new Utils.OnLoadImageListener() {

            @Override
            public void OnLoadImage(Bitmap bitmap, String bitmapPath) {
                if(bitmap!=null){

                    imageview.setImageBitmap(bitmap);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return string == null ? 0 : string.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.img_goods_img)
        ImageView imgGoodsImageBg;
        @Bind(R.id.txt_img_author)
        TextView txtImgAuthor;
        @Bind(R.id.txt_goods_title)
        TextView txtGoodsTitle;
        @Bind(R.id.img_like_goods)
        ImageView imgLikeGoods;
        @Bind(R.id.txt_goods_author)
        TextView txtGoodsAuthor;
        public ImageViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this,inflate);
        }
    }
}
