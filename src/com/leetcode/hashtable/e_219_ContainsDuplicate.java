package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by msoliman on 5/7/17.
 */
public class e_219_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.print(containsNearbyDuplicate(new int[]{1,2,1}, 1));
        System.out.print(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));

    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {

        //char,indx
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;

            map.put(nums[i], i);


        }

        return false;

    }
}
