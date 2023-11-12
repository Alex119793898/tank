package com.caoliang.abstractfactory;

import com.caoliang.tank.Dir;
import com.caoliang.tank.Group;
import com.caoliang.tank.TankFrame;

public class RectFactory extends GameFactory{

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseBaoZha createBaozha(int x, int y, TankFrame tf) {
        return new RectBaoZha(x,y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }
}
