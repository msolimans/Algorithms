package com.leetcode;

//e_1281_SubtracttheProductandSumofDigitsofanInteger 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an integer number n, return the difference between the product of its digits and the sum of its digits.
//
//
//Example 1:
//
//Input: n = 234
//Output: 15
//Explanation:
//Product of digits = 2 * 3 * 4 = 24
//Sum of digits = 2 + 3 + 4 = 9
//Result = 24 - 9 = 15
//Example 2:
//
//Input: n = 4421
//Output: 21
//Explanation:
//Product of digits = 4 * 4 * 2 * 1 = 32
//Sum of digits = 4 + 4 + 2 + 1 = 11
//Result = 32 - 11 = 21
//
//
//Constraints:
//
//1 <= n <= 10^5
//******************************************************************************************************************
//Companies: Quora
//******************************************************************************************************************
//Link: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
//******************************************************************************************************************

public class e_1281_SubtracttheProductandSumofDigitsofanInteger {


    public int subtractProductAndSum(int n) {

        return subtractProductAndSum(n, 1, 0);

    }

    public int subtractProductAndSum(int n, int m, int a) {
        //base case: if we are done, subtract [multiply result - add result]
        if (n == 0)
            return m - a;

        //right most number
        int i = n % 10;

        //recrusively call
        return subtractProductAndSum(n / 10, m * i, a + i);

    }


    @Test
    public void TestsubtractProductAndSum() {
        Assert.assertEquals(0, subtractProductAndSum(1));
        Assert.assertEquals(15, subtractProductAndSum(234));
        Assert.assertEquals(21, subtractProductAndSum(4421));
        Assert.assertEquals(59004, subtractProductAndSum(99999));

    }

}
