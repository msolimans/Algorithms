package com.alkhawarizms.DataStructure.Queues;

/**
 * Created by msoliman on 2/13/17.
 */
public interface IQueue<E> {
    boolean isEmpty();
    void enqueue(E obj);
    E dequeue();
}
