package com.caoliang.abstractfactory;

import com.caoliang.tank.Group;

import java.awt.*;

public abstract class BaseTank {

    public Group group = Group.Bad;

    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup(){
        return this.group;
    };

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
