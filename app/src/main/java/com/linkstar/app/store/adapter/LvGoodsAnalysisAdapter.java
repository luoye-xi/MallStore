package com.linkstar.app.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linkstar.app.store.R;

/**
 * Created by hx
 * Time 2018/12/19/019.
 * 商品管理列表适配器
 */

public class LvGoodsAnalysisAdapter extends BaseAdapter {
    private Context context;

    public LvGoodsAnalysisAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lv_goods_analysis, null);

        return view;
    }
}
