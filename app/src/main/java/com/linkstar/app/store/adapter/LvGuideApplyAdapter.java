package com.linkstar.app.store.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkstar.app.store.R;

/**
 * Created by hx
 * Time 2018/12/19/019.
 */

public class LvGuideApplyAdapter extends BaseAdapter {
    private Context context;
    private boolean isHistory;//是否为导购申请历史记录
    private onAgreeListener mOnAgreeListener;
    private onRefuseListener mOnRefuseListener;

    public LvGuideApplyAdapter(Context context, boolean isHistory) {
        this.context = context;
        this.isHistory = isHistory;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lv_guide_apply, null);
        TextView tvMsg = view.findViewById(R.id.tv_guide_apply_msg);
        TextView tvAgree = view.findViewById(R.id.tv_agree);
        TextView tvRefuse = view.findViewById(R.id.tv_refuse);
        ImageView img = view.findViewById(R.id.img_is_agree);
        LinearLayout layout = view.findViewById(R.id.layout_button);
        tvMsg.setText(Html.fromHtml("<font color='#50AFF7'>隔壁老六(137****5812)</font>\t申请成为达人导购"));

        if (isHistory) {
            img.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.VISIBLE);
        }


        tvAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnAgreeListener.onAgreeClick(position);
            }
        });

        tvRefuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnRefuseListener.onRefuseClick(position);
            }
        });

        return view;
    }

    public interface onAgreeListener {
        void onAgreeClick(int position);
    }

    public void setOnAgreeListener(onAgreeListener mOnAgreeListener) {
        this.mOnAgreeListener = mOnAgreeListener;
    }

    public interface onRefuseListener {
        void onRefuseClick(int position);
    }

    public void setOnRefuseListener(onRefuseListener mOnRefuseListener) {
        this.mOnRefuseListener = mOnRefuseListener;
    }
}
