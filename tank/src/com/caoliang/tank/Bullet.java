package com.caoliang.tank;

import java.awt.*;

public class Bullet {

    static int WIDTH = ResourceMgr.bulletD.getWidth();

    static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private static final int SPEED = 15;

    private int x, y;

    private Dir dir;

    private boolean live = true;

    private TankFrame tf = null;

    private Group group = Group.Bad;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }

    }

    public void knockWith(Tank tank) {
        if(group == tank.getGroup()) return;

        //TODO: 用rect 来记录子弹的位置
        Rectangle rect1 = new Rectangle(x, y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.x, tank.y, tank.WIDTH, tank.HEIGHT);

        if(rect1.intersects(rect2)){
            this.die();
            tank.die();

            int eX = tank.getX() + Tank.WIDTH / 2 - BaoZha.WIDTH /2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - BaoZha.HEIGHT / 2;
            tf.baoZhas.add(new BaoZha(eX, eY, tf));
        }
    }

    private void die() {
        live = false;
    }
}
