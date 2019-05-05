package com.caoliang.tank;

import com.mashibing.tank.Audio;

import java.awt.*;

public class BaoZha {

    static int WIDTH = ResourceMgr.baoZha[0].getWidth();

    static int HEIGHT = ResourceMgr.baoZha[0].getHeight();


    private int x, y;

    private int step = 0;

    private TankFrame tf = null;


    public BaoZha(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.baoZha[step++],x,y,null);

        if(step >= ResourceMgr.baoZha.length){
            tf.baoZhas.remove(this);
        }
    }


}
