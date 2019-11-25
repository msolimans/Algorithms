package com.leetcode;

//e_674_LongestContinuousIncreasingSubsequence 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
//
//Example 1:
//Input: [1,3,5,4,7]
//Output: 3
//Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
//Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
//Example 2:
//Input: [2,2,2,2,2]
//Output: 1
//Explanation: The longest continuous increasing subsequence is [2], its length is 1.
//Note: Length of the array will not exceed 10,000.
//******************************************************************************************************************
//Companies: Facebook | 7
//******************************************************************************************************************
//Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
//******************************************************************************************************************

public class e_674_LongestContinuousIncreasingSubsequence {


    public static void main(String[] args) {

        System.out.println(new e_674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{7, 7, 8, 9, 10}));
    }

    //every time we encounter increasing number, increment lmax by 1 otherwise reset it to 1
    //compare max with lmax and make sure max is always the greatest before we return
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = 1;
        int lmax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                lmax++;
            else {
                if (lmax > max)
                    max = lmax;
                lmax = 1;
            }
        }

        //make sure we update max here bcs we mightn't have encountered `else` case all of elems were in increasing order
        if (lmax > max)
            max = lmax;

        return max;
    }


    @Test
    public void TestFindLengthOfLCIS() {
        Assert.assertEquals(3, findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        Assert.assertEquals(1, findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        Assert.assertEquals(1, findLengthOfLCIS(new int[]{4, 3, 2, 1}));
        Assert.assertEquals(0, findLengthOfLCIS(new int[]{}));
        Assert.assertEquals(5, findLengthOfLCIS(new int[]{8, 9, 0, 3, 2, 1, 0, -3, -4, 0, 1, 2, 10}));
    }
}
