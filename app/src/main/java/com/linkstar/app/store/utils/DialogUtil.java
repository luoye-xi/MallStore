package com.linkstar.app.store.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.linkstar.app.store.ui.activity.GuideRecruitActivity;
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

    public static GuideRecruitDialog inviateDialog(Context context, String msg) {
        final GuideRecruitDialog mDialog = new GuideRecruitDialog(context, msg);
        mDialog.getWindow().setLayout((int) (ConstantUtil.SCREEN_WIDTH * 0.8), (int) (ConstantUtil.SCREEN_HEIGHT * 0.6)); //对话框大小应根据屏幕大小调整
        mDialog.show();
        return mDialog;
    }
}
