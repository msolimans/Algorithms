package com.leetcode;

//1550. Three Consecutive Odds

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
/*Description*/
//******************************************************************************************************************
//Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
//
//
//        Example 1:
//
//        Input: arr = [2,6,4,1]
//        Output: false
//        Explanation: There are no three consecutive odds.
//        Example 2:
//
//        Input: arr = [1,2,34,3,4,5,7,23,12]
//        Output: true
//        Explanation: [5,7,23] are three consecutive odds.
//
//
//        Constraints:
//
//        1 <= arr.length <= 1000
//        1 <= arr[i] <= 1000

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/three-consecutive-odds/
//******************************************************************************************************************


public class e_1550_ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        for (int a :
                arr) {
            if (a % 2 > 0)
                i++;
            else
                i = 0;

            if (i >= 3)
                return true;
        }

        return false;
    }

    @Test
    public void TestThreeConsecutiveOdds() {
        Assert.assertFalse(threeConsecutiveOdds(new int[]{1}));
        Assert.assertFalse(threeConsecutiveOdds(new int[]{1,3}));
        Assert.assertFalse(threeConsecutiveOdds(new int[]{2,6,4,1}));
        Assert.assertTrue(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

}
