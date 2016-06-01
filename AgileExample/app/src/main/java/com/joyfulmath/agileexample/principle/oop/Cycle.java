package com.joyfulmath.agileexample.principle.oop;

import com.joyfulmath.agileexample.TraceLog;

/**
 * @author deman.lu
 * @version on 2016-05-25 15:02
 */
public class Cycle extends Shape {
    @Override
    void draw() {
        TraceLog.i("Cycle draw with color:"+color);
    }

    @Override
    void accept(ShapeVisit visit) {
        visit.visit(this);
    }
}
