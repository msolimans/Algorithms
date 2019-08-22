package com.leetcode;

//e_1018_BinaryPrefixDivisibleBy5 
//Show Topic Tags

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
//
//Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
//
//Example 1:
//
//Input: [0,1,1]
//Output: [true,false,false]
//Explanation:
//The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
//Example 2:
//
//Input: [1,1,1]
//Output: [false,false,false]
//Example 3:
//
//Input: [0,1,1,1,1,1]
//Output: [true,false,false,false,true,false]
//Example 4:
//
//Input: [1,1,1,0,1]
//Output: [false,false,false,false,false]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-prefix-divisible-by-5/
//******************************************************************************************************************

public class e_1018_BinaryPrefixDivisibleBy5 {


    public static void main(String[] args) {
        System.out.println(new e_1018_BinaryPrefixDivisibleBy5().prefixesDivBy5(new int[]{0, 1, 1}));

    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null && A.length == 0) {
            return Collections.emptyList();
        }
        int num = 0;
        List<Boolean> list = new LinkedList<>();
        for (int i = 0; i <  A.length; i++) {
            //left-shift 1 bit then add current element in A (using bitwise OR)
            //example:
            //0,1,1
            //0 << 1 | 0 = 0 (which is 0)
            //0 << 1 = 0 | 1 = 1 (which is 01)
            //1 << 1 = 10 | 1 = 11 (which is 011)
            //we also added %5 operation to the equation to get the final result
            num = ((num << 1) | A[i]) % 5;
            //same formula can be in standard math equation like below
            //num = (num*2 + A[i])%5;
            list.add(num == 0);
        }
        return list;
    }


    @Test
    public void TestprefixesDivBy5() {


        Assert.assertEquals(new ArrayList<>(Arrays.asList(true, false, false)), prefixesDivBy5(new int[]{0, 1, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(false, false, false)), prefixesDivBy5(new int[]{1, 1, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(true, false, false, false, true, false)), prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(false, false, false, false, false)), prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, false)), prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false)), prefixesDivBy5(new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(false, false, true, false, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, true, false, false, true, true, true, true, true, true, true, false, false, true, false, false, false, false, true, true)), prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}));
    }


}
