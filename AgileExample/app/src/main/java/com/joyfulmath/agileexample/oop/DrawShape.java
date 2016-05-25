package com.joyfulmath.agileexample.oop;

import java.util.Vector;

/**
 * @author deman.lu
 * @version on 2016-05-25 15:02
 */
public class DrawShape {

    public void drawShapes(Vector<Shape> shapes)
    {
        for(Shape shape:shapes)
        {
            shape.draw();
        }

    }
}
