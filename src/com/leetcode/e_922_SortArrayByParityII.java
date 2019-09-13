package com.leetcode;

//e_922_SortArrayByParityII 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//
//Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//
//You may return any answer array that satisfies this condition.
//
//
//
//Example 1:
//
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//Note:
//
//2 <= A.length <= 20000
//A.length % 2 == 0
//0 <= A[i] <= 1000
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/sort-array-by-parity-ii/
//******************************************************************************************************************

public class e_922_SortArrayByParityII {


    public static void main(String[] args) {


    }

    //pointers to point to odd and even
    public int[] sortArrayByParityII(int[] A) {
        //s [start] points to the current index/elem
        //e [end] points to the next elem to use [might be odd/even]
        int s = 0, e = 1;
        int temp = 0;
        while (s <= A.length - 2) {
            //check current index vs content at this index
            //if elem at s is wrong and can be swapped with elem at e, then swap them and increment s only
            if ((s % 2 == 1 && A[s] % 2 == 0 && A[e] % 2 == 1) || (s % 2 == 0 && A[s] % 2 == 1 && A[e] % 2 == 0)) {
                temp = A[s];
                A[s] = A[e];
                A[e] = temp;
                s++;
            //else if elem at s is correct, increment s and e
            } else if ((s % 2 == 0 && A[s] % 2 == 0) || (s % 2 == 1 && A[s] % 2 == 1)) {
                s++;
                e++;
            //else increment e to find correct next elem
            } else {
                e++;
            }

        }

        return A;
    }


    @Test
    public void TestsortArrayByParityII() {
        Assert.assertArrayEquals(new int[]{4, 5, 2, 7}, sortArrayByParityII(new int[]{4, 2, 5, 7}));
        Assert.assertArrayEquals(new int[]{4}, sortArrayByParityII(new int[]{4}));
        Assert.assertArrayEquals(new int[]{}, sortArrayByParityII(new int[]{}));
        Assert.assertArrayEquals(new int[]{4, 5, 2, 1, 2, 3, 4, 5, 6, 9}, sortArrayByParityII(new int[]{4, 2, 2, 4, 5, 6, 1, 3, 5, 9}));
        Assert.assertArrayEquals(new int[]{2, 3, 4, 1, 0, 1, 0, 3, 4, 3}, sortArrayByParityII(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3}));
        Assert.assertArrayEquals(new int[]{4,3}, sortArrayByParityII(new int[]{3,4}));


    }
}
