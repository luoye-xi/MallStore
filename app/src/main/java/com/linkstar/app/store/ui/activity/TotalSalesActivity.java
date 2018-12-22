package com.linkstar.app.store.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.OrderListTabAdapter;
import com.linkstar.app.store.adapter.TotalSaleTabAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/22/022.
 * 总销售额统计界面-曲线统计图
 */

public class TotalSalesActivity extends BaseNoTitleActivity {
    private SlidingTabLayout slidingTab;
    private ViewPager viewPager;
    private int mType;


    @Override
    public int setLayout() {
        return R.layout.activity_total_sale;
    }

    @Override
    public void initView() {
        setTitleMsg("总销售额", "筛选");
        mType = getIntent().getIntExtra("data_type", -1);
        slidingTab = (SlidingTabLayout) findViewById(R.id.sliding_tab);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        List<String> tabList = new ArrayList<>();
        tabList.add("最近7天");
        tabList.add("本月");
        TotalSaleTabAdapter adapter = new TotalSaleTabAdapter(getSupportFragmentManager(), mType, tabList);
        viewPager.setAdapter(adapter);
        slidingTab.setViewPager(viewPager);
        viewPager.setOffscreenPageLimit(tabList.size());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i != 0) {
                    setSwipeBackEnable(false);
                } else {
                    setSwipeBackEnable(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
