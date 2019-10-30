package com.leetcode;

//e_1051_HeightChecker 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Students are asked to stand in non-decreasing order of heights for an annual photo.
//
//Return the minimum number of students not standing in the right positions.
// (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
//
//
//
//Example 1:
//
//Input: [1,1,4,2,1,3]
//       [1,1,1,2,3,4]
//Output: 3
//Explanation:
//Students with heights 4, 3 and the last 1 are not standing in the right positions.

//[2,2,9,2]
//[2,2,2,9]
////[3,2,1,0]
////[0,1,2,3]
//
//Note:
//
//1 <= heights.length <= 100
//1 <= heights[i] <= 100
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/height-checker/
//******************************************************************************************************************

public class e_1051_HeightChecker {


    public static void main(String[] args) {

        System.out.println(new e_1051_HeightChecker().heightChecker(new int[]{9, 2, 2, 10}));
    }

    public int heightChecker(int[] heights) {

        //copy input array and sort it
        int[] sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);

        //compare both arrays [sorted and unsorted] and see if any diffs, for any diffs in position that means there was a move there.
        int moves = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i])
                moves++;
        }


        return moves;
    }

    @Test
    public void TestHeightChecker() {
        Assert.assertEquals(3, heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        Assert.assertEquals(2, heightChecker(new int[]{9, 2, 2, 10}));
        Assert.assertEquals(0, heightChecker(new int[]{1, 2, 3, 4}));
    }

}
