package com.leetcode;

//e_1133_LargestUniqueNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers A, return the largest integer that only occurs once.
//
//If no integer occurs once, return -1.
//
//
//
//Example 1:
//
//Input: [5,7,3,9,4,9,8,3,1]
//Output: 8
//Explanation:
//The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
//Example 2:
//
//Input: [9,9,8,8]
//Output: -1
//Explanation:
//There is no number that occurs only once.
//
//
//Note:
//
//1 <= A.length <= 2000
//0 <= A[i] <= 1000

//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/problems/largest-unique-number/
//******************************************************************************************************************

public class e_1133_LargestUniqueNumber {


    public static void main(String[] args) {


    }

    //Runtime: 1 ms, faster than 81.34% of Java online submissions for Largest Unique Number.
    //Memory Usage: 38.8 MB, less than 33.33% of Java online submissions for Largest Unique Number.
    public int largestUniqueNumber(int[] A) {
        if (A.length == 1)
            return A[0];

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1 && A[i] != A[i - 1])
                return A[i];
            else if (i == 0 && A[i] != A[i + 1])
                return A[0];
            else if (i < A.length - 1 && i > 0 && A[i] != A[i + 1] && A[i] != A[i - 1])
                return A[i];
        }

        return -1;
    }

    @Test
    public void TestLargestUniqueNumber() {
        Assert.assertEquals(-2, largestUniqueNumber(new int[]{1,-2,1}));
        Assert.assertEquals(-1, largestUniqueNumber(new int[]{1,1}));
        Assert.assertEquals(1, largestUniqueNumber(new int[]{1}));
        Assert.assertEquals(8, largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));
        Assert.assertEquals(-1, largestUniqueNumber(new int[]{9, 9, 8, 8}));
        Assert.assertEquals(7, largestUniqueNumber(new int[]{9, 7, 9, 9, 8, 8}));
        Assert.assertEquals(8, largestUniqueNumber(new int[]{9, 7, 9, 9, 8}));
        Assert.assertEquals(2, largestUniqueNumber(new int[]{9, 7, 9, 9, 9, 5, 7, 2, 7, 5, 8, 8}));
    }

}
