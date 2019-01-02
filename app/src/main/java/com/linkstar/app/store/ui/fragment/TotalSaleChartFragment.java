package com.linkstar.app.store.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.linkstar.app.store.R;
import com.linkstar.app.store.base.NewBaseFragment;
import com.linkstar.app.store.manager.DynamicLineChartManager;
import com.linkstar.app.store.ui.activity.OrderTimeActivity;
import com.linkstar.app.store.ui.view.GraphChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/22/022.
 */

public class TotalSaleChartFragment extends NewBaseFragment implements View.OnClickListener {
    private GraphChartView chartView;
    private DynamicLineChartManager curveManager;
    private List<Integer> list = new ArrayList<>(); //数据集合
    private List<String> names = new ArrayList<>(); //折线名字集合
    private List<Integer> colour = new ArrayList<>();//折线颜色集合
    private RelativeLayout layOrder;
    private LinearLayout allData, onlineData, offlineData;
    private int mType;
    private int[] mColor = new int[]{0xFF50AFF7, 0xFFFF9804, 0xFFFB5B8C, 0xFFD05BFB, 0xFF08C303};

    public static TotalSaleChartFragment newInstance(int position, int type) {
        TotalSaleChartFragment fragment = new TotalSaleChartFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.fragment_total_sale_chart;
    }

    @Override
    public void initView() {
        super.initView();
        chartView = mRootView.findViewById(R.id.graph_chart_view);
        layOrder = mRootView.findViewById(R.id.layout_to_order);
        allData = mRootView.findViewById(R.id.layout_total_data);
        onlineData = mRootView.findViewById(R.id.layout_online_data);
        offlineData = mRootView.findViewById(R.id.layout_offline_data);
        drawChart();

//        LineChart mChart = (LineChart) mRootView.findViewById(R.id.curve_chart_view);
//
//        //折线名字
//        names.add("总销售额");
//        names.add("线上销售额");
//        names.add("线下销售额");
//        //折线颜色
//        colour.add(Color.BLUE);
//        colour.add(Color.RED);
//        colour.add(Color.GREEN);
//
//        curveManager = new DynamicLineChartManager(mChart, names.get(0), colour.get(0));
//
//        curveManager.setYAxis(100, 0, 10);


        layOrder.setOnClickListener(this);
        allData.setOnClickListener(this);
        onlineData.setOnClickListener(this);
        offlineData.setOnClickListener(this);

    }

    private void drawChart() {
        // 配置坐标系
        chartView.setupCoordinator("日", "", /*这里是横坐标的值*/21f, 22f, 23f, 24f, 25f, 26f, 27f);
        // 添加曲线, 确保纵坐标的数值位数相等
//        chartView.addWave(mColor[0], false,
//                6000f, 2200f, 2800f, 5000f, 8000f, 8300f, 5960f);
//        chartView.addWave(mColor[1], false,
//                2000f, 2800f, 3200f, 1000f, 4960f, 3000f, 500f);
//        chartView.addWave(mColor[4], false,
//                350f, 800f, 1500f, 3000f, 960f, 800f, 500f);
        switch (mType) {
            case 1:
                chartView.addWave(mColor[0], false,
                        6000f, 2200f, 2800f, 5000f, 8000f, 8300f, 5960f);
                break;
            case 2:
                chartView.addWave(mColor[1], false,
                        2000f, 2800f, 3200f, 1000f, 4960f, 3000f, 500f);
                break;
            case 3:
                chartView.addWave(mColor[4], false,
                        350f, 800f, 1500f, 3000f, 960f, 800f, 500f);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_to_order:
                Intent intent = new Intent(getContext(), OrderTimeActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_total_data:
                //显示（关闭）销售总额曲线
                break;
            case R.id.layout_online_data:
                //显示（关闭）线上销售额曲线
                break;
            case R.id.layout_offline_data:
                //显示（关闭）线下销售额曲线
                break;
        }
    }
}
