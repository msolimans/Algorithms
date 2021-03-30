package com.leetcode;

//e_896_MonotonicArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//An array is monotonic if it is either monotone increasing or monotone decreasing.
//
//An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
//
//Return true if and only if the given array A is monotonic.
//
//
//
//Example 1:
//
//Input: [1,2,2,3]
//Output: true
//Example 2:
//
//Input: [6,5,4,4]
//Output: true
//Example 3:
//
//Input: [1,3,2]
//Output: false
//Example 4:
//
//Input: [1,2,4,5]
//Output: true
//Example 5:
//
//Input: [1,1,1]
//Output: true
//
//
//Note:
//
//1 <= A.length <= 50000
//-100000 <= A[i] <= 100000

//******************************************************************************************************************
//Companies: Facebook | 13
//******************************************************************************************************************
//Link: https://leetcode.com/problems/monotonic-array/
//******************************************************************************************************************

public class e_896_MonotonicArray {


    public static void main(String[] args) {

        System.out.println(new e_896_MonotonicArray().isMonotonic(new int[]{1, 2, 4}));


    }

    public boolean isMonotonic(int[] A) {
        if (A.length <= 2)
            return true;

        int i = 1;
        boolean incrs = false;
        boolean decrs = false;

        //increase i as long as we have next elm greater than current elem
        while (i < A.length && A[i - 1] <= A[i]) {
            //it should be in increasing order from now on
            if (A[i - 1] < A[i])
                incrs = true;
            i++;
        }

        //move i to next index as long as elem less than current elem
        while (i < A.length && A[i - 1] >= A[i]) {
            //it should be in decreasing order from now on
            if (A[i - 1] > A[i])
                decrs = true;
            i++;
        }

        //if both incr and decrs are true, return false
        if (incrs && decrs)
            return false;

        //make sure we processed all elems in array
        return i == A.length;
    }


    @Test
    public void TestIsMontonic() {
        Assert.assertTrue(isMonotonic(new int[]{1, 1, 0}));
        Assert.assertTrue(isMonotonic(new int[]{1, 2, 2, 3}));
        Assert.assertTrue(isMonotonic(new int[]{6, 5, 4, 4}));
        Assert.assertFalse(isMonotonic(new int[]{1, 3, 2}));
        Assert.assertFalse(isMonotonic(new int[]{1, 3, 2, 2, 1}));
        Assert.assertTrue(isMonotonic(new int[]{1, 2, 4, 5}));
        Assert.assertTrue(isMonotonic(new int[]{1, 1, 1}));
    }

}
