package com.leetcode;

//e_1005_MaximizeSumOfArrayAfterKNegations 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Greedy
 */

/*Description*/
//******************************************************************************************************************

//Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
//
//Return the largest possible sum of the array after modifying it in this way.
//
//
//
//Example 1:
//
//Input: A = [4,2,3], K = 1
//Output: 5
//Explanation: Choose indices (1,) and A becomes [4,-2,3].
//Example 2:
//
//Input: A = [3,-1,0,2], K = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
//Example 3:
//
//Input: A = [2,-3,-1,5,-4], K = 2
//Output: 13
//Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
//
//
//Note:
//
//1 <= A.length <= 10000
//1 <= K <= 10000
//-100 <= A[i] <= 100
//******************************************************************************************************************
//Companies: Google, druva
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
//******************************************************************************************************************

public class e_1005_MaximizeSumOfArrayAfterKNegations {


    public static void main(String[] args) {

        System.out.println(new e_1005_MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3},1));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        while (K > 0) {
            if (A[i] < 0) {
                //this will validate the last test case
                if(i<= A.length - 2 && A[i+1] > 0 && A[i+1] > -A[i] && ((K & 0x1) == 0)){
                    K = 0;
                    continue;
                }

                A[i] = -A[i];
                i++;
                K--;
            } else if (A[i] == 0) {
                //make K zero as long as A[i]=0 and it won't make any effect to multiply it with -1
                K = 0;
            } else {
                //number of K left is even, elem at index i will be the same
                //in case if it is odd, negate A[i]
                if ((K & 0x1) != 0) {//odd
                    //check previous one [if this one is greater, use it]
                    A[i] = -A[i];
                }
                K = 0;
            }
        }

        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        return sum;

    }

    @Test
    public void TestLargestSumAfterKNegations() {
        Assert.assertEquals(5, largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        Assert.assertEquals(6, largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        Assert.assertEquals(13, largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        Assert.assertEquals(6, largestSumAfterKNegations(new int[]{6, 0}, 2));
        Assert.assertEquals(22, largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
    }
}
