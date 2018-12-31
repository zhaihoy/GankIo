package com.example.v_zhaihongyuan.gankio.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.v_zhaihongyuan.gankio.config.Config;
import com.example.v_zhaihongyuan.gankio.fragemnt.MainActivityFragment;
import com.example.v_zhaihongyuan.gankio.R;
import com.example.v_zhaihongyuan.gankio.utils.ShareUtil;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private List<Fragment> fragments;
    private String[] titles = {"福利", "Android", "iOS", "休息视频"};
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();

        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://me.csdn.net/qq_39956074")));
            }
        });

        //List
        fragments = new ArrayList<>();
        for (String title : titles) {
            fragments.add(MainActivityFragment.getInstance(title));
        }

        //ViewPager
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        //TabLayou 不知道为啥出现了卡顿  暂时解决不了
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_share_app:
                ShareUtil.shareText(this, Config.MainUrl);
                break;
            case R.id.action_about_app:
                startActivity(new Intent(this,AboutAppActivity.class));
                break;
            case R.id.action_about_me:
//                startActivity(new Intent(this,AboutMe.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
