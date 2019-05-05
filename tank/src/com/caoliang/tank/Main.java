package com.caoliang.tank;

import com.mashibing.tank.Audio;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        Integer initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化地方坦克
        for(int i =0; i<initTankCount; i++){
            tankFrame.tanks.add(new Tank(50 + 80 * i, 100, Dir.DOWN, Group.Bad, tankFrame));
        }

        //游戏音乐
        //new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true){
            Thread.sleep(25);
            tankFrame.repaint();
        }
    }
}
