package com.leetcode;

//m_462_MinimumMovestoEqualArrayElementsII 
//Show Topic Tags

import com.sun.deploy.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty integer array
// find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1
// or decrementing a selected element by 1.
//
//You may assume the array's length is at most 10,000.
//
//Example:
//
//Input:
//[1,2,3]

//Output:
//2
//
//Explanation:
//Only two moves are needed (remember each move increments or decrements one element):
//
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
//******************************************************************************************************************

public class m_462_MinimumMovestoEqualArrayElementsII {


    public static void main(String[] args) {


    }

    //Naive Solutions or Brute Force
    //2 for loops to count distance for each elem and sum these distances .. the result should be the minimal sum
    public int minMoves21(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            for (int j = 0; j < nums.length; j++) {
                s += Math.abs(nums[i] - nums[j]);
            }

            if (s < min)
                min = s;
        }


        return min;
    }


    //Sort array
    //Get the midian elem
    //Calc the distance between all elems and mid elem in the array
    public int minMoves22(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length / 2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - mid);
        }

        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(2, minMoves21(new int[]{1, 2, 3}));
        Assert.assertEquals(91, minMoves21(new int[]{1,2,3,2,10,8,4,2,9,30,44}));


        Assert.assertEquals(0, minMoves22(new int[]{1}));
        Assert.assertEquals(0, minMoves22(new int[]{1, 1}));
        Assert.assertEquals(1, minMoves22(new int[]{1, 2}));
        Assert.assertEquals(2, minMoves22(new int[]{1, 2, 3}));
        Assert.assertEquals(91, minMoves22(new int[]{1,2,3,2,10,8,4,2,9,30,44}));

    }

}
