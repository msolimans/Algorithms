package com.leetcode;

//e_1207_UniqueNumberofOccurrences 
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
//Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
//
//
//
//Example 1:
//
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//Example 2:
//
//Input: arr = [1,2]
//Output: false
//Example 3:
//
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
//
//
//Constraints:
//
//1 <= arr.length <= 1000
//-1000 <= arr[i] <= 1000
//******************************************************************************************************************
//Companies: Google
//******************************************************************************************************************
//Link: https://leetcode.com/problems/unique-number-of-occurrences/
//******************************************************************************************************************

public class e_1207_UniqueNumberofOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> s = new HashSet<>();
        for (int i : map.values()) {
            if (s.contains(i))
                return false;
            s.add(i);
        }

        return true;
    }

    @Test
    public void TestuniqueOccurrences() {


        Assert.assertTrue(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        Assert.assertTrue(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        Assert.assertFalse(uniqueOccurrences(new int[]{1, 2}));

    }
}
