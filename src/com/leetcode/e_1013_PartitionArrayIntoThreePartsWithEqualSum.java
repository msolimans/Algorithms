package com.leetcode;

//e_1013_PartitionArrayIntoThreePartsWithEqualSum 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
//
//Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
//
//
//
//Example 1:
//
//Input: [0,2,1,-6,6,-7,9,1,2,0,1]
//Output: true
//Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//Example 2:
//
//Input: [0,2,1,-6,6,7,9,-1,2,0,1]
//Output: false
//Example 3:
//
//Input: [3,3,6,5,-2,2,5,1,-9,4]
//Output: true
//Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//Note:
//
//3 <= A.length <= 50000
//-10000 <= A[i] <= 10000

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
//******************************************************************************************************************

public class e_1013_PartitionArrayIntoThreePartsWithEqualSum {


    public static void main(String[] args) {


    }

    //O(n)
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        //sum of all elems in the array
        for (int i : A) {
            sum += i;
        }

        //check if it's divisible by 3
        if (sum % 3 > 0) {
            return false;
        }

        //each part should be stored in subSum
        int subSum = sum / 3;
        //we reserve how many subarrays we have in the array whose sum equals subSum
        int count = 0;
        //current sum for each subArray
        int currentSubSum = 0;
        //loop thru and sum elems until we reach subSum then increment count
        for (int i : A) {
            currentSubSum += i;
            if (currentSubSum == subSum) {
                count++;
                currentSubSum = 0;
            }
        }

        //return if current equals 3
        return count == 3;
    }

    @Test
    public void TestcanThreePartsEqualSum() {
        Assert.assertTrue(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        Assert.assertTrue(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        Assert.assertFalse(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }


    //O(n^2) however it gave me TimeLimitExceeded in Leetcode bcs of very large test cases
    public boolean canThreePartsEqualSum2(int[] A) {

        int index1 = 0;
        int sum1 = 0;

        while (index1 <= A.length - 3) {
            //sum of the first part
            sum1 += A[index1];
            int index3 = A.length - 1;
            int sum3 = 0;
            //sum for third part, at least leave one space for second part that's why it is index1+1 in while
            while (index3 > index1 + 1) {
                sum3 += A[index3];
                //if both are equals, just check the second part here
                if (sum1 == sum3) {
                    int sum2 = calcPart(A, index1 + 1, index3 - 1);
                    if (sum1 == sum2) {
                        return true;
                    }

                }
                index3--;
            }

            index1++;
        }

        return false;
    }


    int calcPart(int[] A, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += A[i];
        }

        return sum;
    }


    @Test
    public void TestcanThreePartsEqualSum2() {
        Assert.assertTrue(canThreePartsEqualSum2(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        Assert.assertTrue(canThreePartsEqualSum2(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        Assert.assertFalse(canThreePartsEqualSum2(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }

}
