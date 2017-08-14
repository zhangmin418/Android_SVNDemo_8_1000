package jiyun.com.example.lenovo.android_svndemo_8_10.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenovo on 2017/8/11.
 */

public class CircularView extends View {
    private Paint rimPaint;
    private RectF circleBounds;
    public CircularView(Context context) {
        super(context);
    }

    public CircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rimPaint = new Paint();
        circleBounds = new RectF(2, 2, 52, 52);
        rimPaint.setAntiAlias(true);
        rimPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        rimPaint.setStrokeWidth(10);
        rimPaint.setColor(Color.GREEN);

        canvas.drawCircle(100f, 50f, 40, rimPaint);
        //画线 canvas.drawLine(0, 0, 34, 34, rimPaint);

    }
}
