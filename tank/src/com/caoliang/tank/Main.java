package com.caoliang.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        //初始化地方坦克
        for(int i =0; i<5; i++){
            tankFrame.tanks.add(new Tank(50 + 80 * i, 100, Dir.DOWN, Group.Bad, tankFrame));
        }

        while (true){
            Thread.sleep(25);
            tankFrame.repaint();
        }
    }
}
