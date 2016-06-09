package com.joyfulmath.agileexample.strategy;

/**
 * @author deman.lu
 * @version on 2016-06-09 10:51
 */
public class BubbleSorter {
    private int operations = 0;
    protected int length = 0;
    private SortHandler itsSortHandle = null;

    public BubbleSorter(SortHandler itsSortHandle) {
        this.itsSortHandle = itsSortHandle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        operations = 0;
        if (length <= 1)
            return operations;

        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index);
                }
                operations++;
            }
        return operations;
    }

}
