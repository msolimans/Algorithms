package com.alkhawarizms.DataStructure.Queues;

import com.alkhawarizms.DataStructure.Stacks.StackBasedQueue;

import java.util.Stack;

/**
 * Created by msoliman on 5/1/17.
 */
public class QueueBasedStack<E> implements IQueue<E> {
    public static void main(String[] args){
        QueueBasedStack<Integer> q = new QueueBasedStack<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    Stack<E> s1 = new Stack<>();
    Stack<E> s2 = new Stack<>();


    @Override
    public boolean isEmpty() {
        return s1.isEmpty();
    }


    @Override
    public void enqueue(E obj) {
        s1.push(obj);
    }


    @Override
    public E dequeue() {
        if(s2.isEmpty() && s1.isEmpty())
            return null;

        else if(s2.isEmpty())
            while(!s1.isEmpty())
                s2.push(s1.pop());

        return s2.pop();
    }
}
