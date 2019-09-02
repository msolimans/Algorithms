package com.leetcode;

//e_852_PeakIndexInaMountainArray
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Let's call an array A a mountain if the following properties hold:
//
//A.length >= 3
//There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
//
//Example 1:
//
//Input: [0,1,0]
//Output: 1
//Example 2:
//
//Input: [0,2,1,0]
//Output: 1
//Note:
//
//3 <= A.length <= 10000
//0 <= A[i] <= 10^6
//A is a mountain, as defined above.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
//******************************************************************************************************************

public class e_852_PeakIndexInaMountainArray {


    public static void main(String[] args) {


    }

    //every node to the left should be less than the peak elem and every elem to the right should be greater than it
    //loop thru and compare, every time we get a bigger elem, update result with current index otherwise continue
    //only break once we reach an elem that's less than prev elem
    //remember the duplicates, it was not explicitly mentioned that they need the least index in case of duplicates
    //e.g. 1,2,2,1 => this should result in 1 [which is is the least index of elem 2]
    public int peakIndexInMountainArray(int[] A) {


        int prev = A[0], i = 1, result = 0;

        while (i < A.length) {
            //current elem is greater than previous, update "result", "prev" and continue
            if (A[i] > prev) {
                result = i;
                prev = A[i];
            }

            //current elem is less than previous, break and then return the result
            else if (A[i] < prev)
                break;

            //In case if both equal, don't update anything other than index "i"
            i++;
        }

        //we finished all array elems, just return the result
        return result;
    }

    @Test
    public void TestPeakIndexInMountainArray() {
        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0, 1, 0}));
        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        Assert.assertEquals(0, peakIndexInMountainArray(new int[]{0}));
        Assert.assertEquals(0, peakIndexInMountainArray(new int[]{1,1,1}));
        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{1, 2, 3}));
        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{1, 2, 3, 3}));
        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{2, 2, 3}));
    }
}
