package com.joyfulmath.agileexample.strategy;

/**
 * @author deman.lu
 * @version on 2016-06-09 11:34
 */
public class GenericSortHandle<T extends Comparable> implements SortHandler {
    private T[] array = null;

    @Override
    public void swap(int index) {
        T temp = array[index];
        array[index]  = array[index+1];
        array[index+1] = temp;
    }

    @Override
    public boolean outOfOrder(int index) {
        return array[index].compareTo(array[index+1])>0;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public void setArray(Object array) {
        this.array = (T[]) array;
    }
}
