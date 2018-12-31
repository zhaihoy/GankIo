package com.example.v_zhaihongyuan.gankio.adapter;


import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.v_zhaihongyuan.gankio.R;
import com.example.v_zhaihongyuan.gankio.bean.GanHuo;
import com.example.v_zhaihongyuan.gankio.utils.TimeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

class GanHuoViewHolder extends BaseViewHolder<GanHuo.Result> {

    private TextView title;
    private TextView type;
    private TextView who;
    private TextView time;

    public GanHuoViewHolder(ViewGroup parent) {
        //设置布局  也就是具体的条目是具体的什么样子
        super(parent, R.layout.ganhuolayout_item_xml);
        //第三方的框架 故此
        title = (TextView) $(R.id.title);
        type = (TextView) $(R.id.type);
        who = (TextView) $(R.id.who);
        time = (TextView) $(R.id.time);
    }
    //设置data

    @Override
    public void setData(GanHuo.Result data) {
        super.setData(data);
        System.out.println("===="+data.get_id()+data.getDesc()+data.getUsed()+data.getWho()+data.getCreatedAt());
        //标题
        title.setText(data.getDesc());
        //干货类型
        type.setText(data.getType());
        //根据干货类型动态替换干货图标
        if (data.getType().equals("Android")){
            setDrawableLeft(R.drawable.ic_android_black_24dp);
        }else if (data.getType().equals("iOS")){
            setDrawableLeft(R.drawable.ic_whatshot_black_24dp);
        }else {
            setDrawableLeft(R.drawable.ic_play_circle_filled_black_24dp);
        }
        //干货贡献者
        who.setText(data.getWho());
        //干货提交时间
        time.setText(TimeUtil.getFormatTime(data.getPublishedAt()));
    }

     private void setDrawableLeft(int id){
         Drawable drawable = getContext().getResources().getDrawable(id);
         drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
         type.setCompoundDrawables(drawable,null,null,null);
     }
}
