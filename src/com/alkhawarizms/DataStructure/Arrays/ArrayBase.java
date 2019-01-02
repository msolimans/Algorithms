package com.alkhawarizms.DataStructure.Arrays;



/**
 * Created by msoliman on 1/21/17.
 */
public class ArrayBase<E extends Object> implements Comparable<E>{

    public E[] store = (E[])new Object[10];


    public E[] expand() {

        E[] temp = store.clone();

        store = (E[])new Object[store.length * 2];

        for (int i = 0; i <= temp.length - 1; i++)
            store[i] = temp[i];

        temp = null;

        return store;

    }

    public E[] grow() {
        E[] temp = store;
        int capacity = store.length;
        store = (E[]) new Object[capacity * 2];
        System.arraycopy(temp, 0, store, 0, capacity);
        temp = null;
        return store;
    }


    public void rshift(int from) {
        //--->
        int c = store.length - 1;
        while (c >= from)
            store[c + 1] = store[c];


    }

    public void lshift(int to) {
        //<----

        while (to < store.length - 1)
            store[to] = store[++to];

    }


    @Override
    public int compareTo(E o) {
        return 0;
    }
}
