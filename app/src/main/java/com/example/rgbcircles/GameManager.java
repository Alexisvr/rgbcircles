package com.example.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;


public class GameManager {
    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int widgt;
    private static int hight;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        widgt =w;
        hight = h;
        initMainCircle();
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(widgt/2, hight/2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }
}
