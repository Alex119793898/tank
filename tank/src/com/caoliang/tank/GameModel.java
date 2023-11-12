package com.caoliang.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.Good,this);

    List<Bullet> bullets = new ArrayList<>();

    List<Tank> tanks = new ArrayList<>();

    List<BaoZha> baoZhas = new ArrayList<>();

    public GameModel() {

        Integer initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //初始化地方坦克
        for(int i =0; i<initTankCount; i++){
            tanks.add(new Tank(50 + 80 * i, 100, Dir.DOWN, Group.Bad, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + baoZhas.size(), 10, 100);
        g.setColor(c);

        System.out.println("pain all!");
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        // 在迭代过程中删除子弹 itrator.remove()
        /*for(Iterator<Bullet> it = bullets.iterator(); it.hasNext();){
            Bullet b = it.next();
            if(!b.live){
                it.remove();
            }
        }*/

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i=0; i<bullets.size(); i++){
            for(int j=0; j<tanks.size(); j++){
                bullets.get(i).knockWith(tanks.get(j));
            }
        }

        for (int i=0; i<baoZhas.size(); i++){
            baoZhas.get(i).paint(g);
        }

    }

    public Tank getMyTank(){
        return myTank;
    }


}
