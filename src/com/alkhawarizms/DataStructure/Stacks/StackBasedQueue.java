package com.alkhawarizms.DataStructure.Stacks;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by msoliman on 5/1/17.
 */


class MySimpleQueue<E> {
    int indx1 = 0;
    int indx2 = 0;
    int length = 0;

    E[] elems = (E[]) new Object[20];

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public boolean enqueue(E elem) {

        if (indx1 < indx2 && indx2 - indx1 == 1)
            return false;

        elems[indx1 % elems.length] = elem;

        indx1++;

        length++;
        return true;
    }

    public E dequeue() {

        if (indx2 == indx1)
            return null;

        E e = elems[indx2 % elems.length];
        indx2++;
        length--;
        return e;

    }


}


public class StackBasedQueue<E> {

    public static void main(String[] args){
        StackBasedQueue<Integer> s = new StackBasedQueue<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }


    MySimpleQueue<E> q1 = new MySimpleQueue<>();
    MySimpleQueue<E> q2 = new MySimpleQueue<>();


    public boolean push(E elem) {
        if (!q1.isEmpty())
            q1.enqueue(elem);
        else
            q2.enqueue(elem);

        return true;
    }

    public E pop() {

        if (!q1.isEmpty()) {
            while (q1.size() > 1)
                q2.enqueue(q1.dequeue());

            return q1.dequeue();
        }

        if (!q2.isEmpty()) {
            while (q2.size() > 1)
                q1.enqueue(q2.dequeue());

            return q2.dequeue();
        }

        return null;

    }


}
