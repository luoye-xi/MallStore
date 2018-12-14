package com.linkstar.app.store.ui.activity;

import android.view.KeyEvent;
import android.widget.Toast;
import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BasePicTitleActivity;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BasePicTitleActivity {
    private boolean isExit = false;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void event() {

    }

    @Override
    public void loadData() {

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
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;// 取消退出
                }
            }, 2000);// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            finish();
            System.exit(0);
        }
    }


}
