package com.leetcode;

//e_53_MaximumSubarray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//Example:
//
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//Follow up:
//
//If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-subarray/
//******************************************************************************************************************

public class e_53_MaximumSubarray {


    public static void main(String[] args) {
        System.out.println(new e_53_MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1}));
    }

    public int maxSubArray(int[] nums) {


        //Kadane's Algorthms
        //max of current index is the either the current element or the max of previous elem + current element

        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > globalMax) {
                globalMax = nums[i];
            }
        }

        return globalMax;
    }

    public int maxSubArray2(int[] nums) {


        //Kadane's Algorthms
        //max of current index is the either the current element or the max of previous elem + current element
        //max of contiguous array vs global max of any previous contiguous array

        int lmax = nums[0], gmax = nums[0];
        for(int i =1;i<nums.length;i++) {
            lmax = Math.max(nums[i], nums[i] + lmax);
            if(lmax > gmax)
                gmax = lmax;
        }

        return gmax;
    }


    @Test
    public void TestMaxSubArray() {
        Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(6, maxSubArray(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}));

        Assert.assertEquals(6, maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(6, maxSubArray2(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}));




    }
}
