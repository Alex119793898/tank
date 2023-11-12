package com.caoliang.abstractfactory;

import com.caoliang.tank.Group;
import com.caoliang.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {

    public abstract void paint(Graphics g);

    public abstract void knockWith(BaseTank tank);
}
