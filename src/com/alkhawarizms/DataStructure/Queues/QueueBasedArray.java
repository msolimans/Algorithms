package com.alkhawarizms.DataStructure.Queues;


import com.alkhawarizms.DataStructure.Arrays.ArrayBase;

import java.util.Objects;

/**
 * Created by msoliman on 1/22/17.
 *
 * Description:
    Queues are exactly the same concept as serving in row or lines where the first person who comes first should be served first
    Usually named First in First out (FIFO)
    Implementation based on circular arrays where the index of the write or read are going to the beginning of the array if it is full
    Limitation of array based implementation is the size, if you decided to expand then there is no way to do it in circular thus wasting memory space of dequeued elems
 * Time Complexities:
    Has the following operations:
    enqueue: O(1)
    dequeue: O(1)
    empty: O(1)

 */
public class QueueBasedArray<E> extends ArrayBase<E> {
    //first represents the index for read operation
    int first = -1;

    //last represents the index for the write operation
    int last = -1;
    int length = 0;


    boolean isEmpty() {
        return length == 0;
    }

    void enqueue(E item) {
        length++;
        last = (last + 1) % 6;
        store[last] = item;
    }



    E dequeue() {
        if (isEmpty())
            return null;

        length--;
        first = (first + 1) % 6;

        return store[first];
    }

    E[] multidequeue(int l) throws IndexOutOfBoundsException {
        if (l > length)
            throw new IndexOutOfBoundsException("Boundary exceeded length of queue");

        E[] temp = (E[]) new Object[l];

        for (int i = 0; i < l; i++)
            temp[0] = dequeue();

        return temp;

    }


}
