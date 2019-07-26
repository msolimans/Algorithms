package com.leetcode;

//e_263: Ugly Number
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a program to check whether a given number is an ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
//Example 1:
//
//Input: 6
//Output: true
//Explanation: 6 = 2 × 3
//Example 2:
//
//Input: 8
//Output: true
//Explanation: 8 = 2 × 2 × 2
//Example 3:
//
//Input: 14
//Output: false
//Explanation: 14 is not ugly since it includes another prime factor 7.
//Note:
//
//1 is typically treated as an ugly number.
//Input is within the 32-bit signed integer range: [−231,  231 − 1].

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_263_UglyNumber {


    public static void main(String[] args) {
        System.out.println(new e_263_UglyNumber().isUgly(0));
        System.out.println(new e_263_UglyNumber().isUgly(1));

    }

    public boolean isUgly(int num) {
        if (num < 1)
            return false;

        int result = num;

        //keep dividing the number by 2, 3 or 5 [such that remainder of division is zero]
        //if the number is not divided by any of them at any iteration return false
        while (result > 1) {
            //check if number is divisible by 2, if so update the result and continue
            if (result%2 == 0) {
                result /= 2;
            } else if(result % 3 == 0) {//is divisible by 3
                result /= 3;
            } else if (result % 5 == 0) {//is divisible by 5
                result /= 5;
            } else {//not divisble by any of them, return false
                return false;
            }

        }



        return true;
    }

    @Test
    public void TestisUgly(){
        Assert.assertEquals(false, isUgly(0));
        Assert.assertEquals(false, isUgly(-2));
        Assert.assertEquals(false, isUgly(-4));
        Assert.assertEquals(true, isUgly(4));
        Assert.assertEquals(true, isUgly(8));
        Assert.assertEquals(false, isUgly(14));
        Assert.assertEquals(true, isUgly(100));
    }



}
