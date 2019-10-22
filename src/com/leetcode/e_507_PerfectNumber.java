package com.leetcode;

//e_507_PerfectNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
//
//Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
//Example:
//Input: 28
//Output: True
//Explanation: 28 = 1 + 2 + 4 + 7 + 14
//Note: The input number n will not exceed 100,000,000. (1e8)

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/perfect-number/
//******************************************************************************************************************

public class e_507_PerfectNumber {


    public static void main(String[] args) {
        System.out.println(new e_507_PerfectNumber().checkPerfectNumber(10));
        System.out.println(new e_507_PerfectNumber().checkPerfectNumber(28));

    }

    public boolean checkPerfectNumber(int num) {
        //if num is zero or one
        if (num <= 1)
            return false;
        //add 1 as all numbers will be divisible by 1
        int sum = 1;
        //we start from mid [that's num/2] as nothing will be divisible after that mid until we reach to 2
        for (int i = num / 2; i > 1; i--) {
            if (num % i == 0)
                sum += i;

            //at any time, if we get sum greater than num we return false
            if (sum > num)
                return false;
        }

        //return whether we have sum equals num
        return sum == num;
    }

    @Test
    public void TestCheckPerfectNumber() {
//        Assert.assertTrue(checkPerfectNumber(28));
        Assert.assertTrue(checkPerfectNumber(1));
    }
}
