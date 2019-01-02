package com.linkstar.app.store.ui.activity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/26/026.
 */

public class OrderDetailActivity extends BaseNoTitleActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initView() {
        setTitleMsg("订单详情", null);
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
