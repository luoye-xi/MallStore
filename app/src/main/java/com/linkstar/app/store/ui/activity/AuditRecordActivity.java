package com.linkstar.app.store.ui.activity;

import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvGuideApplyAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/19/019.
 * 导购审核记录
 */

public class AuditRecordActivity extends BaseNoTitleActivity {
    private ListView lvHistory;

    @Override
    public int setLayout() {
        return R.layout.activity_audit_record;
    }

    @Override
    public void initView() {
        setTitleMsg("审核记录", null);
        lvHistory = (ListView) findViewById(R.id.lv_guide_apply_history);
        lvHistory.setAdapter(new LvGuideApplyAdapter(this, true));
    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

    }
}
