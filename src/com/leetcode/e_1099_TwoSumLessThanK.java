package com.leetcode;

//e_1099_TwoSumLessThanK 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K.
// If no i, j exist satisfying this equation, return -1.
//
//
//
//Example 1:
//
//Input: A = [34,23,1,24,75,33,54,8], K = 60
//Output: 58
//Explanation:
//We can use 34 and 24 to sum 58 which is less than 60.
//Example 2:
//
//Input: A = [10,20,30], K = 15
//Output: -1
//Explanation:
//In this case it's not possible to get a pair sum less that 15.
//
//
//Note:
//
//1 <= A.length <= 100
//1 <= A[i] <= 1000
//1 <= K <= 2000

//******************************************************************************************************************
//Companies: Amazon | 14 Google | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/two-sum-less-than-k/
//******************************************************************************************************************

public class e_1099_TwoSumLessThanK {


    public static void main(String[] args) {
        System.out.println(new e_1099_TwoSumLessThanK().twoSumLessThanK(new int[]{2, 10, 3, 2, 8, 0, 30}, 60));
    }

    public int twoSumLessThanK(int[] A, int K) {
        //we know if its length is 1, we can't form 2 numbers so we return -1
        if (A.length <= 1) {
            return -1;
        }

        //sort array
        Arrays.sort(A);

        //2 points to keep track of positions
        int s = 0, e = A.length - 1;
        int max = Integer.MIN_VALUE;
        while (s < e) {
            //if it is greater than or equal to K, just move end point to left
            if (A[s] + A[e] >= K) {
                e--;
            } else {
                //less than k
                // 1) compare sum of current elems with max and update it if current combination is greater than max
                // 2) move s to right to check other combinations
                if (A[s] + A[e] > max)
                    max = A[s] + A[e];
                s++;
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }

    @Test
    public void TestTwoSumLessThanK() {
        Assert.assertEquals(58, twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
        Assert.assertEquals(198, twoSumLessThanK(new int[]{254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178, 839, 201, 386, 462, 45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865, 468, 1, 838, 275, 370, 295, 574, 309, 268, 415, 385, 786, 62, 359, 78, 854, 944}, 200));

    }

}
