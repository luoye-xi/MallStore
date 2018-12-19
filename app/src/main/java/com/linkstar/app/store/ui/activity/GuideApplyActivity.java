package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvGuideApplyAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/19/019.
 * 导购申请页
 */

public class GuideApplyActivity extends BaseNoTitleActivity {
    private ListView lvApply;

    @Override
    public int setLayout() {
        return R.layout.activity_guide_apply;
    }

    @Override
    public void initView() {
        setTitleMsg("达人导购申请", "审核记录");
        lvApply = (ListView) findViewById(R.id.lv_guide_apply);
        lvApply.setAdapter(new LvGuideApplyAdapter(this, false));
    }

    @Override
    public void event() {

        setSubClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AuditRecordActivity.class);
            }
        });
    }

    @Override
    public void loadData() {

    }
}
