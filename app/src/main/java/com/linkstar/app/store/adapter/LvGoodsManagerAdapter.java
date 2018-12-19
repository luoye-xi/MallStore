package com.linkstar.app.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linkstar.app.store.R;
import com.linkstar.app.store.bean.GoodsMsgBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/17/017.
 * 商品管理列表适配器
 */

public class LvGoodsManagerAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsMsgBean> data = new ArrayList<>();

    public LvGoodsManagerAdapter(Context context, List<GoodsMsgBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_lv_goods, null);
        return v;
    }
}
