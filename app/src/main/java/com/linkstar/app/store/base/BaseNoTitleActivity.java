package com.linkstar.app.store.base;

import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.store.R;

/**
 * Created by hx
 * Time 2018/12/13/013.
 * 沉浸式
 * 实现方法设置布局、初始化控件、点击事件、数据调用
 */

public abstract class BaseNoTitleActivity extends BaseActivity {
    private ImmersionBar mImmersionBar; //沉浸式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.white)
                .statusBarAlpha(0.2f)
                .statusBarDarkFont(true, 0.2f)
                .init();
        setContentView(setLayout());
        initView();
        event();
        loadData();
    }

    @Override
    protected void onDestroy() {
        //关闭当前页面注销沉浸式
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

    /**
     * 设置关联布局
     */
    public abstract int setLayout();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 点击事件
     */
    public abstract void event();

    /**
     * 数据加载
     */
    public abstract void loadData();

}
