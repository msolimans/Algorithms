package com.leetcode;

//e_371_SumofTwoIntegers 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//Example 1:
//
//Input: a = 1, b = 2
//Output: 3
//Example 2:
//
//Input: a = -2, b = 3
//Output: 1

//******************************************************************************************************************
//Companies: Adobe, Facebook, Hulu
//******************************************************************************************************************
//Link: https://leetcode.com/problems/sum-of-two-integers/
//******************************************************************************************************************

public class e_371_SumofTwoIntegers {


    public static void main(String[] args) {

        System.out.println(new e_371_SumofTwoIntegers().getSum(2, 3));
    }

    public int getSum(int a, int b) {

        //XOR adds bits while AND calc carry then we shift it to continue addition [same as normal addition]
        while (b != 0) {
            //calc carry first before any change
            int carry = a & b;
            //xor a and b, store result in a
            a ^= b;
            //shift carry by one for further calcs, update b for the next loop/cycle
            b = carry << 1;
        }

        return a;
    }

    @Test
    public void TestGetSum() {
        Assert.assertEquals(5, getSum(2, 3));
        Assert.assertEquals(2, getSum(-2, 4));
    }
}
