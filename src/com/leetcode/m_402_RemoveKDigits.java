package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//m_402_RemoveKDigits 
//Show Topic Tags

/**
 * Stack, Greedy
 */

/*Description*/
//******************************************************************************************************************
//Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
//
//Note:
//The length of num is less than 10002 and will be ≥ k.
//The given num does not contain any leading zero.
//Example 1:
//
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//Example 2:
//
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//Example 3:
//
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing which is 0.
//******************************************************************************************************************
//Companies: Microsoft | 4  Amazon | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/remove-k-digits/
//******************************************************************************************************************

public class m_402_RemoveKDigits {


    public String removeKdigits(String num, int k) {

        //if k is greater than or equal to len, return 0
        if (k >= num.length())
            return "0";


        Deque<Character> deque = new LinkedList<>();
        //add first digit or char to deque
        deque.add(num.charAt(0));

        //loop through chars and make sure we only add numbers in asc order //e.g. 12345 better than and always less than 54321
        //425 => 4 (peek) > 2 => pop 4 and add 2
        //452 => 4->5 (peek) [greater than] 2 => pop all elems from deque that are greater than 2 [greedy] in this example 4 and 5 then add 2
        for (int i = 1; i < num.length(); i++) {

            //pop all elems that are greater than current elem from deque
            while (deque.size() > 0 && k > 0 && deque.peekLast() > num.charAt(i)) {
                deque.pollLast();
                k--;
            }

            //add elem to the top of the deque
            deque.addLast(num.charAt(i));
        }

        //pop from right-most side, always big numbers will go out in this case
        while (k > 0 && deque.size() > 0) {
            deque.pollLast();
            k--;
        }

        //remove all zeros from left side
        while (deque.size() > 0 && deque.peekFirst() == '0')
            deque.pollFirst();


        // build the final string, while removing the leading zeros.
        StringBuilder sb = new StringBuilder();


        //if deque size equals zero, return 0
        if (deque.size() == 0)
            return "0";

        //extract result
        while (deque.size() > 0) {
            //poll from first to make sure we get rid of unnecessary zeros in the left side of string [result]
            char digit = deque.pollFirst();
            sb.append(digit);
        }

        //if we ended up by zero length result string, we should return 0
        if (sb.length() == 0) return "0";

        //return final res
        return sb.toString();

    }


    @Test
    public void Testm_402_RemoveKDigits() {
        Assert.assertEquals("1219", removeKdigits("1432219", 3));
        Assert.assertEquals("0", removeKdigits("10200", 2));
        Assert.assertEquals("0", removeKdigits("10", 2));
        Assert.assertEquals("1", removeKdigits("11001", 2));
        Assert.assertEquals("1", removeKdigits("101", 1));
        Assert.assertEquals("11", removeKdigits("1011", 1));
        Assert.assertEquals("1", removeKdigits("1011", 2));
        Assert.assertEquals("1", removeKdigits("10101", 2));
        Assert.assertEquals("1", removeKdigits("101001", 2));
        Assert.assertEquals("8898", removeKdigits("989898", 2));
        Assert.assertEquals("0", removeKdigits("89", 2));
        Assert.assertEquals("0", removeKdigits("899", 3));
        Assert.assertEquals("1", removeKdigits("8991", 3));
        Assert.assertEquals("0", removeKdigits("909", 3));
        ///
        Assert.assertEquals("11", removeKdigits("112", 1));
        Assert.assertEquals("1224", removeKdigits("12345264", 4));

    }
}
