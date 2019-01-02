package com.alkhawarizms.DataStructure.Queues;

import com.alkhawarizms.DataStructure.Lists.LinkedList;

/**
 * Created by msoliman on 1/22/17.
 *
 *   ////////////////////////////////////////////////////
 Tests
 QueueBasedLinkedList<Integer>  q = new LLQueue();
    q.enqueue(10);
    q.enqueue(30);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.isEmpty());

 ////////////////////////////////////////////////////
 */
public class QueueBasedLinkedList<E> implements IQueue<E> {


    LinkedList<E> lst = new LinkedList();

    //O(1)
    public void enqueue(E elem) {
        lst.addLast(elem);
    }


    //O(1)
    public E dequeue() {
        if (lst.isEmpty())
            return null;

        E first = lst.getFirst();


        lst.removeAt(0);

        return first;

    }

    //O(1)
    public boolean isEmpty() {
        return lst.isEmpty();
    }

}
