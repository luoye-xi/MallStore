package com.linkstar.app.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linkstar.app.store.R;

/**
 * Created by hx
 * Time 2018/12/18/018.
 */

public class LvOrderGoodsAdapter extends BaseAdapter {
    private Context context;

    public LvOrderGoodsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
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
        View v = LayoutInflater.from(context).inflate(R.layout.item_lv_order_goods, null);
        return v;
    }
}
