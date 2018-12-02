package com.bwie.day03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文件描述：
 * 作者：鲁华丰
 * 创建时间：2018/11/29
 */
public class MyLuckView extends View implements View.OnClickListener{
    private String[] contents = new String[]{"美 女", "女 神", "热 舞", "丰 满", "性 感", "知 性"};
    public int[] colors = new int[]{Color.parseColor("#8EE5EE"), Color.parseColor("#FFD700"), Color.parseColor("#FFD39B"), Color.parseColor("#FF8247"), Color.parseColor("#FF34B3"), Color.parseColor("#F0E68C")};
    private int mWidth;
    private Paint mPaint;
    private Context mContext;

    public MyLuckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mPaint = new Paint();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0, 0, mWidth, mWidth);
        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < colors.length; i++) {
            mPaint.setColor(colors[i]);
            int startjd = i * 60;//i=0 0 i=1 =60
            canvas.drawArc(rectF, startjd, 60, true, mPaint);
        }
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        for (int i = 0; i < contents.length; i++) {
            int startjd = i * 60;//i=0 0 i=1 =60
            Path path = new Path();
            path.addArc(rectF, startjd, 60);
            canvas.drawTextOnPath(contents[i], path, 50, 50, mPaint);
        }

        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(mWidth / 2, mWidth / 2, 50, mPaint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(300, 300);
        mWidth = getMeasuredWidth();
    }

    @Override
    public void onClick(View view) {

    }
}
