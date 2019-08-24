package com.leetcode.shared;

public class Queue<E> {

    java.util.LinkedList<E> list;

    public Queue() {
        list = new java.util.LinkedList<>();
    }

    public boolean empty() {
        return list.isEmpty();
    }

    public void enqueue(E i) {
        list.add(i);
    }

    public E dequeue() throws Exception {
        return  list.pollFirst();
    }
}
