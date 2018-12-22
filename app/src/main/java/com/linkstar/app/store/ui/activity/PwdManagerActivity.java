package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.ui.view.CountdownButton;

/**
 * Created by hx
 * Time 2018/12/20/020.
 * 密码管理中心。（密码找回、密码修改）根据上一页面决定内容
 */

public class PwdManagerActivity extends BaseNoTitleActivity implements View.OnClickListener {
    private LinearLayout layFind, layChange;
    private CountdownButton countdownButton;
    private Button btnSubmit;
    private boolean isFind;

    @Override
    public int setLayout() {
        return R.layout.activity_pwd_manager;
    }

    @Override
    public void initView() {

        isFind = getIntent().getBooleanExtra("is_find", false);
        layFind = (LinearLayout) findViewById(R.id.layout_find);
        layChange = (LinearLayout) findViewById(R.id.layout_change);
        countdownButton = (CountdownButton) findViewById(R.id.cdb_get_code);
        btnSubmit = (Button) findViewById(R.id.btn_confirm);

        if (isFind) {
            setTitleMsg("忘记密码", null);
            layFind.setVisibility(View.VISIBLE);
        } else {
            setTitleMsg("修改密码", null);
            layChange.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void event() {
        countdownButton.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cdb_get_code:
                countdownButton.startCountDown();
                break;
            case R.id.btn_confirm:
                showShortToast("密码设置成功！");
                finish();
                break;
        }
    }
}
