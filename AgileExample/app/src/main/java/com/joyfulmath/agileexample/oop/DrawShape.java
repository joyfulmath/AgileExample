package com.joyfulmath.agileexample.oop;

import java.util.Vector;

/**
 * @author deman.lu
 * @version on 2016-05-25 15:02
 */
public class DrawShape {

    public static void drawShapes(Vector<Shape> shapes)
    {
        ShapeVisitImpl shapeVisit = new ShapeVisitImpl();
        for(Shape shape:shapes)
        {
            shape.accept(shapeVisit);
            shape.draw();
        }

    }

    public static void action()
    {
        Vector<Shape> mShapes = new Vector<>(10);
        Shape s = new Cycle();
        mShapes.add(s);
        Shape m = new Square();
        mShapes.add(m);
        drawShapes(mShapes);
    }
}
