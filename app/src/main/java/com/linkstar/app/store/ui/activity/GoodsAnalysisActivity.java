package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvGoodsAnalysisAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.ui.view.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hx
 * Time 2018/12/19/019.
 * 商品分析
 */

public class GoodsAnalysisActivity extends BaseNoTitleActivity {
    private ListView lvGoods;
    private CustomDatePicker datePicker;// 日期选择器

    @Override
    public int setLayout() {
        return R.layout.activity_goods_analysis;
    }

    @Override
    public void initView() {
        setTitleMsg("商品分析", "筛选");
        lvGoods = (ListView) findViewById(R.id.lv_goods_analysis);
        lvGoods.setAdapter(new LvGoodsAnalysisAdapter(this));
    }

    @Override
    public void event() {
        setSubClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == datePicker) {
                    initDatePicker();
                }
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                String now1 = sdf1.format(new Date());
                datePicker.show(now1.split(" ")[0]);
            }
        });
    }

    @Override
    public void loadData() {

    }

    /**
     * 初始化日期选择器
     */
    private void initDatePicker() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月", Locale.CHINA);
        String now = sdf.format(new Date());

        datePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                Date parse = null;
                try {
                    parse = sdf.parse(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String formatTime = sdf1.format(parse);
                showShortToast(formatTime);
            }
        }, "2008-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        datePicker.showMonthTime(true);//只显示年月
        datePicker.setIsLoop(true); // 允许循环滚动

    }
}
