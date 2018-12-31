package com.example.v_zhaihongyuan.gankio.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.v_zhaihongyuan.gankio.R;
import com.example.v_zhaihongyuan.gankio.bean.GanHuo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

public class MeiZhiViewHolder extends BaseViewHolder<GanHuo.Result> {

    private final ImageView imageView;

    public MeiZhiViewHolder(ViewGroup parent) {
        super(parent, R.layout.item);
        imageView = $(R.id.image);
    }

    @Override
    public void setData(GanHuo.Result data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
