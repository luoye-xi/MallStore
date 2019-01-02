package com.linkstar.app.store.ui.activity;

import android.os.Bundle;
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
    private LinearLayout goodsManager, orderManager, guideRecruit, storeData, goodsAnalysis, customerAnalysis,
            totalData, onlineData, offlineData;
    private LinearLayout orderMonth, daySale, totalCustom;

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
        customerAnalysis = (LinearLayout) findViewById(R.id.layout_customer_analysis);
        totalData = (LinearLayout) findViewById(R.id.layout_to_total_data);
        onlineData = (LinearLayout) findViewById(R.id.layout_to_online_data);
        offlineData = (LinearLayout) findViewById(R.id.layout_to_offline_data);
        orderMonth = (LinearLayout) findViewById(R.id.layout_order_num_month);
        daySale = (LinearLayout) findViewById(R.id.layout_sale_today);
        totalCustom = (LinearLayout) findViewById(R.id.layout_total_custom);
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
        customerAnalysis.setOnClickListener(this);
        totalData.setOnClickListener(this);
        onlineData.setOnClickListener(this);
        offlineData.setOnClickListener(this);
        orderMonth.setOnClickListener(this);
//        daySale.setOnClickListener(this);
//        totalCustom.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }


    @Override
    public void onClick(View v) {
        Bundle bundle = null;
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
            case R.id.layout_customer_analysis:
                //顾客分析
                startActivity(CustomerAnalysisActivity.class);
                break;
            case R.id.layout_to_total_data:
                //总数据额分析
                bundle = new Bundle();
                bundle.putInt("data_type", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_to_online_data:
                //线上销售额
                bundle = new Bundle();
                bundle.putInt("data_type", 2);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_to_offline_data:
                //线下销售额
                bundle = new Bundle();
                bundle.putInt("data_type", 3);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_order_num_month:
                //本月订单数
                bundle = new Bundle();
                bundle.putInt("data_type", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_sale_today:
                //今日销售额
                bundle = new Bundle();
                bundle.putInt("data_type", 1);
                startActivity(TotalSalesActivity.class, bundle);
                break;
            case R.id.layout_total_custom:
                //顾客总数
                bundle = new Bundle();
                bundle.putInt("data_type", 1);
                startActivity(TotalSalesActivity.class, bundle);
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
