package com.example.v_zhaihongyuan.gankio.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.v_zhaihongyuan.gankio.byselflayout.PageFragment;

import java.util.ArrayList;
import java.util.List;


public class PageFragmentAdapter extends FragmentPagerAdapter {
    private List<PageFragment> fragments = new ArrayList<>();

    public PageFragmentAdapter(FragmentManager fm, List<PageFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public PageFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
