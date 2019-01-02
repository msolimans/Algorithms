package com.lincode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by msoliman on 2/16/17.
 */
public class IntersectionofTwoArrays {
    //Given two arrays, write a function to compute their intersection.

    //Notice

    //Each element in the result must be unique.
    //The result can be in any order.
    //Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

    //Can you implement it in three different algorithms?
    //Tags
    //Binary Search Two Pointers Sort Hash Table


    public static void main(String[] str) {
        System.out.print(Arrays.toString(intersection1(new int[]{1, 2, 2, 3}, new int[]{2, 2})));
        System.out.print(Arrays.toString(intersection(new int[]{1, 2, 2, 3}, new int[]{2, 2})));

    }



    //brute force
    static int[] intersection1(int[] nums1, int[] nums2) {
        //using 2 pointers
        HashSet s = new HashSet();

        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    s.add(nums1[i]);
            }


        int[] r = new int[s.size()];

        int indx = 0;

        Iterator<Integer> i = s.iterator();
        while (i.hasNext()) {
            r[indx] = i.next();
            indx++;
        }


        return r;

    }

    static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet s = new HashSet();


        int indx = 0;


        for (int i : nums1) {
            map.put(i, i);
        }

        for (int i : nums2) {
            if (map.get(i) != null) {
                s.add(i);
                map.remove(i);
            }
        }

        int[] r = new int[s.size()];

        indx = 0;

        Iterator<Integer> i = s.iterator();
        while (i.hasNext()) {
            r[indx] = i.next();
            indx++;
        }


        return r;


    }


}
