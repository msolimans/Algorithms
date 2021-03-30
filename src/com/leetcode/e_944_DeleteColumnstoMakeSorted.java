package com.leetcode;

//e_944_DeleteColumnstoMakeSorted 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 * Array, Mask, Pointer
 */

/*Description*/
//******************************************************************************************************************
//We are given an array A of N lowercase letter strings, all of the same length.
//
//Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
//
//For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
//
//Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.
//
//Return the minimum possible value of D.length.
//
//
//
//Example 1:
//
//Input: ["cba","daf","ghi"]
//Output: 1
//Explanation:
//After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
//If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
//Example 2:
//
//Input: ["a","b"]
//Output: 0
//Explanation: D = {}
//Example 3:
//
//Input: ["zyx","wvu","tsr"]
//Output: 3
//Explanation: D = {0, 1, 2}
//
//
//Note:
//
//1 <= A.length <= 100
//1 <= A[i].length <= 1000

//******************************************************************************************************************
//Companies: Google
//******************************************************************************************************************
//Link: https://leetcode.com/problems/delete-columns-to-make-sorted/
//******************************************************************************************************************

public class e_944_DeleteColumnstoMakeSorted {


    //O(n) Solution with const space
    public int minDeletionSize(String[] A) {

        if (A == null || A.length == 0 || A.length == 1) {
            return 0;
        }

        //mask used to mark invalid indexes [using 1s]
        int[] mask = new int[1001];

        //loop through strings
        for (int i = 1; i < A.length; i++) {
            //loop thru each char n string
            mask(A[i - 1], A[i], mask);
        }

        //count invalid ones
        int result = 0;
        for (int i : mask) {
            if (i > 0)
                result++;
        }

        return result;
    }

    void mask(String str1, String str2, int[] mask) {

        //one pointer in to use to walk through str1 and str2
        int i = 0;
        while (i < str1.length()) {
            //if it is one, it  was broken before and no need to continue
            if (mask[i] == 1) {
                i++;
                continue;
            }

            //if str2's current index is greater than str1's current index, mark it as invalid
            if (str2.charAt(i) < str1.charAt(i))
                mask[i] = 1;

            i++;
        }

    }

    @Test
    public void TestMinDeletionSize() {
        Assert.assertEquals(1, minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        Assert.assertEquals(0, minDeletionSize(new String[]{"abc"}));
        Assert.assertEquals(0, minDeletionSize(new String[]{"a", "b"}));
        Assert.assertEquals(3, minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
