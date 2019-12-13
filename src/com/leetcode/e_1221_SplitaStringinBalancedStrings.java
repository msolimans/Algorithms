package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

//e_1221_SplitaStringinBalancedStrings 
//Show Topic Tags

/**
 * Stack
 */

/*Description*/
//******************************************************************************************************************
//Balanced strings are those who have equal quantity of 'L' and 'R' characters.
//
//Given a balanced string s split it in the maximum amount of balanced strings.
//
//Return the maximum amount of splitted balanced strings.
//
//
//
//Example 1:
//
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
//Example 2:
//
//Input: s = "RLLLLRRRLR"
//Output: 3
//Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
//Example 3:
//
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
//Example 4:
//
//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s[i] = 'L' or 'R'
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_1221_SplitaStringinBalancedStrings {


    //Using Stack 10% Faster
    //push character to the stack as long as it the same as the top character of the stack
    //if the current character is different the top of the stack, both should cancel each other so it is time to pop the last/top elem from the stack
    //at any point we encounter the stack being empty, increase count
    //by the end count should have the result
    public int balancedStringSplit1(String s) {
        Stack<Character> hist = new Stack<>();

        hist.add(s.charAt(0));

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'L' && hist.size() > 0 && hist.peek() == 'R')
                hist.pop();
            else if (s.charAt(i) == 'R' && hist.size() > 0 && hist.peek() == 'L')
                hist.pop();
            else
                hist.add(s.charAt(i));

            if (hist.size() == 0)
                count++;
        }


        return count;
    }

    //Enhanced, no need for extra space 100% Faster
    //Exactly the same concept as the above but with using sums
    //anytime we encounter L, add 1 to csum
    //anytime we encounter R, subtract 1 from csum
    //at any time we see csum equals ZERO, increment count by 1
    //at the end we should have count as a result
    public int balancedStringSplit(String s) {
        int count = 0;
        int csum = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'L')
                csum += 1;
            else
                csum -= 1;

            if(csum == 0)
                count++;
        }

        return count;

    }


    @Test
    public void Teste_1221_SplitaStringinBalancedStrings() {
        Assert.assertEquals(1, balancedStringSplit("RL"));
        Assert.assertEquals(1, balancedStringSplit("LR"));
        Assert.assertEquals(3, balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, balancedStringSplit("LLLLRRRR"));
        Assert.assertEquals(2, balancedStringSplit("RLRRRLLRLL"));



        Assert.assertEquals(1, balancedStringSplit1("RL"));
        Assert.assertEquals(1, balancedStringSplit1("LR"));
        Assert.assertEquals(3, balancedStringSplit1("RLLLLRRRLR"));
        Assert.assertEquals(1, balancedStringSplit1("LLLLRRRR"));
        Assert.assertEquals(2, balancedStringSplit1("RLRRRLLRLL"));
    }


}
