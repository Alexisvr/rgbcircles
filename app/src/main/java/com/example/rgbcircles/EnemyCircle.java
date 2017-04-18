package com.example.rgbcircles;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by vorobev on 18.04.2017.
 */
public class EnemyCircle extends SimpleCircle {
    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 100;
    public static final int EMEMY_CIRCLE = Color.RED;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHight());
        int raduis = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, raduis);
        enemyCircle.setColor(EMEMY_CIRCLE);
        return enemyCircle;
    }
}
