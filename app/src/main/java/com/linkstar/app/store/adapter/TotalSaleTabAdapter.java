package com.linkstar.app.store.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.linkstar.app.store.ui.fragment.TotalSaleChartFragment;

import java.util.List;

/**
 * Created by hx
 * Time 2018/12/22/022.
 */

public class TotalSaleTabAdapter extends FragmentPagerAdapter {
    private List<String> list;
    private int mType;

    public TotalSaleTabAdapter(FragmentManager fm, int type, List<String> list) {
        super(fm);
        this.list = list;
        this.mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        return TotalSaleChartFragment.newInstance(position, mType);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
