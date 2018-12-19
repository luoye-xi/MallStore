package com.linkstar.app.store.ui.activity;

import android.view.View;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class SystemMsgActivity extends BaseNoTitleActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_system_msg;
    }

    @Override
    public void initView() {
        setTitleMsg("系统消息", "清空");
    }

    @Override
    public void event() {
        setSubClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShortToast("清空");
            }
        });
    }

    @Override
    public void loadData() {

    }
}
