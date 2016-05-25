package com.joyfulmath.agileexample.oop;

/**
 * @author deman.lu
 * @version on 2016-05-25 14:57
 */
public abstract class Shape {
    int color = 0;
    abstract void draw();
    abstract void accept(ShapeVisit visit);
    void setColor(int color)
    {
        this.color = color;
    }
}
