package com.leetcode.hashtable;

import java.util.*;

/**
 * Created by msoliman on 5/7/17.
 */
public class e_350_Intersect2 {
    public static void main(String[] args){
        //System.out.println(Arrays.toString(intersect(new int[]{3,1,2}, new int[]{1,1})));
        //System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));


        System.out.println(Arrays.toString(intersect_sorted(new int[]{1,1,2,2}, new int[]{2,2})));


    }

    //follow up
    //sorted arrays
    static  int[] intersect_sorted(int[] nums1, int[] nums2){
        if(nums2.length < nums1.length)
            return intersect_sorted(nums2,nums1);

        int i1 = 0, i2=0;

        List<Integer> result = new ArrayList<>();

        while(i1 < nums1.length && i2 < nums2.length){
            if(nums1[i1] < nums2[i2])
                i1++;
            else if(nums1[i1] > nums2[i2])
                i2++;
            else if(nums1[i1] == nums2[i2]){

                result.add(nums1[i1]);
                i1++;
                i2++;
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    static int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums1){
            map.put(i, map.getOrDefault(i,0) + 1);

        }

        List<Integer> result = new ArrayList<>();

        for(Integer i: nums2){
            if(map.getOrDefault(i, 0) > 0){
                result.add(i);
                map.put(i, map.get(i) - 1);
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
