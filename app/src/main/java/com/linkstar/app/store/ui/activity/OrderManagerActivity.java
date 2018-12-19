package com.linkstar.app.store.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.OrderListTabAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class OrderManagerActivity extends BaseNoTitleActivity implements View.OnClickListener {
    private SlidingTabLayout slidingTab;
    private ViewPager viewPager;
    private TextView tvOnLine, tvOffLine;

    @Override
    public int setLayout() {
        return R.layout.activity_order_manager;
    }

    @Override
    public void initView() {
        slidingTab = (SlidingTabLayout) findViewById(R.id.sliding_tab);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tvOnLine = (TextView) findViewById(R.id.tv_online_order);
        tvOffLine = (TextView) findViewById(R.id.tv_offline_order);

        List<String> tabList = new ArrayList<>();
        tabList.add("全部");
        tabList.add("待发货");
        tabList.add("已发货");
        tabList.add("退货单");
        tabList.add("退款单");
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
        setBackClick();
        tvOnLine.setOnClickListener(this);
        tvOffLine.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_online_order:
                tvOnLine.setTextColor(getResources().getColor(R.color.white));
                tvOnLine.setBackground(getResources().getDrawable(R.drawable.icon_button_l));
                tvOffLine.setTextColor(getResources().getColor(R.color.main_color_blue));
                tvOffLine.setBackground(getResources().getDrawable(R.drawable.icon_button_r));
                break;
            case R.id.tv_offline_order:
                tvOnLine.setTextColor(getResources().getColor(R.color.main_color_blue));
                tvOnLine.setBackground(getResources().getDrawable(R.drawable.icon_button_l1));
                tvOffLine.setTextColor(getResources().getColor(R.color.white));
                tvOffLine.setBackground(getResources().getDrawable(R.drawable.icon_button_r1));
                break;
        }
    }
}
