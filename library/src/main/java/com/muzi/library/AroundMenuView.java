package com.muzi.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muzi on 2018/4/9.
 * 727784430@qq.com
 */
public class AroundMenuView extends View {

    private int widthMeasure, heightMeasure;

    private int radius;//半径

    private int minSize = 130;//最小尺寸

    private Paint paint;

    public AroundMenuView(Context context) {
        this(context, null);
    }

    public AroundMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode, heightMode;
        widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        widthMode = MeasureSpec.getMode(widthMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST) {
            widthMeasure = minSize;
        }

        heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
        heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode == MeasureSpec.AT_MOST) {
            heightMeasure = minSize;
        }
        radius = widthMeasure / 2;
        setMeasuredDimension(widthMeasure, heightMeasure);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(radius, radius, radius, paint);
    }
}
