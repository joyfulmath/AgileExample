package com.joyfulmath.agileexample.strategy;

/**
 * @author deman.lu
 * @version on 2016-06-09 11:30
 */
public interface SortHandler {
    void swap(int index);
    boolean outOfOrder(int index);
    int length();
    void setArray(Object array);
}
