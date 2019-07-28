package com.leetcode;

//e_1137_NthTribonnacciNumber


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
//Show Topic Tags

/**
 * Dynamic Programming
 */

/*Description*/
//******************************************************************************************************************
//1137. N-th Tribonacci Number
//User Accepted: 2627
//User Tried: 2702
//Total Accepted: 2670
//Total Submissions: 4099
//Difficulty: Easy
//The Tribonacci sequence Tn is defined as follows:
//
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//Given n, return the value of Tn.
//
//
//
//Example 1:
//
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//Example 2:
//
//Input: n = 25
//Output: 1389537
//
//
//Constraints:
//
//0 <= n <= 37
//The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/contest/weekly-contest-147/problems/n-th-tribonacci-number/
//******************************************************************************************************************

public class e_1137_NthTribonnacciNumber {


    public static void main(String[] args) {
        System.out.println(new e_1137_NthTribonnacciNumber().tribonacci(4));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        map.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return map.get(n);
    }

    @Test
    public void TestTribonnacci() {
        Assert.assertEquals(4, tribonacci(4));
        Assert.assertEquals(1389537, tribonacci(25));
        Assert.assertEquals(2082876103, tribonacci(37));
    }

}
