package com.example.v_zhaihongyuan.gankio;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class MyApplication extends Application {
    private static final String TAG = "deviceToken";

    //创建MyApplication
    @Override
    public void onCreate() {
        super.onCreate();

        UMConfigure.init(this, "5c2364c0b465f5196c0000c1", "GankIO", UMConfigure.DEVICE_TYPE_PHONE, "8a14c31d17745f824f18d4cdfa4d997a");
//获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG,"注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });
    }
}
