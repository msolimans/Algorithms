package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 2/14/17.
 * Hashmap
 */

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

//Companies: Amazon | 196  Google | 94  Adobe | 66  Apple | 53  Microsoft | 30  Facebook | 28  Yahoo | 20  Bloomberg | 15  Uber | 9  Oracle | 8  Goldman Sachs | 7  LinkedIn | 5  Walmart Labs | 5  Cisco | 4  Morgan Stanley | 3  Huawei | 3  Expedia | 3  VMware | 3  FactSet | 3  Splunk | 3  Yandex | 2  Zillow | 2  Citadel | 2  Intel | 2  Salesforce | 2  Tableau | 2  Audible | 2  Roblox | 2

public class e_1twosum {
    //brute force
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 2; i++)
            for (int j = i + 1; j <= nums.length - 1; j++)

                if ((nums[i] + nums[j]) == target)
                    return new int[]{i, j};
        return new int[]{};
    }

    //[1,2,3,4,5,6,7] => 9
    //[9,2,1,5,0,3,6] => 9
    //9,2,1,5,0,3,6 -> map (n)

    //hashmap .. 2 loops
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> mappings = new HashMap();

        for (int i = 0; i < nums.length; i++)
            mappings.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (mappings.containsKey(complement) && mappings.get(complement) != i)
                return new int[]{i, mappings.get(complement)};
        }
        return new int[]{};
    }


    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }

        return new int[]{};
    }


    @Test
    public void TestTwoSum() {
        Assert.assertArrayEquals(new int[]{1, 6}, twoSum2(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
        Assert.assertArrayEquals(new int[]{0, 4}, twoSum2(new int[]{9, 2, 1, 5, 0, 3, 6}, 9));

        Assert.assertArrayEquals(new int[]{3, 4}, twoSum3(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
        Assert.assertArrayEquals(new int[]{0, 4}, twoSum3(new int[]{9, 2, 1, 5, 0, 3, 6}, 9));


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{  2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{ -3,4,3,90},0)));

        System.out.println(Arrays.toString(twoSum2(new int[]{  2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{ -3,4,3,90},0)));

        System.out.println(Arrays.toString(twoSum3(new int[]{  2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum3(new int[]{ -3,4,3,90},0)));


    }

}
