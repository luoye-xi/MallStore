package com.linkstar.app.store.ui.activity;

import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BasePicTitleActivity;
import com.linkstar.app.store.manager.AppManager;
import com.linkstar.app.store.utils.ConstantUtil;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BasePicTitleActivity implements View.OnClickListener {
    private boolean isExit = false;
    private ImageView imgMsg, imgSetting;
    private LinearLayout goodsManager, orderManager, guideRecruit, storeData, goodsAnalysis;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        // 获取屏幕的宽高，设置为全局变量
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        ConstantUtil.SCREEN_WIDTH = outMetrics.widthPixels;
        ConstantUtil.SCREEN_HEIGHT = outMetrics.heightPixels;

        setSwipeBackEnable(false);
        imgMsg = (ImageView) findViewById(R.id.img_to_msg_center);
        imgSetting = (ImageView) findViewById(R.id.img_to_setting);
        goodsManager = (LinearLayout) findViewById(R.id.layout_goods_manager);
        orderManager = (LinearLayout) findViewById(R.id.layout_order_manager);
        guideRecruit = (LinearLayout) findViewById(R.id.layout_guide_recruit);
        storeData = (LinearLayout) findViewById(R.id.layout_store_data);
        goodsAnalysis = (LinearLayout) findViewById(R.id.layout_goods_analysis);
    }

    @Override
    public void event() {
        imgMsg.setOnClickListener(this);
        imgSetting.setOnClickListener(this);
        goodsManager.setOnClickListener(this);
        orderManager.setOnClickListener(this);
        guideRecruit.setOnClickListener(this);
        storeData.setOnClickListener(this);
        goodsAnalysis.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_to_msg_center:
                //消息图标点击事件—跳转到消息中心界面
                startActivity(SystemMsgActivity.class);
                break;
            case R.id.img_to_setting:
                //跳转到设置界面
                startActivity(SettingActivity.class);
                break;
            case R.id.layout_goods_manager:
                //跳转到商品管理界面
                startActivity(GoodsManagerActivity.class);
                break;
            case R.id.layout_order_manager:
                //跳转到订单管理界面
                startActivity(OrderManagerActivity.class);
                break;
            case R.id.layout_guide_recruit:
                //导购招募
                startActivity(GuideRecruitActivity.class);
                break;
            case R.id.layout_store_data:
                //门店数据分析
                startActivity(StoreDataActivity.class);
                break;
            case R.id.layout_goods_analysis:
                //商品分析
                startActivity(GoodsAnalysisActivity.class);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByDoubleClick();
        }
        return false;
    }

    private void exitByDoubleClick() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true;
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;// 取消退出
                }
            }, 2000);// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            //退出
            AppManager.getAppManager().AppExit(this);
        }
    }

}
