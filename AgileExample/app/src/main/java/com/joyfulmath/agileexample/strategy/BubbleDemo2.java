package com.joyfulmath.agileexample.strategy;

import com.joyfulmath.agileexample.TraceLog;

/**
 * @author deman.lu
 * @version on 2016-06-09 11:36
 */
public class BubbleDemo2 {
    public static void action()
    {
        Integer[] array = new Integer[]{
                1,2,3,5,6,8,10,0,2,3
        };
        GenericSortHandle<Integer> intBubleSorter = new GenericSortHandle<>();
        BubbleSorter bubbleSorter = new BubbleSorter(intBubleSorter);
        bubbleSorter.sort(array);
        for(int i=0;i<array.length;i++)
        {
            TraceLog.i(array[i].toString());
        }
    }
}
