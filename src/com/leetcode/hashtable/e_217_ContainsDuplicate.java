package com.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 5/7/17.
 */
public class e_217_ContainsDuplicate {

    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[]{1,2,2,3,1}));

    }

    static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i))
                return true;
            set.add(i);
        }

        return false;
    }
}
