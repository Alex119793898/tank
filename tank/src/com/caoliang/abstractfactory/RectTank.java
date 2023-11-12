package com.caoliang.abstractfactory;


import com.caoliang.tank.*;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank {

    int x = 200, y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 3;

    private boolean moving = true;

    TankFrame tf = null;

    private boolean living = true;
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();

    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    private Random random = new Random();

    FireStrategy fs ;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if(group == Group.Good) {
            String goodFS = (String) PropertyMgr.get("clGoodFS");

            try {
                fs = (FireStrategy) Class.forName(goodFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else{
            fs = new DefaultFireStrategy();
        }
    }

    public void paint(Graphics g) {
        if(!living) tf.tanks.remove(this);

        Color color = g.getColor();
        g.setColor(group == Group.Good ? Color.RED : Color.BLUE);
        g.fillRect(x,y,40,40);
        g.setColor(color);

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

        rect.x = x;
        rect.y = y;
    }

    private void boundsCheck() {
        if( x < 2 ) x =  2;
        //菜单栏 有30的高度
        if( y < 28 ) y =  28;
        if( x > TankFrame.GAME_WIDTH - RectTank.WIDTH - 2 ) x = TankFrame.GAME_WIDTH - RectTank.WIDTH - 2;
        if( y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2 ) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;
    }

    private void randowDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        //fs.fire(this);
        int bX = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for( int i =0; i<dirs.length; i++){
            //new Bullet(bX, bY, dirs[i], t.group, t.tf);
            tf.gf.createBullet(bX,bY,dirs[i],group,tf);
        }

        //if(group == Group.Good) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
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
