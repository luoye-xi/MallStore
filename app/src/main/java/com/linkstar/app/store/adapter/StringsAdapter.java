package com.linkstar.app.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linkstar.app.store.R;


/**
 * Created by hx
 * Time 2018/9/18/018.
 */

public class StringsAdapter extends BaseAdapter {
    private Context context;
    private String data[];

    public StringsAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_string_item, null);
        TextView text = v.findViewById(R.id.tv_dialog_string);
        text.setText(data[position]);
        return v;
    }
}
