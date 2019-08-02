package com.leetcode;

//e_232_ImplementQueueusingStacks
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Implement the following operations of a queue using stacks.
//
//push(x) -- Push element x to the back of queue.
//pop() -- Removes the element from in front of queue.
//peek() -- Get the front element.
//empty() -- Return whether the queue is empty.
//Example:
//
//MyQueue queue = new MyQueue();
//
//queue.push(1);
//queue.push(2);
//queue.peek();  // returns 1
//queue.pop();   // returns 1
//queue.empty(); // returns false
//Notes:
//
//You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
//You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/implement-queue-using-stacks/
//******************************************************************************************************************
//1st in 1st out
class MyQueue {

    //stack has the rule: last in, 1st out
    //maintain 2 stacks, "mainstk" for main operations (push, size and empty) and the other "tempstk" for (pop and peek)
    private Stack<Integer> mstk, tempstk;


    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        mstk = new Stack<>();
        tempstk = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        mstk.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return getFirst(true);
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return getFirst(false);

    }

    int getFirst(boolean withPop) {

        //if mainstk doesn't have anything return -1 (it's not required step as they said in the notes it will be guaranteed that it will have data)
        if (mstk.size() == 0)
            return -1;

        //pop everything from mstk and push them (in a revrse order) to tempstk
        while (mstk.size() > 0) {
            tempstk.push(mstk.pop());
        }
        //store the result
        int result = 0;
        if (withPop)
            result = tempstk.pop();
        else
            result = tempstk.peek();

        //push them back to mstk in case we need to do more push ops
        while (tempstk.size() > 0) {
            mstk.push(tempstk.pop());
        }

        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return mstk.size() == 0;
    }

}

public class e_232_ImplementQueueusingStacks {


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(10);
        System.out.println(queue.pop());

    }


    @Test
    public void TestQueueOps() {
        MyQueue queue = new MyQueue();
        Assert.assertEquals(-1, queue.pop());
        queue.push(10);
        Assert.assertEquals(10, queue.peek());
        Assert.assertEquals(10, queue.pop());

        queue.push(10);
        queue.push(20);
        queue.push(30);
        Assert.assertEquals(10, queue.peek());
        Assert.assertEquals(10, queue.pop());
        Assert.assertEquals(20, queue.peek());
        Assert.assertEquals(20, queue.pop());

    }


}
