package com.leetcode;

//e_509_FibonacciNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), for N > 1.
//Given N, calculate F(N).
//
//
//
//Example 1:
//
//Input: 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//Example 2:
//
//Input: 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//Example 3:
//
//Input: 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//Note:
//
//0 ≤ N ≤ 30.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/fibonacci-number/
//******************************************************************************************************************

public class e_509_FibonacciNumber {


    //More solutions can be found under MIT ocw with detailed explanation [com/ocw/c6006/lect19]
    public static void main(String[] args) {
        System.out.println(new e_509_FibonacciNumber().fib(5));
        System.out.println(new e_509_FibonacciNumber().fib2(5));
    }


    //memoized version with O(N) auxiliary space
    public int fib2(int N) {
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[N];
    }

    //optimized version with O(1) auxiliary space
    public int fib(int N) {
        if (N == 0)
            return 0;

        int prevprev = 0;
        int prev = 1;
        int result = 1;

        for (int i = 2; i <= N; i++) {
            result = prev + prevprev;
            prevprev = prev;
            prev = result;
        }

        return result;
    }


    @Test
    public void Testfib() {

        Assert.assertEquals(0, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(1, fib(2));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(3, fib(4));
        Assert.assertEquals(5, fib(5));
        Assert.assertEquals(8, fib(6));
        Assert.assertEquals(13, fib(7));
        Assert.assertEquals(21, fib(8));
        Assert.assertEquals(34, fib(9));
        Assert.assertEquals(55, fib(10));
        Assert.assertEquals(89, fib(11));
        Assert.assertEquals(144, fib(12));
        Assert.assertEquals(233, fib(13));
        Assert.assertEquals(377, fib(14));
        Assert.assertEquals(610, fib(15));
        Assert.assertEquals(987, fib(16));
        Assert.assertEquals(1597, fib(17));
        Assert.assertEquals(2584, fib(18));
        Assert.assertEquals(4181, fib(19));
        Assert.assertEquals(6765, fib(20));
        Assert.assertEquals(10946, fib(21));
        Assert.assertEquals(17711, fib(22));
        Assert.assertEquals(28657, fib(23));
        Assert.assertEquals(46368, fib(24));
        Assert.assertEquals(75025, fib(25));
        Assert.assertEquals(121393, fib(26));
        Assert.assertEquals(196418, fib(27));
        Assert.assertEquals(317811, fib(28));
        Assert.assertEquals(514229, fib(29));
        Assert.assertEquals(832040, fib(30));

    }


}
