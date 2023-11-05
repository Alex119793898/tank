package com.caoliang.tank;

import com.mashibing.tank.Audio;

public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for( int i =0; i<dirs.length; i++){
            new Bullet(bX, bY, dirs[i], t.group, t.tf);
        }

        if(t.group == Group.Good) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();

    }
}
