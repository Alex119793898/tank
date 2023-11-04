package com.caoliang.tank;


import com.mashibing.tank.Audio;

import java.awt.*;
import java.util.Random;

public class Tank {

    int x = 200, y = 200;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 3;

    private boolean moving = true;

    private TankFrame tf = null;

    private boolean living = true;
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();

    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    private Random random = new Random();

    private Group group = Group.Bad;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!living) tf.tanks.remove(this);

        switch(dir) {
            case LEFT:
                g.drawImage(this.group == Group.Good ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.Good ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.Good ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.Good ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {

        // moving = false 就停止
        if(!moving) return;

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
        //x += 10;
        //y += 10;

        if(group == Group.Bad && random.nextInt(100) > 98)
            this.fire();

        if(group == Group.Bad && random.nextInt(100) > 98)
            randowDir();

        boundsCheck();
    }

    private void boundsCheck() {
        if( x < 2 ) x =  2;
        if( y < 2 ) y =  2;
        if( x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2 ) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if( y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2 ) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randowDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tf.bullets.add(new Bullet(bX, bY, dir, group, tf));

        if(this.group == Group.Good) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void die() {
        living = false;
    }
}
