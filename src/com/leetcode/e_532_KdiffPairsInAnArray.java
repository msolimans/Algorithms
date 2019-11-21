package com.leetcode;

//e_532_KdiffPairsInAnArray
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
//
//Example 1:
//Input: [3, 1, 4, 1, 5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of unique pairs.
//Example 2:
//Input:[1, 2, 3, 4, 5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
//Example 3:
//Input: [1, 3, 1, 5, 4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
//Note:
//The pairs (i, j) and (j, i) count as the same pair.
//The length of the array won't exceed 10,000.
//All the integers in the given input belong to the range: [-1e7, 1e7].

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/
//******************************************************************************************************************

public class e_532_KdiffPairsInAnArray {

    public static void main(String[] args) {
        System.out.println(new e_532_KdiffPairsInAnArray().findPairs(new int[]{1, 2, 3, 4}, 1));

    }

    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        Set<Integer> xs = new HashSet<>();

        Map<Integer, Integer> pair = new HashMap<>();


        for (int i : nums) {

            //because it was absolute diff, we need to add and subtract
            int sum = i + k;//3+5 = 3  [3,5,8],5
            int sub = i - k;//5-3 = 3
            if (xs.contains(sum)) {
                //not to repeat the pair again, make sure the small one as key and the bigger one as value
                pair.put(i < sum ? i : sum, i > sum ? i : sum);
            }

            if (xs.contains(sub)) {
                //not to repeat the pair again, make sure the small one as key and the bigger one as value
                pair.put(i < sub ? i : sub, i > sub ? i : sub);
            }

            xs.add(i);
        }

        return pair.size();
    }

    @Test
    public void TestFindPairs() {
        Assert.assertEquals(0, findPairs(new int[]{1, 1}, 1));
        Assert.assertEquals(2, findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        Assert.assertEquals(4, findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertEquals(0, findPairs(new int[]{1, 2, 3, 4, 5}, -1));
        Assert.assertEquals(1, findPairs(new int[]{1, 1, 1, 2, 1}, 1));
        Assert.assertEquals(1, findPairs(new int[]{-1, 1, 3, 1, 5, 4}, 0));
    }
}
