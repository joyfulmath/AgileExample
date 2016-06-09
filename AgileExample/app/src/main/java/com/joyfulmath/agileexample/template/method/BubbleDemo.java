package com.joyfulmath.agileexample.template.method;

import com.joyfulmath.agileexample.TraceLog;

/**
 * @author deman.lu
 * @version on 2016-06-09 10:26
 */
public class BubbleDemo {

    public static void action()
    {
        Integer[] array = new Integer[]{
                1,2,3,5,6,8,10,0,2,3
        };
        GenericBubbleSorter<Integer> intBubleSorter = new GenericBubbleSorter<>();
        intBubleSorter.sort(array);
        for(int i=0;i<array.length;i++)
        {
            TraceLog.i(array[i].toString());
        }
    }
}
