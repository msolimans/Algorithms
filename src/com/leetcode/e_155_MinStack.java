package com.leetcode;

//e_155_MinStack 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//
//
//Example:
//
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.
//

//******************************************************************************************************************
//Companies: Amazon | 12  Microsoft | 8  Bloomberg | 7  Apple | 5  Adobe | 3  Goldman Sachs | 3  Google | 2  Wish | 2  Flipkart | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/min-stack/
//******************************************************************************************************************

public class e_155_MinStack {


    class MinNode {
        int val;
        MinNode next;
        int minVal;

        MinNode(int v, int min) {
            this.val = v;
            this.minVal = min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    class MinStack {

        //this node is a pre node to the head
        MinNode preHead = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            preHead = new MinNode(0, 0);
        }

        //push always next to the pre-head node
        public void push(int x) {
            //in case we don't have any elems or nodes added yet, next node to preHead will be null
            if (preHead.next == null) {
                preHead.next = new MinNode(x, x);
            } else {
                //add new node between preHead and preHead.next
                // add 10 to 0->20->30 will result in
                //   head=20->30
                //   preHead=0->10
                //   preHead=0->10->head
                //   preHead=0->10->20->30
                MinNode head = preHead.next;
                //everytime we add a new elem, we check its value with previously recorded MIN value and store the minimum of both of them
                preHead.next = new MinNode(x, Math.min(head.minVal, x));
                preHead.next.next = head;
            }
        }

        public void pop() {
            //always remember the first elem in the next elem to preHead
            if (preHead.next != null)
                //repoint preHead to the next(next elem)
                // 0->10->20
                // 0-------^
                preHead.next = preHead.next.next;
        }

        public int top() {
            //return the next elem to preHead
            // 0->10->20
            //     ^
            if (preHead.next != null)
                return preHead.next.val;
            return 0;
        }

        public int getMin() {
            //we always store min elem to every node
            //so returning this will be like val in a constant time
            if (preHead.next != null)
                return preHead.next.minVal;

            return 0;

        }
    }


    @Test
    public void TestMinStackOperations() {
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(20);

        Assert.assertEquals(20, ms.top());
        Assert.assertEquals(10, ms.getMin());


        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());

        Assert.assertEquals(-2, minStack.getMin());


    }

}
