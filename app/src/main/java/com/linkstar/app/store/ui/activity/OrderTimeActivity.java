package com.linkstar.app.store.ui.activity;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.OrderListTabAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/22/022.
 * 订单信息-从销售数据进入
 */

public class OrderTimeActivity extends BaseNoTitleActivity {
    private SlidingTabLayout slidingTab;
    private ViewPager viewPager;

    @Override
    public int setLayout() {
        return R.layout.activity_order_time;
    }

    @Override
    public void initView() {
        setTitleMsg("订单", "筛选");
        slidingTab = (SlidingTabLayout) findViewById(R.id.sliding_tab);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        List<String> tabList = new ArrayList<>();
        tabList.add("线上订单");
        tabList.add("线下订单");
        OrderListTabAdapter adapter = new OrderListTabAdapter(getSupportFragmentManager(), tabList);
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
