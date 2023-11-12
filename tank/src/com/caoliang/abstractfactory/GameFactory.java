package com.caoliang.abstractfactory;

import com.caoliang.tank.Dir;
import com.caoliang.tank.Group;
import com.caoliang.tank.TankFrame;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseBaoZha createBaozha(int x, int y, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
