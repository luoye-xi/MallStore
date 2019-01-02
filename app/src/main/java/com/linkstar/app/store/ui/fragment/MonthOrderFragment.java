package com.linkstar.app.store.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvOrderManagerAdapter;
import com.linkstar.app.store.base.NewBaseFragment;
import com.linkstar.app.store.ui.activity.OrderDetailActivity;

/**
 * Created by hx
 * Time 2018/12/26/026.
 * 门店订单（线上、线下）
 */

public class MonthOrderFragment extends NewBaseFragment implements LvOrderManagerAdapter.OnItemClickListener {

    private ListView lvOrder;
    private LvOrderManagerAdapter adapter;

    public static MonthOrderFragment newInstance(int position) {
        MonthOrderFragment fragment = new MonthOrderFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.fragment_month_data;
    }

    public void initView() {
        lvOrder = mRootView.findViewById(R.id.lv_month_data_order);

        adapter = new LvOrderManagerAdapter(getContext());
        lvOrder.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), OrderDetailActivity.class);
        startActivity(intent);
    }
}
