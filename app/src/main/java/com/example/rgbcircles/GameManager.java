package com.example.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;


public class GameManager {
    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int width;
    private static int hight;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        hight = h;
        initMainCircle();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHight() {
        return hight;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width/2, hight/2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }

    public void onTouchEwent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
