package com.linkstar.app.store.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.adapter.StringsAdapter;
import com.linkstar.app.store.ui.activity.GuideRecruitActivity;
import com.linkstar.app.store.ui.view.BottomDialog;
import com.linkstar.app.store.ui.view.DangerousOperationDialog;
import com.linkstar.app.store.ui.view.GuideRecruitDialog;

/**
 * Created by hx
 * Time 2018/12/18/018.
 */

public class DialogUtil {

    /**
     * 危险操作提示框
     *
     * @param context
     * @param msg
     * @param positiveTv
     * @param positiveListener
     * @return
     */
    public static DangerousOperationDialog dangerousOperationDialog(Activity context, String msg, String positiveTv, View.OnClickListener positiveListener) {
        final DangerousOperationDialog myDialog = new DangerousOperationDialog(context);
        myDialog.getWindow().setLayout((int) (ConstantUtil.SCREEN_WIDTH * 0.7), (int) (ConstantUtil.SCREEN_HEIGHT * 0.2)); //对话框大小应根据屏幕大小调整
        myDialog.setContent(msg);
        myDialog.setPositiveText(positiveTv);
        myDialog.setOnPositiveListener(positiveListener);
        myDialog.setOnNegativeListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
        return myDialog;
    }

    /**
     * 导购邀请二维码弹出框
     *
     * @param context
     * @param msg
     * @return
     */
    public static GuideRecruitDialog inviateDialog(Context context, String msg) {
        final GuideRecruitDialog mDialog = new GuideRecruitDialog(context, msg);
        mDialog.getWindow().setLayout((int) (ConstantUtil.SCREEN_WIDTH * 0.8), (int) (ConstantUtil.SCREEN_HEIGHT * 0.6)); //对话框大小应根据屏幕大小调整
        mDialog.show();
        return mDialog;
    }

    public static BottomDialog showBottomItemDialog(final String[] items, final String title, FragmentManager manager, final Context context, final AdapterView.OnItemClickListener listener) {
        final BottomDialog myDialog = BottomDialog.create(manager);
        myDialog.setViewListener(new BottomDialog.ViewListener() { // 可以进行一些必要对View的操作
            @Override
            public void bindView(View v) {
                TextView tvTitle = v.findViewById(R.id.tv_choose_dialog_title);
                ListView lv = v.findViewById(R.id.lv_dialog_items);
                TextView tvCancel = v.findViewById(R.id.tv_choose_cancel);
                lv.setCacheColorHint(0);
                lv.setAdapter(new StringsAdapter(context, items));
                lv.setOnItemClickListener(listener);
                tvTitle.setText(title);
                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
            }
        }).setLayoutRes(R.layout.dialog_choose_item).setDimAmount(0.1f) // Dialog window 背景色深度范围：0到1，默认是0.2f
                .setCancelOutside(true) // 点击外部区域是否关闭，默认true
                .show();
        return myDialog;
    }
}
