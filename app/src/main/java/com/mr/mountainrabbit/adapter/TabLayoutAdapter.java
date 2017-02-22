package com.mr.mountainrabbit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by BULING on 2017/2/17.
 */

public class TabLayoutAdapter extends FragmentStatePagerAdapter{
    //fragment的集合
    private List<Fragment> listFragment;
    //title的集合
    private String[] title;

    public TabLayoutAdapter(FragmentManager fm, List<Fragment> listFragment, String[] title) {
        super(fm);
        this.listFragment = listFragment;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
