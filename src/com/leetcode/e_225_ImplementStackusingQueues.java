package com.leetcode;

//e_225_ImplementStackusingQueues 
//Show Topic Tags


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Implement the following operations of a stack using queues.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//empty() -- Return whether the stack is empty.
//Example:
//
//MyStack stack = new MyStack();
//
//stack.push(1);
//stack.push(2);
//stack.top();   // returns 2
//stack.pop();   // returns 2
//stack.empty(); // returns false
//Notes:
//
//You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
//Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
//You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/implement-stack-using-queues/
//******************************************************************************************************************

//first in, first out [based on linkedList implementation)
class SimpleQueue {
    LinkedList<Integer> lst;


    public SimpleQueue() {
        lst = new LinkedList<>();
    }


    //push to the list
    public void push(int x) {
        lst.add(x);
    }

    //pop from the first the list and return it.
    public int pop() {
        int result = lst.getFirst();
        lst.removeFirst();
        return result;
    }

    //just return the first elm
    public int peek() {
        return lst.getFirst();
    }

    //return whether the list is empty
    public int size() {
        return lst.size();
    }
}

//last in, first out
class MyStack {
    private SimpleQueue queue1;
    private SimpleQueue queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new SimpleQueue();
        queue2 = new SimpleQueue();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //check whether queue2 has data, if so push more data to it otherwise default pushing to queue1
        if (queue2.size() > 0) {
            queue2.push(x);
            return;
        }

        queue1.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return getLast(true);

    }

    //the idea is to pop all elems from the queue except the last one [the last one should be our result]
    //suppose we have in queue1 [1,2,3] => move 1,2 to the queue2, and return 3, in case of top, store it in move 3 also before you return
    private int getLast(boolean withPop) {
        if (empty())
            return -1;

        int result = 0;
        //the followin conditional if statements are just checking which queue has data
        if (queue1.size() > 0) {
            while (queue1.size() > 1) {
                queue2.push(queue1.pop());
            }

            if (withPop) {
                result = queue1.pop();
            } else {
                result = queue1.peek();
                //keep it, don't remove just peek operation
                queue2.push(queue1.pop());
            }

        } else {

            while (queue2.size() > 1) {
                queue1.push(queue2.pop());
            }

            if (withPop)
                result = queue2.pop();
            else {
                result = queue2.peek();
                queue1.push(queue2.pop());
            }

        }

        return result;
    }


    /**
     * Get the top element.
     */
    public int top() {
        return getLast(false);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.size() == 0 && queue2.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class e_225_ImplementStackusingQueues {


    public static void main(String[] args) {


    }

    @Test
    public void TestStackOps() {
        MyStack stack = new MyStack();
        stack.push(10);
        Assert.assertEquals(10, stack.top());
        Assert.assertEquals(10, stack.pop());
        Assert.assertEquals(true, stack.empty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        stack.push(3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(1, stack.pop());
         Assert.assertEquals(-1, stack.pop());


    }
}
