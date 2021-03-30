package com.leetcode;

//e_643_MaximumAverageSubarrayI 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
//
//Example 1:
//
//Input: [1,12,-5,-6,50,3], k = 4
//Output: 12.75
//Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//
//
//Note:
//
//1 <= k <= n <= 30,000.
//Elements of the given array will be in the range [-10,000, 10,000].

//******************************************************************************************************************
//Companies: Google
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-average-subarray-i/
//******************************************************************************************************************

public class e_643_MaximumAverageSubarrayI {


    public static void main(String[] args) {
        System.out.println(new e_643_MaximumAverageSubarrayI().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 2));

    }

    //one for loop
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE, sum = 0;
        //loop thru
        for (int i = 0; i < nums.length; i++) {
            //update sum .. we passed k elems
            if (i + 1 <= k)
                sum += nums[i];
                //we finished k elems
            else {
                sum -= nums[i - k];
                sum += nums[i];
            }

            //make sure we start recording max after we finish k elems in nums
            if ((i + 1) - k >= 0 && sum > max)
                max = sum;
        }

        return max / k;
    }

    //easier to understand
    public double findMaxAverage2(int[] nums, int k) {

        double sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        //update res
        double res = sum;

        //move from k to end
        for (int i = k; i < nums.length; i++) {
            //update sum [remove first elem at i - k and add last elem at i]
            sum += nums[i] - nums[i - k];
            //update res with the max
            res = Math.max(res, sum);
        }

        //return average
        return res / k;
    }


    @Test
    public void TestFindMaxAverage() {
        Assert.assertEquals(-1.0, findMaxAverage(new int[]{-1}, 1), 1);
        Assert.assertEquals(12.75, findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 2);
        Assert.assertEquals(26.50, findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 2), 2);
        Assert.assertEquals(26.50, findMaxAverage2(new int[]{1, 12, -5, -6, 50, 3}, 2), 2);
    }

}
