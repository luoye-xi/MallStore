package com.linkstar.app.store.ui.activity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/20/020.
 */

public class MsgSettingActivity extends BaseNoTitleActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_msg_setting;
    }

    @Override
    public void initView() {
        setTitleMsg("消息提醒设置", null);
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
