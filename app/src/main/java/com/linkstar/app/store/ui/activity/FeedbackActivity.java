package com.linkstar.app.store.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;

/**
 * Created by hx
 * Time 2018/12/25/025.
 */

public class FeedbackActivity extends BaseNoTitleActivity {
    private EditText input;
    private Button submit;

    @Override
    public int setLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initView() {
        setTitleMsg("意见反馈", null);
        input = (EditText) findViewById(R.id.et_feedback_input);
        submit = (Button) findViewById(R.id.btn_submit);
    }

    @Override
    public void event() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShortToast("已提交！");
                finish();
            }
        });
    }

    @Override
    public void loadData() {

    }
}
