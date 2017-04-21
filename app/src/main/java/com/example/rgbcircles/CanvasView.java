package com.example.rgbcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Toast;


public class CanvasView extends View  implements ICanvasView{
    private static int widht;
    private static int hight;
    private Paint paint;
    private GameManager gameManager;
    private Canvas canvas;
    private Toast toast;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidhtAndHight(context);
        initPaint();
        gameManager = new GameManager(this,widht,hight);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initWidhtAndHight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        widht = point.x;
        hight = point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(),paint);
    }

    @Override
    public void redraw() {
        invalidate();
    }

    @Override
    public void showMessage(String text) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0 , 0);
        toast.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            gameManager.onTouchEwent(x, y);
        }
        invalidate();
        return true;
    }
}
