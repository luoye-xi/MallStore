package com.linkstar.app.store.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import com.linkstar.app.store.R;
import com.linkstar.app.store.manager.AppManager;
import com.linkstar.app.store.utils.SharedPreferencesUtil;


/**
 * Created by hx
 * Time 2018/12/12/012.
 * activity基类当前设置：toast(String,res),页面跳转(bundle),页面过度动画,关闭软键盘,右滑关闭activity
 */

public class BaseActivity extends SwipeBackActivity {
    private Intent intent;
    private Toast toast;
    private Context context;
    public static boolean is_login = false;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        is_login = SharedPreferencesUtil.getLoginState(context);
        //添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    protected void startActivity(Class<?> cls, Bundle bdl) {
        if (intent == null) {
            intent = new Intent(this, cls);
        }
        intent.setClass(this, cls);
        if (bdl != null) {
            intent.putExtras(bdl);
        }
        startActivity(intent);
    }

    // TOAST
    protected void showShortToast(CharSequence msg) {
        if (null == toast) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }

    protected void showShortToast(int resId) {
        showShortToast(this.getResources().getText(resId));
    }

    protected String getStringById(int resId) {
        String msg = this.getResources().getString(resId);
        return msg;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // 设置过渡动画
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        // 设置过渡动画
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    protected void onPause() {
        super.onPause();
        hintKeyBoard();
    }

    public void hintKeyBoard() {
        //拿到InputMethodManager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //如果window上view获取焦点 && view不为空
        if (imm.isActive() && getCurrentFocus() != null) {
            //拿到view的token 不为空
            if (getCurrentFocus().getWindowToken() != null) {
                //表示软键盘窗口总是隐藏，除非开始时以SHOW_FORCED显示。
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    protected void setTitleMsg(String main, String sub) {
        TextView tvTitle = (TextView) findViewById(R.id.tv_main_title);
        TextView tvSub = (TextView) findViewById(R.id.tv_sub_title);
        if (null != main)
            tvTitle.setText(main);
        if (null != sub) {
            tvSub.setText(sub);
            tvSub.setVisibility(View.VISIBLE);
        }
        setBackClick();
    }


    /**
     * 为Activity标题下的右边文字设置点击事件
     */
    protected void setSubClick(View.OnClickListener listener) {
        TextView tvSub = (TextView) this.findViewById(R.id.tv_sub_title);
        if (null != listener)
            tvSub.setOnClickListener(listener);
    }

    /**
     * 为Activity标题下的返回箭头设置点击事件
     */
    protected void setBackClick() {
        //返回箭头点击事件，调用返回键
        imgBack = (ImageView) findViewById(R.id.img_close_activity);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
