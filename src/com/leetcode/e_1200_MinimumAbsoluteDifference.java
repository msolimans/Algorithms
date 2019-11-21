package com.leetcode;

//e_1200_MinimumAbsoluteDifference 
//Show Topic Tags


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
//
//
//Example 1:
//
//Input: arr = [4,2,1,3]
//Output: [[1,2],[2,3],[3,4]]
//Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//Example 2:
//
//Input: arr = [1,3,6,10,15]
//Output: [[1,3]]
//Example 3:
//
//Input: arr = [3,8,-10,23,19,-4,-14,27]
//Output: [[-14,-10],[19,23],[23,27]]
//
//
//Constraints:
//
//2 <= arr.length <= 10^5
//-10^6 <= arr[i] <= 10^6

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/minimum-absolute-difference/
//******************************************************************************************************************

public class e_1200_MinimumAbsoluteDifference {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_1200_MinimumAbsoluteDifference().minimumAbsDifference(new int[]{4, 2, 3, 1}).toArray()));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        //sort arr
        Arrays.sort(arr);

        //keep track of mindiff
        int minDiff = Integer.MAX_VALUE;

        //find minDiff in the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        //reset prev again to first elem in arr
        for (int i = 1; i < arr.length; i++) {
            //if diff between current and prev elem equals minDiff we got earlier, then add it to the result
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }


        return result;
    }

    @Test
    public void TestMinimumAbsDifference() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1, 2));
        result.add(Arrays.asList(2, 3));
        result.add(Arrays.asList(3, 4));
        Assert.assertEquals(result, minimumAbsDifference(new int[]{4, 2, 1, 3}));
        //or simple as one line
        Assert.assertEquals("[[1, 2], [2, 3], [3, 4]]", Arrays.toString(minimumAbsDifference(new int[]{4, 2, 1, 3}).toArray()));
    }

}
