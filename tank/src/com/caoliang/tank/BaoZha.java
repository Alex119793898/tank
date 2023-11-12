package com.caoliang.tank;

import com.caoliang.abstractfactory.BaseBaoZha;
import com.mashibing.tank.Audio;

import java.awt.*;

public class BaoZha extends BaseBaoZha {

    public static int WIDTH = ResourceMgr.baoZha[0].getWidth();

    public static int HEIGHT = ResourceMgr.baoZha[0].getHeight();


    private int x, y;

    private int step = 0;

    private TankFrame tf = null;


    public BaoZha(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        //new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.baoZha[step++],x,y,null);

        if(step >= ResourceMgr.baoZha.length){
            tf.baoZhas.remove(this);
        }
    }


}
