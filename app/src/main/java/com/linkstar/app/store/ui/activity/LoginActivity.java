package com.linkstar.app.store.ui.activity;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.base.BasePicTitleActivity;
import com.linkstar.app.store.manager.AppManager;
import com.linkstar.app.store.utils.ConstantUtil;
import com.linkstar.app.store.utils.StringUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hx
 * Time 2018/12/13/013.
 */

public class LoginActivity extends BasePicTitleActivity implements View.OnClickListener {

    private EditText etAccount, etPwd;
    private CheckBox cbShow;
    private Button btnLogin;
    private boolean isExit = false;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etAccount = (EditText) this.findViewById(R.id.et_mall_account);
        etPwd = (EditText) this.findViewById(R.id.et_mall_password);
        cbShow = (CheckBox) this.findViewById(R.id.cb_show_pwd);
        btnLogin = (Button) this.findViewById(R.id.btn_login);
    }

    @Override
    public void event() {
        btnLogin.setOnClickListener(this);
        cbShow.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb_show_pwd:
                if (cbShow.isChecked()) {
                    //如果选中，显示密码
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPwd.setSelection(etPwd.getText().length());
                } else {
                    //否则隐藏密码
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPwd.setSelection(etPwd.getText().length());
                }
                break;
            case R.id.btn_login:
                String account = etAccount.getText().toString();
                String pwd = etPwd.getText().toString();
                if (!ConstantUtil.isDebug) {
                    if (!StringUtil.checkAccount(account)) {
                        showShortToast(R.string.account_check_err);
                        return;
                    }
                    if (!StringUtil.checkPassword(pwd)) {
                        showShortToast(R.string.password_check_err);
                        return;
                    }
                }
                startActivity(MainActivity.class);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByDoubleClick();
        }
        return false;
    }

    private void exitByDoubleClick() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true;
            Toast.makeText(LoginActivity.this, getStringById(R.string.double_exit), Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;// 取消退出
                }
            }, 2000);// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            //退出
            AppManager.getAppManager().AppExit(this);
        }
    }


}
