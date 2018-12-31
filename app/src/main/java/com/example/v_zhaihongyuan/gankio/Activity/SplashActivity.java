package com.example.v_zhaihongyuan.gankio.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.v_zhaihongyuan.gankio.R;
import com.example.v_zhaihongyuan.gankio.bean.GanHuo;
import com.example.v_zhaihongyuan.gankio.byselflayout.PageFrameLayout;
import com.example.v_zhaihongyuan.gankio.retrofit.GanIoRetrofit;
import com.example.v_zhaihongyuan.gankio.service.GankService;
import com.umeng.message.PushAgent;

import java.util.Random;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    private ImageView mImageView;
    private PageFrameLayout contentFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_xml);
        initView();
        initData();
    }

    private void initData() {
        Retrofit ganKRetrofit = GanIoRetrofit.getGanKRetrofit();
        ganKRetrofit.create(GankService.class)
                .getGanHuo("福利",1,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GanHuo>() {
                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("======走这里了吗"+e);

                    }

                    @Override
                    public void onNext(GanHuo ganHuo) {
                        System.out.println("======走这里了吗");
                        if (ganHuo.isError()){
                            Toast.makeText(getApplication(),"请检查网络",Toast.LENGTH_LONG).show();
                        }
                        Log.e("666","onNext");
//                        Glide.with(SplashActivity.this)
//                                .load(ganHuo.getResults().get(0).getUrl())
//                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                                .into(mImageView);

                    }
                });
    }
    private void initView() {
//        mImageView = findViewById(R.id.image);
        contentFrameLayout = (PageFrameLayout) findViewById(R.id.contentFrameLayout);
        // 设置资源文件和选中圆点
        contentFrameLayout.setUpViews(new int[]{
                R.layout.page_tab1,
                R.layout.page_tab2,
                R.layout.page_tab3,
                R.layout.page_tab4
        }, R.mipmap.banner_on, R.mipmap.banner_off);
    }
}
