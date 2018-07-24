package com.alkhawarizms.DataStructure.Stacks;


import com.alkhawarizms.DataStructure.Arrays.ArrayBase;

/**
 * Created by msoliman on 1/19/17.
 */
public class StackBasedArray<E> extends ArrayBase<E> implements IStack<E> {

    int indx = -1;

    public boolean isEmpty() {
        return indx == -1;
    }

    public void push(E i) {

        store[++indx] = i;
        if (indx == store.length - 1)
            store = expand();

    }

    public E pop() {
        if (isEmpty())
            return null;

        return store[indx--];
    }

    @Override
    public E top() {
        return store[indx];
    }

    @Override
    public E[] multiPop(int length) {

        //note that it will return all elements of stack if they are less than "length"
        E[] elems = (E[]) new Object[length];

        int count = 0;
        while (length-- > 0)
            elems[count++] = pop();


        return elems;
    }




}
