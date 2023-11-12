package com.caoliang.abstractfactory;

import com.caoliang.tank.ResourceMgr;
import com.caoliang.tank.TankFrame;
import com.mashibing.tank.Audio;

import java.awt.*;

public class RectBaoZha extends BaseBaoZha{

    static int WIDTH = ResourceMgr.baoZha[0].getWidth();

    static int HEIGHT = ResourceMgr.baoZha[0].getHeight();


    private int x, y;

    private int step = 0;

    private TankFrame tf = null;


    public RectBaoZha(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        //new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        //g.drawImage(ResourceMgr.baoZha[step++],x,y,null);

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 15*step, 15*step);
        step++;

        g.setColor(color);

        if(step >= 5){
            tf.baoZhas.remove(this);
        }
    }


}
