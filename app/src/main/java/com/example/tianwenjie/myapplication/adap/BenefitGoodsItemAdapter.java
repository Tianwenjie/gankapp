package com.example.tianwenjie.myapplication.adap;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tianwenjie.myapplication.MainActivity;
import com.example.tianwenjie.myapplication.R;
import com.example.tianwenjie.myapplication.db.ImageBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by tianwenjie on 6/15/16.
 */
public class BenefitGoodsItemAdapter extends RecyclerView.Adapter<BenefitGoodsItemAdapter.ViewHolder>{

    private Context mContext;
    private List<ImageBean> mList = new ArrayList<>();
    private List<Integer> mHeights;


    public  BenefitGoodsItemAdapter(Context context){
        this.mContext=context;
    }


    @Override
    public BenefitGoodsItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_image_text, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BenefitGoodsItemAdapter.ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);

        ImageBean bean = mList.get(position);
        ImageLoader.getInstance().displayImage(bean.getImgsrc(),
                holder.mImageView, NORMAL_OPTION);



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void getRandomHeight(List<ImageBean> list) {
        mHeights = new ArrayList<>();
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.imageview)
        ImageView mImageView;

        public ViewHolder(View view){
            //需要设置super
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public List<ImageBean> getList() {
        return mList;
    }

    public static DisplayImageOptions NORMAL_OPTION = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .showImageOnLoading(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher)
            .cacheOnDisc(true)
            .build();
}

