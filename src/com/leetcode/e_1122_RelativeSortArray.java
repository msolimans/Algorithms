package com.leetcode;

//e_1122_RelativeSortArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
//Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
//
//
//
//Example 1:
//
//Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//
//Constraints:
//
//arr1.length, arr2.length <= 1000
//0 <= arr1[i], arr2[i] <= 1000
//Each arr2[i] is distinct.
//Each arr2[i] is in arr1.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/relative-sort-array/
//******************************************************************************************************************

public class e_1122_RelativeSortArray {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_1122_RelativeSortArray().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //we preserve `counts` for all elems in arr1 [by index]
        //length based on the 2nd node/assumption `0 <= arr1[i], arr2[i] <= 1000`
        int[] counts = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i]] += 1;
        }

        //keep track of current index inside arr1
        int indx1 = 0;

        for (int i = 0; i < arr2.length; i++) {
            int indx2 = arr2[i];
            //as long as each arr2[i] is in arr1, no need for check `if counts[indx2] > 0`
            while (--counts[indx2] >= 0) {
                //adding `indx2` to arr1 [counts times]
                arr1[indx1++] = indx2;
            }

        }

        //add all other remaining elems to arr1 as a result  [in ascending order]
        for (int i = 0; i <= 1000; i++) {
            //if we had occurrence of `i`
            if (counts[i] > 0) {
                //add all of them in arr1 as a result
                while (--counts[i] >= 0) {
                    arr1[indx1++] = i;
                }
            }
        }


        //return arr1
        return arr1;
    }

    @Test
    public void TestRelativeSortArray() {
        Assert.assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
        Assert.assertArrayEquals(new int[]{1, 2, 2, 2, 3, 3, 4, 6, 7, 9, 19}, relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{}));
        Assert.assertArrayEquals(new int[]{19, 1, 2, 2, 2, 3, 3, 4, 6, 7, 9}, relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{19}));
    }
}
