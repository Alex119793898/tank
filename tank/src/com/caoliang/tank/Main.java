package com.caoliang.tank;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        //游戏音乐
        //new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true){
            Thread.sleep(25);
            tankFrame.repaint();
        }
    }
}
