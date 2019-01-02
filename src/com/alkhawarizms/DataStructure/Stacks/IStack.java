package com.alkhawarizms.DataStructure.Stacks;

/**
 * Created by msoliman on 2/13/17.
 */
public interface IStack<E> {
    boolean isEmpty();

    void push(E obj);
    E pop();
    E top();
    E[] multiPop(int length);
}
