package com.example.v_zhaihongyuan.gankio.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.v_zhaihongyuan.gankio.bean.GanHuo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

public class MeiZiadapter extends RecyclerArrayAdapter<GanHuo.Result> {

    public MeiZiadapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return  new MeiZhiViewHolder(parent);
    }
}
