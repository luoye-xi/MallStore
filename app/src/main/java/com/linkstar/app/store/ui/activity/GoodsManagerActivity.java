package com.linkstar.app.store.ui.activity;

import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvGoodsManagerAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.bean.GoodsMsgBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class GoodsManagerActivity extends BaseNoTitleActivity {
    private ListView lvGoods;
    private List<GoodsMsgBean> goods = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.activity_goods_manager;
    }

    @Override
    public void initView() {
        setTitleMsg("商品管理", null);
        lvGoods = (ListView) findViewById(R.id.lv_goods_manager);
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));
        goods.add(new GoodsMsgBean(0, R.drawable.test_goods_s_img_4, "初生婴儿衣服礼盒套装宝宝用品秋冬季", 888, 810, 8888));

        lvGoods.setAdapter(new LvGoodsManagerAdapter(this, goods));
    }
}
