package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.SystemMsgAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class SystemMsgActivity extends BaseNoTitleActivity {
    private ListView lvMsg;
    private SystemMsgAdapter adapter;
    private List<String> data = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.activity_system_msg;
    }

    @Override
    public void initView() {
        setTitleMsg("系统消息", "清空");
        lvMsg = (ListView) findViewById(R.id.lv_sys_msg);

        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");

        adapter = new SystemMsgAdapter(this, data);
        lvMsg.setAdapter(adapter);
    }

    @Override
    public void event() {
        setSubClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void loadData() {

    }
}
