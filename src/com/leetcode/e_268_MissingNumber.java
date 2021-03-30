package com.leetcode;

//e_268_MissingNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//Example 1:
//
//Input: [3,0,1]
//Output: 2
//Example 2:
//
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
//******************************************************************************************************************
//Companies: Microsoft | 5  Amazon | 3  Apple | 3  Google | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/missing-number/
//******************************************************************************************************************

public class e_268_MissingNumber {


    public static void main(String[] args) {


    }


    public int missingNumber(int[] nums) {

        //Gauss' formula
        //Summation formula [0 .. n] = n * (n+1) / 2
        int expected = nums.length * (nums.length + 1) / 2;
        int actual = 0;
        for (int i : nums) {
            actual += i;
        }

        return expected - actual;
    }


    //Bit Manipulation
    //XOR number with itself results in 0
    //we know each elem should be at its index other than that missing elem
    //but we also know number "n" itself is not there in the array so we add index=n
    public int missingNumber2(int[] nums) {
        //nums.length is considered the index n
        int res = nums.length;

        //loop thru and xor with index and value
        //because we xored all indexes that means from 0....n-1 are all in there
        //moreover we adding all elems in the array [missing will come out as it doesn't have a match with the indexes]
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }

        return res;
    }


    @Test
    public void TestMissingNumber() {
        Assert.assertEquals(4, missingNumber(new int[]{1, 9, 2, 3, 8, 6, 5, 7, 0}));
        Assert.assertEquals(0, missingNumber(new int[]{1, 9, 2, 3, 8, 4, 6, 5, 7}));

        Assert.assertEquals(4, missingNumber2(new int[]{1, 9, 2, 3, 8, 6, 5, 7, 0}));
        Assert.assertEquals(0, missingNumber2(new int[]{1, 9, 2, 3, 8, 4, 6, 5, 7}));
    }

}
