package com.leetcode;

//e_961_NRepeatedElementInSize2NArray
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
//
//Return the element repeated N times.
//
//
//
//Example 1:
//
//Input: [1,2,3,3]
//Output: 3
//Example 2:
//
//Input: [2,1,2,5,3,2]
//Output: 2
//Example 3:
//
//Input: [5,1,5,2,5,3,5,4]
//Output: 5
//
//
//Note:
//
//4 <= A.length <= 10000
//0 <= A[i] < 10000
//A.length is even

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
//******************************************************************************************************************

public class e_961_NRepeatedElementInSize2NArray {


    public static void main(String[] args) {

        System.out.println(new e_961_NRepeatedElementInSize2NArray().repeatedNTimes(new int[]{1, 2, 3, 3}));
    }

    //N+1 unique numbers which means no other repeated number except the one we're looking for
    //So, if we encounter any repeated number, we return it as the result
    //O(n) time complexity with O(n) space
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            //if current elem exists in the set, return it otherwise add it to the set
            if (set.contains(i))
                return i;
            set.add(i);
        }

        //no repeated number exists
        return 0;
    }


    //O(n)
    public int repeatedNTimes2(int[] A) {
        //in case of short arrays, only comparison to 1
        int k = A.length / 2 > 2 ? 2 : 1;
        //check every elem with its next neighbors
        for (int i = 0; i < A.length - k; i++) {
            //if elem == next elem return it
            if (A[i] == A[i + 1])
                return A[i];
            //if array's lenght is more than 4, check the second next elem to the current one
            if (k == 2 && A[i] == A[i + 2])
                return A[i];
        }

        //compare the first and last in the array only for
        return A[0] == A[A.length - 1] ? A[0] : 0;
    }

    //The above idea can also be applied in divide and conquer, best O(log n) worst O(n^2)


    @Test
    public void TestReaptedNTimes() {
        Assert.assertEquals(3, repeatedNTimes(new int[]{1, 2, 3, 3}));
        Assert.assertEquals(2, repeatedNTimes(new int[]{2, 1, 0, 2}));
        Assert.assertEquals(5, repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    @Test
    public void TestReaptedNTimes2() {
        Assert.assertEquals(3, repeatedNTimes2(new int[]{1, 2, 3, 3}));
        Assert.assertEquals(2, repeatedNTimes2(new int[]{2, 1, 0, 2}));
        Assert.assertEquals(2, repeatedNTimes2(new int[]{0, 1, 2, 2}));
        Assert.assertEquals(5, repeatedNTimes2(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }


}
