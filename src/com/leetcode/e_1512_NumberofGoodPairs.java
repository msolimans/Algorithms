package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//1512. Number of Good Pairs
//Given an array of integers nums.
//
//A pair (i,j) is called good if nums[i] == nums[j] and i < j.
//
//Return the number of good pairs.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//Example 2:
//
//Input: nums = [1,1,1,1]
//Output: 6
//Explanation: Each pair in the array are good.
//Example 3:
//
//Input: nums = [1,2,3]
//Output: 0
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
//https://leetcode.com/problems/number-of-good-pairs/submissions/
public class e_1512_NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        //record elems with number of occurrences
        Map<Integer,Integer> visited = new HashMap<>();
        int result = 0;
        for(int i: nums) {
            if(visited.containsKey(i)) {
                //each element can be a pair with all previously visited elems
                result+=visited.get(i);
            }
            visited.put(i, visited.getOrDefault(i,0) + 1);
        }
        return result;
    }

    @Test
    public void TestnumIdenticalPairs() {
        Assert.assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
        Assert.assertEquals(0, numIdenticalPairs(new int[]{1,2}));
        Assert.assertEquals(0, numIdenticalPairs(new int[]{1}));

    }

}
