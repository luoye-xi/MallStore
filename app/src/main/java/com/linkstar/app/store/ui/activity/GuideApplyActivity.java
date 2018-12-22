package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.LvGuideApplyAdapter;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.ui.view.BottomDialog;
import com.linkstar.app.store.ui.view.DangerousOperationDialog;
import com.linkstar.app.store.utils.DialogUtil;

/**
 * Created by hx
 * Time 2018/12/19/019.
 * 导购申请页
 */

public class GuideApplyActivity extends BaseNoTitleActivity {
    private ListView lvApply;
    private LvGuideApplyAdapter adapter;
    private DangerousOperationDialog agreeDialog;
    private BottomDialog bottomDialog;
    private String[] items = {"招募人数已满", "门店停止招募导购"};

    @Override
    public int setLayout() {
        return R.layout.activity_guide_apply;
    }

    @Override
    public void initView() {
        setTitleMsg("达人导购申请", "审核记录");
        lvApply = (ListView) findViewById(R.id.lv_guide_apply);
        adapter = new LvGuideApplyAdapter(this, false);
        lvApply.setAdapter(adapter);
        adapter.setOnAgreeListener(new LvGuideApplyAdapter.onAgreeListener() {
            @Override
            public void onAgreeClick(int position) {
                agreeDialog = DialogUtil.dangerousOperationDialog(GuideApplyActivity.this, "是否通过审核？", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showShortToast("agree");
                        agreeDialog.dismiss();
                    }
                });
            }
        });

        adapter.setOnRefuseListener(new LvGuideApplyAdapter.onRefuseListener() {
            @Override
            public void onRefuseClick(int position) {
                bottomDialog = DialogUtil.showBottomItemDialog(items, "请选择拒绝理由", getSupportFragmentManager(), GuideApplyActivity.this, new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showShortToast("拒绝理由：" + items[position]);
                        bottomDialog.dismiss();
                    }
                });
            }
        });
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
