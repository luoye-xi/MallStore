package com.linkstar.app.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linkstar.app.store.R;

import java.util.List;

/**
 * Created by hx
 * Time 2018/12/22/022.
 */

public class SystemMsgAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;

    public SystemMsgAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_lv_sys_msg, null);
        return view;
    }
}
