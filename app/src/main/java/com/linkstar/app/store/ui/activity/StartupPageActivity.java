package com.linkstar.app.store.ui.activity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BasePicTitleActivity;

/**
 * Created by hx
 * Time 2018/12/13/013.
 */

public class StartupPageActivity extends BasePicTitleActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_startup_page;
    }

    @Override
    public void initView() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    // 判断程序是否登录，如果已登录跳转首页否则跳转登录界面
//                    is_login = true;
                    if (is_login) {
                        startActivity(MainActivity.class);
                    } else {
                        startActivity(LoginActivity.class);
                    }
                    finish();
                } catch (Exception e) {

                }

                super.run();
            }
        }.start();
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
