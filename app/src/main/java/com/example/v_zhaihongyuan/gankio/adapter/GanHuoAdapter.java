package com.example.v_zhaihongyuan.gankio.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.v_zhaihongyuan.gankio.bean.GanHuo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

public class GanHuoAdapter extends RecyclerArrayAdapter<GanHuo.Result>{
    public GanHuoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        //返回AdapterHolder
        return new GanHuoViewHolder(parent);
    }
}
