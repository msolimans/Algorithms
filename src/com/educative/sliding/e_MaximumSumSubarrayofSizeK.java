package com.educative.sliding;

//e_MaximumSumSubarrayofSizeK

/*Description*/
//******************************************************************************************************************
//Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
//
//        Example 1:
//
//        Input: [2, 1, 5, 1, 3, 2], k=3
//        Output: 9
//        Explanation: Subarray with maximum sum is [5, 1, 3].
//        Example 2:
//
//        Input: [2, 3, 4, 1, 5], k=2
//        Output: 7
//        Explanation: Subarray with maximum sum is [3, 4].
//******************************************************************************************************************
//Link: https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
//******************************************************************************************************************


import org.junit.Assert;
import org.junit.Test;

public class e_MaximumSumSubarrayofSizeK {
    public static void main(String[] args) {
        System.out.println(new e_MaximumSumSubarrayofSizeK().max(new int[]{2, 1, 5, 1, 3, 2}, 3));
        System.out.println(new e_MaximumSumSubarrayofSizeK().max(new int[]{2, 3, 4, 1, 5}, 2));
    }

    //O(n)
    int max(int[] nums, int k) {

        int s = 0;
        int e = 0;
        int sum = 0;

        //3 = 0 1 2 = 2 - 0 => 2
        while (e - s < k)
            sum += nums[e++];

        int result = sum;

        while (e < nums.length) {
            sum += nums[e];
            sum -= nums[s];
            if (sum > result)
                result = sum;
            s++;
            e++;
        }

        return result;
    }


    @Test
    public void TestIsPalindrome() {
        Assert.assertEquals(9, max(new int[]{2, 1, 5, 1, 3, 2}, 3));
        Assert.assertEquals(7, max(new int[]{2, 3, 4, 1, 5}, 2));
    }

}
