package com.caoliang.tank;

import java.awt.*;

public class Bullet {

    private int width = 20;

    private int height = 20;

    private static final int SPEED = 10;

    private int x, y;

    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);


        moving();
    }

    private void moving() {

        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

    }
}
