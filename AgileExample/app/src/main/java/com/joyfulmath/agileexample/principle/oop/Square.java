package com.joyfulmath.agileexample.principle.oop;

import com.joyfulmath.agileexample.TraceLog;

/**
 * @author deman.lu
 * @version on 2016-05-25 14:58
 */
public class Square extends Shape {
    @Override
    void draw() {
        TraceLog.i("Square draw with color:" + color);
    }

    @Override
    void accept(ShapeVisit visit) {
        visit.visit(this);
    }
}
