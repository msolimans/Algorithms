package com.leetcode;

//e_724_FindPivotIndex 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers nums, write a method that returns the "pivot" index of this array.
//
//We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
//
//If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
//
//Example 1:
//
//Input:
//nums = [1, 7, 3, 6, 5, 6]
//Output: 3
//Explanation:
//The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
//Also, 3 is the first index where this occurs.
//
//
//Example 2:
//
//Input:
//nums = [1, 2, 3]
//Output: -1
//Explanation:
//There is no index that satisfies the conditions in the problem statement.
//
//
//Note:
//
//The length of nums will be in the range [0, 10000].
//Each element nums[i] will be an integer in the range [-1000, 1000].
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/find-pivot-index/
//******************************************************************************************************************

public class e_724_FindPivotIndex {


    public static void main(String[] args) {


    }


    public int pivotIndex(int[] nums) {


        if (nums == null || nums.length == 0)
            return -1;

        //left and right sum
        int right = 0, left = 0;
        //loop thru starting from index "1", second elem, to add all elems to the right var
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }

        //where all elems to the right equals zero and left is actually zero, so we return zero index in this case
        if (right == 0)
            return 0;

        //Loop thru starting from second index
        //Everytime add previous elem to left and remove current elem from right then compare
        for (int i = 1; i < nums.length ; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }

        //not found
        return -1;

    }


    @Test
    public void TestPivotIndex() {
        Assert.assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
        Assert.assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        Assert.assertEquals(0, pivotIndex(new int[]{1}));
        Assert.assertEquals(0, pivotIndex(new int[]{0,0}));
        Assert.assertEquals(0, pivotIndex(new int[]{0}));
        Assert.assertEquals(-1, pivotIndex(new int[]{}));
        Assert.assertEquals(-1, pivotIndex(new int[]{1, 2}));
        Assert.assertEquals(1, pivotIndex(new int[]{1, 2, 1}));
        Assert.assertEquals(0, pivotIndex(new int[]{-1,-1,-1,0,1,1}));
        Assert.assertEquals(5, pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}
