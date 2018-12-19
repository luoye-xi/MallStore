package com.linkstar.app.store.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvOrderManagerAdapter;
import com.linkstar.app.store.base.NewBaseFragment;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class OrderManagerFragment extends NewBaseFragment {
    private ListView lvOrder;

    public static OrderManagerFragment newInstance(int position) {
        OrderManagerFragment fragment = new OrderManagerFragment();
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
        return R.layout.fragment_order_manager;
    }

    public void initView() {
        lvOrder = mRootView.findViewById(R.id.lv_order_manager);
        lvOrder.setAdapter(new LvOrderManagerAdapter(getContext()));
    }
}
