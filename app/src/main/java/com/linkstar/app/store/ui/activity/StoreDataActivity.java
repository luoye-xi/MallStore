package com.linkstar.app.store.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/18/018.
 * 门店数据分析
 */

public class StoreDataActivity extends BaseNoTitleActivity implements View.OnClickListener {
    private RelativeLayout laySellData, layOrderData, layVIPData, layMonthAll;

    @Override
    public int setLayout() {
        return R.layout.activity_store_data;
    }

    @Override
    public void initView() {
        setTitleMsg("门店数据", null);
        laySellData = (RelativeLayout) findViewById(R.id.layout_store_data_month);
        layOrderData = (RelativeLayout) findViewById(R.id.layout_store_data_order);
        layVIPData = (RelativeLayout) findViewById(R.id.layout_store_data_member);
        layMonthAll = (RelativeLayout) findViewById(R.id.layout_store_data_month_all);
    }

    @Override
    public void event() {
        laySellData.setOnClickListener(this);
        layOrderData.setOnClickListener(this);
        layVIPData.setOnClickListener(this);
        layMonthAll.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.layout_store_data_month:
                //最近30天销售额
                bundle.putInt("data_type", 1);
                bundle.putInt("data_time", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_store_data_order:
                //最近30天订单数
                bundle.putInt("data_type", 2);
                bundle.putInt("data_time", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_store_data_member:
                //最近30天会员增长
                bundle.putInt("data_type", 3);
                bundle.putInt("data_time", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_store_data_month_all:
                //本月业绩
                startActivity(MonthDataActivity.class);
                break;
        }
    }
}
