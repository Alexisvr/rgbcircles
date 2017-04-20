package com.example.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

// тестовый текст для коммита

public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int width;
    private static int hight;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        hight = h;
        initMainCircle();
        initEnemyCircle();
    }

    private void initEnemyCircle() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;

            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
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
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEwent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                gameEnd();
            }
        }

    }

    private void gameEnd() {
        mainCircle.initRadius();
        initEnemyCircle();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {
            circle.MoveOneStep();
        }
    }
}


