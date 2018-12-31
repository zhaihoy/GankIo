package com.example.v_zhaihongyuan.gankio.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.v_zhaihongyuan.gankio.R;
import com.example.v_zhaihongyuan.gankio.utils.ImageUtil;
import com.example.v_zhaihongyuan.gankio.utils.ShareUtil;
import com.umeng.message.PushAgent;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MeiZhiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView image;
    private String desc;
    private String url;
    //    private PhotoViewAttacher attacher;
    private Bitmap bitmap;
    private PhotoViewAttacher attacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meizhi_layout);
        PushAgent.getInstance(this).onAppStart();
        init();

    }

    private void init() {
        getData();
        initView();
    }

    private void getData() {
        Intent intent = getIntent();
        desc = intent.getStringExtra("desc");
        url = intent.getStringExtra("url");
    }

    private void initView() {
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getSupportActionBar().setTitle(desc);
        System.out.println("=====des" + desc);
        //ImageView
        image = (ImageView) findViewById(R.id.image_meizhi);
        //点击放大缩小的一个类库
        attacher = new PhotoViewAttacher(image);
        Glide.with(this)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        image.setImageBitmap(resource);
                        attacher.update();
                        bitmap = resource;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_meizhi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:
//                ShareUtil.shareImage(this, ImageUtil.saveImage(this,url,bitmap,image,"share"));

                break;
            case R.id.action_save:
//                ImageUtil.saveImage(this,url,bitmap,image,"save");
                Toast.makeText(this, "妹子是大家的怎能独享", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_click_me:
                Snackbar.make(image, "鸡冻吗ヾ (o ° ω ° O ) ノ", Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
