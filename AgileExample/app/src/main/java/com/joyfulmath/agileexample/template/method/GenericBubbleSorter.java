package com.joyfulmath.agileexample.template.method;

/**
 * @author deman.lu
 * @version on 2016-06-09 10:23
 */
public class GenericBubbleSorter<T extends Comparable> extends BubbleSorter {

    private T[] array = null;

    public int sort(T[] theArray)
    {
        array = theArray;
        length = theArray.length;
        return doSort();
    }

    @Override
    protected void swap(int index) {
        T temp = array[index];
        array[index]  = array[index+1];
        array[index+1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return array[index].compareTo(array[index+1])>0;
    }
}
