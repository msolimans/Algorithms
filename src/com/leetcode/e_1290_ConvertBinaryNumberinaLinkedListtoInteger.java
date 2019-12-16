package com.leetcode;

import com.leetcode.shared.LinkedList;
import com.leetcode.shared.ListNode;
import org.junit.Assert;
import org.junit.Test;

//e_1290_ConvertBinaryNumberinaLinkedListtoInteger 
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
//
//Return the decimal value of the number in the linked list.
//
//
//
//Example 1:
//
//
//Input: head = [1,0,1]
//Output: 5
//Explanation: (101) in base 2 = (5) in base 10
//Example 2:
//
//Input: head = [0]
//Output: 0
//Example 3:
//
//Input: head = [1]
//Output: 1
//Example 4:
//
//Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//Output: 18880
//Example 5:
//
//Input: head = [0,0]
//Output: 0
//
//
//Constraints:
//
//The Linked List is not empty.
//Number of nodes will not exceed 30.
//Each node's value is either 0 or 1.

//******************************************************************************************************************
//Companies: Roblox
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_1290_ConvertBinaryNumberinaLinkedListtoInteger {


    int getLength(ListNode head) {

        if (head == null)
            return 0;

        return 1 + getLength(head.next);
    }

    public int getDecimalValue1(ListNode head) {
        if (head == null)
            return 0;


        //get length of list
        int len = getLength(head);


        ListNode c = head;
        int sum = 0;

        //loop through list items, if current bit is 1, multiply it with pow of 2 at this index
        //how to calc the following binary to decimal
        //1     0   1   0   1
        //2^4       2^2     2^0
        //16    +    4       1 = 21
        while (c != null) {
            len--;
            if (c.val == 1)
                sum += Math.pow(2, len);

            c = c.next;
        }

        return sum;
    }


    //Using Bitwise Operation
    public int getDecimalValue(ListNode head) {


        //A single left shift multiplies a binary number by 2
        //  Decimal 2 equals 0010 << 1  =  0100 (equals decimal 4)


        //Logical Right Shift
        //a single logical right shift divides a number by 2, throwing out any remainders.

        //Arithmetic right shift
        // the least-significant bit is lost and the most-significant bit is copied.
        //e.g.
        // 1011 >> 1  =  1101
        // 1011 >> 3  => removes 011 will result in "1", copy the most-significant but {left side bit} => 1111
        //0011 >> 1  →  0001
        //0011 >> 2  →  0000
        //If a number is encoded using two's complement, then an arithmetic right shift preserves the number's sign, while a logical right shift makes the number positive.
        //More Info: https://www.interviewcake.com/concept/java/bit-shift

        ListNode c = head;
        int sum = 0;

        while (c != null) {
            //how to calc the following binary to decimal
            //1     0   1   0   1
            //2^4       2^2     2^0
            //16    +    4       1 = 21

            //bit shifting operation to convert from binary to decimal [FROM LEFT TO RIGHT]

            //0 << 1 | 1
            //0*2 | 1
            //1

            //1<<1 | 0
            //1*2 | 0
            // 2

            //2 << 1 | 1
            // 2 * 2 = 4 | 1
            //0 1 0 0
            //0 0 0 1
            //0 1 0 1
            // 5

            //5 * 2 | 0
            //10 | 0
            //10

            //10 * 2 | 1
            //20 | 1
            //1 0 1 0 0
            //0 0 0 0 1
            //1 0 1 0 1
            //21
            //1 0 1 0 1
            //1 + 2^2 + 2^4

            //if we focus in the operations above, we multiply 2 for how many times, length of binary string, and add 1 in case we have current bit equals 1
            sum = (sum << 1) | c.val;
            c = c.next;
        }


        return sum;
    }

    @Test
    public void Teste_1290_ConvertBinaryNumberinaLinkedListtoInteger() {

        Assert.assertEquals(5, getDecimalValue(new LinkedList(new int[]{1, 0, 1}).root));
        Assert.assertEquals(1, getDecimalValue(new LinkedList(new int[]{1}).root));
        Assert.assertEquals(18880, getDecimalValue(new LinkedList(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}).root));
        Assert.assertEquals(0, getDecimalValue(new LinkedList(new int[]{0, 0}).root));



        Assert.assertEquals(5, getDecimalValue1(new LinkedList(new int[]{1, 0, 1}).root));
        Assert.assertEquals(1, getDecimalValue1(new LinkedList(new int[]{1}).root));
        Assert.assertEquals(18880, getDecimalValue1(new LinkedList(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}).root));
        Assert.assertEquals(0, getDecimalValue1(new LinkedList(new int[]{0, 0}).root));
        Assert.assertEquals(34, getDecimalValue1(new LinkedList(new int[]{1, 0, 0, 0, 1, 0}).root));

    }
}
