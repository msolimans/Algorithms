package com.leetcode.hashtable;

import java.util.*;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_349_Intersection {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(run1(new int[]{1, 2, 3, 4, 4, 2}, new int[]{2,3,4,4})));

    }

    static int[] run1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return run1(nums2, nums1);

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int j = 0;

        //loop through the smaller one
        for (int i = 0; i < nums1.length; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1])
                continue;
            while (j < nums2.length && nums2[j] < nums1[i])
                j++;

            if(j >= nums2.length) break;

            if(nums1[i] == nums2[j])
                list.add(nums1[i]);


        }

        return list.stream().mapToInt(Integer::intValue).toArray();


    }

    static int[] run(int[] nums1, int[] nums2) {

        //for saving memory in case of there is one much smaller than the other
        if (nums1.length < nums2.length)
            return run(nums2, nums1);


        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();


        if (nums1.length == 0 || nums2.length == 0)
            return new int[]{};


        for (int i : nums1)
            set.add(i);

        for (int i : nums2) {
            if (set.contains((i))) {
                set.remove(i);
                result.add(i);
            }
        }


        return result.stream().mapToInt(Integer::intValue).toArray();


    }
}
