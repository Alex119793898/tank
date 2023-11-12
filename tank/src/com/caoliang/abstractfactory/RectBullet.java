package com.caoliang.abstractfactory;

import com.caoliang.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {

    static int WIDTH = ResourceMgr.bulletD.getWidth();

    static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private static final int SPEED = 15;

    private int x, y;

    private Dir dir;

    private boolean live = true;

    private TankFrame tf = null;

    private Group group = Group.Bad;

    Rectangle rect = new Rectangle();

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }

        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,20,20);
        g.setColor(color);

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

        rect.x = x;
        rect.y = y;

    }

    public void knockWith(BaseTank tank) {
        if(group == tank.getGroup()) return;

        //用rect 来记录子弹的位置
        //Rectangle rect1 = new Rectangle(x, y, WIDTH, HEIGHT);
        //Rectangle rect2 = new Rectangle(tank.x, tank.y, tank.WIDTH, tank.HEIGHT);

        if(rect.intersects(tank.rect)){
            this.die();
            tank.die();

            int eX = tank.getX() + Tank.WIDTH / 2 - BaoZha.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - BaoZha.HEIGHT / 2;
            tf.baoZhas.add(tf.gf.createBaozha(eX, eY, tf));
        }
    }

    private void die() {
        live = false;
    }
}
