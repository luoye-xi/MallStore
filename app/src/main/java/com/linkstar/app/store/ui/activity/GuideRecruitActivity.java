package com.linkstar.app.store.ui.activity;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.linkstar.app.store.R;
import com.linkstar.app.store.base.BaseNoTitleActivity;
import com.linkstar.app.store.utils.DialogUtil;
import com.linkstar.app.store.utils.ZXingUtils;

/**
 * Created by hx
 * Time 2018/12/18/018.
 * 导购招募
 */

public class GuideRecruitActivity extends BaseNoTitleActivity implements View.OnClickListener {
    private ImageView imgQrCode, imgSetting;
    private String mQrCodeMsg;
    private LinearLayout toApply;

    @Override
    public int setLayout() {
        return R.layout.activity_guide_recruit;
    }

    @Override
    public void initView() {

        toApply = (LinearLayout) findViewById(R.id.layout_to_guide_apply);
        imgQrCode = (ImageView) findViewById(R.id.img_qr_code);
        imgSetting = (ImageView) findViewById(R.id.tv_sub_title);
        //生成导购招募二维码
        imgQrCode.measure(0, 0);
        int width = imgQrCode.getMeasuredWidth();// 图片的实际大小
        int height = imgQrCode.getMeasuredHeight();
        Log.d("TAG", "width:" + width + "\n height:" + height);
        mQrCodeMsg = "http://www.baidu.com";
        final Bitmap bitmap = ZXingUtils.createQRImage(mQrCodeMsg, width, height, null, null);
        imgQrCode.setImageBitmap(bitmap);


    }

    @Override
    public void event() {
        imgQrCode.setOnClickListener(this);
        toApply.setOnClickListener(this);
        imgSetting.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_qr_code:
                showInviteDialog(mQrCodeMsg);
                break;
            case R.id.layout_to_guide_apply:
                startActivity(GuideApplyActivity.class);
                break;
            case R.id.tv_sub_title:
                startActivity(GuideSettingActivity.class);
                break;
        }
    }

    private void showInviteDialog(String info) {
        DialogUtil.inviateDialog(this, info);
    }
}
