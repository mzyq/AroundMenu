package com.muzi.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muzi on 2018/4/9.
 * 727784430@qq.com
 */
public class MenuButton extends View {

    private int circleSize;

    private int radius;//半径


    private int size = DefalutConfig.MIN_SIZE;

    private int color = DefalutConfig.DEFAULT_COLOR;

    private Paint paint;

    public MenuButton(Context context) {
        this(context, DefalutConfig.MIN_SIZE, DefalutConfig.DEFAULT_COLOR);
    }

    public MenuButton(Context context, int size, int color) {
        this(context, null);
        this.size = size;
        this.color = color;
    }

    public MenuButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasure, heightMeasure;
        int widthMode, heightMode;
        widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        widthMode = MeasureSpec.getMode(widthMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST) {
            widthMeasure = size;
        }

        heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
        heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode == MeasureSpec.AT_MOST) {
            heightMeasure = size;
        }

        circleSize = widthMeasure > heightMeasure ? heightMeasure : widthMeasure;

        radius = circleSize / 2;
        setMeasuredDimension(circleSize, circleSize);
    }

    public void setSize(int size) {
        this.size = size;
        requestLayout();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(radius, radius, radius, paint);
    }
}
