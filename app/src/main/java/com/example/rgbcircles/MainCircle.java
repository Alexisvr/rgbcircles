package com.example.rgbcircles;


import android.graphics.Color;

public class MainCircle extends SimpleCircle{
    public static final int MAIN_SPEED = 50;
    public static final int INT_RADIUS = 50;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INT_RADIUS);
        setColor(OUR_COLOR);
    }


    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHight();
        x += dx;
        y += dy;

    }
}
