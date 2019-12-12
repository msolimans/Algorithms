package com.leetcode;

//e_453_MinimumMovestoEqualArrayElements 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
// where a move is incrementing n - 1 elements by 1.
//
//Example:
//
//Input:
//[1,2,3]
//
//Output:
//3
//
//Explanation:
//Only three moves are needed (remember each move increments two elements):
//
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
//******************************************************************************************************************
//Companies: Drawbridge | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
//******************************************************************************************************************

public class e_453_MinimumMovestoEqualArrayElements {


    public static void main(String[] args) {


    }

    //Brute force but this will give TimeLimitExceed .. StackOverflow exceptions because of the number of calls
    public int minMoves(int[] nums) {

        if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);

        int imax = 0;
        boolean pass = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                pass = false;

            if (nums[i] > nums[imax])
                imax = i;
        }

        return pass ? 0 : minMoves(nums, imax, 1);
    }


    public int minMoves(int[] nums, int imax, int count) {

        boolean pass = true;
        //increase all others
        int imaxNew = imax;
        for (int i = 0; i < nums.length; i++) {
            if (imax == i)
                continue;

            nums[i] += 1;

            if (nums[i] < nums[imax])
                pass = false;
            if (nums[i] > nums[imax]) {
                imaxNew = i;
                pass = false;
            }
        }

        return pass ? count : minMoves(nums, imaxNew, count + 1);
    }

    //subtract all elems from the min elem n the array
    //add them up, this should give us the result
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }


    //better is to find minimum number in O(n) then subtract it from all other elems in O(n)
    public int minMoves3(int[] nums) {

        //find the minimum number in the array
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }


        //count now the differences between all elems and this minimum number, this is considered our answer here
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - min;
        }


        return count;
    }


    @Test
    public void TestMinMoves() {
        Assert.assertEquals(2147483646, minMoves(new int[]{1, 2147483647}));
        Assert.assertEquals(3, minMoves(new int[]{1, 2, 3}));
        Assert.assertEquals(0, minMoves(new int[]{1, 1, 1}));
        Assert.assertEquals(2, minMoves(new int[]{1, 0, 1}));


        Assert.assertEquals(2147483646, minMoves2(new int[]{1, 2147483647}));
        Assert.assertEquals(3, minMoves2(new int[]{1, 2, 3}));
        Assert.assertEquals(0, minMoves2(new int[]{1, 1, 1}));
        Assert.assertEquals(2, minMoves2(new int[]{1, 0, 1}));



        Assert.assertEquals(2147483646, minMoves3(new int[]{1, 2147483647}));
        Assert.assertEquals(3, minMoves3(new int[]{1, 2, 3}));
        Assert.assertEquals(0, minMoves3(new int[]{1, 1, 1}));
        Assert.assertEquals(2, minMoves3(new int[]{1, 0, 1}));
    }
}
