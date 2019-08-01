package com.leetcode;

//e_977_SquaresofaSortedArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
//
//
//
//Example 1:
//
//Input: [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Example 2:
//
//Input: [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
//
//
//Note:
//
//1 <= A.length <= 10000
//-10000 <= A[i] <= 10000
//A is sorted in non-decreasing order.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/squares-of-a-sorted-array/
//******************************************************************************************************************

public class e_977_SquaresofaSortedArray {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_977_SquaresofaSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));

    }

    public int[] sortedSquares(int[] A) {
        //result arr
        int[] result = new int[A.length];
        //maintain current index in the result
        int index = A.length - 1;
        //pointers, compare 2 boundaries of A and choose the bigger one to put it at the end
        int i = 0, j = A.length - 1;

        while (i <= j) {
            //if element at i is bigger than at j after multiply, move ith element
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[index] = A[i] * A[i];
                //update pointer i
                i++;
            } else {
                //after multiplication, if element at j is bigger than at i, move jth elem
                result[index] = A[j] * A[j];
                j--;
            }
            //decrease index of result array
            index--;
        }

        return result;

    }


    @Test
    public void TestsortedSquares() {
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }

}
