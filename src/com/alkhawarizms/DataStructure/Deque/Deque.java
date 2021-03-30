package com.alkhawarizms.DataStructure.Deque;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Deque {
    LinkedList<Integer> queue;

    public Deque() {
        queue = new LinkedList<>();
    }

    public void add(int i) {
        if (queue.isEmpty() || queue.getLast() > i) {
            queue.addLast(i);
            return;
        }

        while (!queue.isEmpty() && queue.getLast() < i)
            queue.pollLast();

        queue.addLast(i);
    }

    public int pop() {
        if (!queue.isEmpty())
            return queue.pollFirst();
        return -1;
    }

    public int peek() {
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    @Test
    public void TestAdd() {
        Deque d = new Deque();
        d.add(10);
        Assert.assertEquals(1, d.size());
        d.add(20);
        Assert.assertEquals(1, d.size());
        d.add(10);
        d.add(5);
        Assert.assertEquals(3, d.size());
        d.add(30);
        Assert.assertEquals(1, d.size());


    }

    @Test
    public void TestPop() {

        Deque d = new Deque();
        d.add(10);

        d.add(20);
        Assert.assertEquals(20, d.pop());
        d.add(10);
        d.add(5);
        Assert.assertEquals(10, d.pop());
        Assert.assertEquals(5, d.pop());
        Assert.assertEquals(0, d.size());

        d.add(30);
        Assert.assertEquals(30, d.peek());


    }
}
