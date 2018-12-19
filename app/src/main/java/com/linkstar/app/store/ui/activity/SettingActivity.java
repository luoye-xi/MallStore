package com.linkstar.app.store.ui.activity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class SettingActivity extends BaseNoTitleActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        setTitleMsg("设置", null);
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
