package com.linkstar.app.store.ui.activity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.ui.view.RingChartView;

/**
 * Created by hx
 * Time 2018/12/20/020.
 */

public class CustomerAnalysisActivity extends BaseNoTitleActivity {
    private RingChartView ringChartView;

    @Override
    public int setLayout() {
        return R.layout.activity_customer_analysis;
    }

    @Override
    public void initView() {
        setTitleMsg("顾客分析", null);
        ringChartView = (RingChartView) findViewById(R.id.ring_chart_view);
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
