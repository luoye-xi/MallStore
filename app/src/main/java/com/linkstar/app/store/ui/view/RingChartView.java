package com.linkstar.app.store.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hx
 * Time 2018/12/20/020.
 * 环形统计图
 */

public class RingChartView extends View {
    //-------------必须给的数据相关-------------
    private String[] str = new String[]{"购买0次：85%", "购买1次：11%", "购买2次：2%", "购买3次：1%", "购买3次以上：1%"};
    //分配比例大小，总比例大小为100,由于经过运算后最后会是99.55左右的数值，导致圆不能够重合，会留出点空白，所以这里的总比例大小我们用101
    private float[] strPercent = new float[]{50, 25, 13, 6, 6};
    //圆的直径
    private float mRadius = 280;
    //圆的粗细
    private float mStrokeWidth = 40;
    //文字大小
    private int textSize = 20;
    //-------------画笔相关-------------
    //圆环的画笔
    private Paint cyclePaint;
    //文字的画笔
    private Paint textPaint;
    //标注的画笔
    private Paint labelPaint;
    //-------------颜色相关-------------
    //边框颜色和标注颜色
    private int[] mColor = new int[]{0xFF50AFF7, 0xFFFF9804, 0xFFFB5B8C, 0xFFD05BFB, 0xFF08C303};
    //文字颜色
    private int textColor = 0xFF000000;
    //-------------View相关-------------
    //View自身的宽和高
    private int mHeight;
    private int mWidth;


    public RingChartView(Context context) {
        super(context);
    }

    public RingChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RingChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动画布到圆环的左上角
        canvas.translate(mWidth / 2 - mRadius / 2, mHeight / 2 - mRadius / 2);
        //初始化画笔
        initPaint();
        //画圆环
        drawCycle(canvas);
        //画文字和标注
//        drawTextAndLabel(canvas);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //边框画笔
        cyclePaint = new Paint();
        cyclePaint.setAntiAlias(true);
        cyclePaint.setStyle(Paint.Style.STROKE);
        cyclePaint.setStrokeWidth(mStrokeWidth);
        //文字画笔
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(1);
        textPaint.setTextSize(textSize);
        //标注画笔
        labelPaint = new Paint();
        labelPaint.setAntiAlias(true);
        labelPaint.setStyle(Paint.Style.FILL);
        labelPaint.setStrokeWidth(2);
    }

    /**
     * 画圆环
     *
     * @param canvas
     */
    private void drawCycle(Canvas canvas) {
        float startPercent = 0;
        float sweepPercent = 0;
        for (int i = 0; i < strPercent.length; i++) {
            cyclePaint.setColor(mColor[i]);
            startPercent = sweepPercent + startPercent;
            //这里采用比例占100的百分比乘于360的来计算出占用的角度，使用先乘再除可以算出值
            sweepPercent = strPercent[i] * 360 / 100;
            canvas.drawArc(new RectF(0, 0, mRadius, mRadius), startPercent, sweepPercent + 1, false, cyclePaint);
        }
    }

    /**
     * 画文字和标注
     *
     * @param canvas
     */
    private void drawTextAndLabel(Canvas canvas) {
        for (int i = 0; i < strPercent.length; i++) {
            //文字离右边环边距为60，文字与文字之间的距离为40
            canvas.drawText(str[i], mRadius + 200, i * 80, textPaint);
            //画标注,标注离右边环边距为40,y轴则要减去半径（10）的一半才能对齐文字
            labelPaint.setColor(mColor[i]);
            canvas.drawCircle(mRadius + 40, i * 40 - 5, 10, labelPaint);
        }
    }
}
