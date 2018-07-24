package com.alkhawarizms.DataStructure.Lists;

/**
 * Created by msoliman on 1/27/17.
 */
public interface ILinkedList<E> {
    boolean isEmpty();
    int size();
    void addFirst(E obj);
    void addLast(E obj);
    void  addAt(E obj, int index);
    void addBefore(E node, E obj);
    void addAfter(E node, E obj);

    boolean removeFirst();
    boolean removeLast();
    boolean removeAt(int indx);


    //also named peek first - peek last
    E getFirst();
    E getLast();
    E getAt(int indx);




}
