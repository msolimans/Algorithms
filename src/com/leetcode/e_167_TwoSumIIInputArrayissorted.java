package com.leetcode;

//167. Two Sum II - Input array is sorted
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
//Note:
//
//Your returned answers (both index1 and index2) are not zero-based.
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//Example:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//******************************************************************************************************************

public class e_167_TwoSumIIInputArrayissorted {


    public static void main(String[] args) {


    }

    //simplest/naive soln
    //time complexity: O(n)
    //space: O(n)
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int secondIndex = map.getOrDefault(target - numbers[i], -1);
            if (secondIndex != -1 && secondIndex > i) {
                return new int[]{i + 1, secondIndex + 1};
            }
        }

        return new int[]{-1, -1};
    }

    //time complexity: O(n), space: O(1)
    public int[] twoSum2(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        int result = 0;
        while (start < end) {
             result = numbers[start] + numbers[end];
            if (result == target) {
                return new int[]{start+1, end+1};
            } else if (result > target){
                end--;
            } else {
                start++;
            }
        }

        return new int[]{-1, -1};
    }


    @Test
    public void TestTwoSum() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{2, 3}, twoSum(new int[]{2, 4,4, 11, 15}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, twoSum(new int[]{2, 4, 11, 15}, 8));
        Assert.assertArrayEquals(new int[]{3,4}, twoSum(new int[]{2, 4, 11, 15}, 26));
        Assert.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2, 4, 11, 15}, 6));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum(new int[]{2, 4, 11, 15}, 15));
        Assert.assertArrayEquals(new int[]{1,4}, twoSum(new int[]{2, 4, 11, 15}, 17));
    }

    @Test
    public void TestTwoSum2() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum2(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum2(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum2(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{2, 3}, twoSum2(new int[]{2, 4,4, 11, 15}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, twoSum2(new int[]{2, 4, 11, 15}, 8));
        Assert.assertArrayEquals(new int[]{3,4}, twoSum2(new int[]{2, 4, 11, 15}, 26));
        Assert.assertArrayEquals(new int[]{1,2}, twoSum2(new int[]{2, 4, 11, 15}, 6));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum2(new int[]{2, 4, 11, 15}, 15));
        Assert.assertArrayEquals(new int[]{1,4}, twoSum2(new int[]{2, 4, 11, 15}, 17));
    }

}
