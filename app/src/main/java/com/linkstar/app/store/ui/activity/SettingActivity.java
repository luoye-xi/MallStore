package com.linkstar.app.store.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class SettingActivity extends BaseNoTitleActivity implements View.OnClickListener {
    private RelativeLayout toMsgSetting, toUpdate, clearCache;

    @Override
    public int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        setTitleMsg("设置", null);
        toMsgSetting = (RelativeLayout) findViewById(R.id.layout_to_msg_setting);
        toUpdate = (RelativeLayout) findViewById(R.id.layout_update_pwd);
        clearCache = (RelativeLayout) findViewById(R.id.layout_clear_cache);
    }

    @Override
    public void event() {
        toMsgSetting.setOnClickListener(this);
        toUpdate.setOnClickListener(this);
        clearCache.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_to_msg_setting:
                //消息提醒设置
                startActivity(MsgSettingActivity.class);
                break;
            case R.id.layout_update_pwd:
                //密码修改
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_find", false);
                startActivity(PwdManagerActivity.class, bundle);
                break;
            case R.id.layout_clear_cache:

                break;
        }
    }
}
