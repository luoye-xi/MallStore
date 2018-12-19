package com.linkstar.app.store.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.linkstar.app.store.R;
import com.linkstar.app.store.utils.ZXingUtils;

/**
 * Created by hx
 * Time 2018/12/18/018.
 * 导购招募二维码对话框
 */

public class GuideRecruitDialog extends Dialog {

//    private TextView contentText;

    public GuideRecruitDialog(Context context, String msg) {
        super(context, R.style.mydialog);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_guide_recruit, null);  //通过LayoutInflater获取布局
//        contentText = view.findViewById(R.id.tv_dialog_title);
        ImageView imgQRCode = view.findViewById(R.id.img_dialog_qr_code);
        TextView tvDownLoad = view.findViewById(R.id.tv_load_img);
        imgQRCode.measure(0, 0);
        int width = imgQRCode.getMeasuredWidth();// 图片的实际大小
        int height = imgQRCode.getMeasuredHeight();
        Log.d("TAG", "width:" + width + "\n height:" + height);
        final Bitmap bitmap = ZXingUtils.createQRImage(msg, width, height, null, null);
        imgQRCode.setImageBitmap(bitmap);
        setContentView(view);  //设置view
    }

    //设置内容
//    public void setContent(String content) {
//        if (null != content)
//            contentText.setText(content);
//    }

}
