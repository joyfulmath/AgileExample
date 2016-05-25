package com.joyfulmath.agileexample.oop;

/**
 * @author deman.lu
 * @version on 2016-05-25 16:24
 */
public class ShapeVisitImpl implements ShapeVisit {
    @Override
    public void visit(Cycle cycle) {
        cycle.setColor(1);
    }

    @Override
    public void visit(Square spare) {
        spare.setColor(2);
    }
}
