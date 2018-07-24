package com.probs;

import java.util.*;

/**
 * Created by msoliman on 5/3/17.
 */
public class p_14_Intersection {
    public static void main (String[] args){
        System.out.println(Arrays.toString(Run_BruteForce(new int[]{1,2,3}, new int[]{2,31,2})));
        System.out.println(Arrays.toString(Run_ONM(new int[]{1,2,3}, new int[]{2,31,2})));


    }


    //O(nxm)
    static Integer[] Run_BruteForce(int[] nums1, int[] nums2){
        List<Integer> lst = new ArrayList<>();


        for (int i1 :
                nums1) {
            for (int i2 :
                    nums2) {
                if (i1 == i2) {
                    lst.add(i1);
                    break;
                }

            }
        }

        return  lst.toArray(new Integer[0]);

    }



    //O(n + m)
    static Integer[] Run_ONM(int[] nums1, int[] nums2){
        List<Integer> lst = new ArrayList<>();

        Set<Integer> map = new HashSet<>();

        for (int i :
                nums1) {
            map.add(i);
        }


        for (int i :
                nums2) {
            if(map.contains(i)) {
                lst.add(i);
                break;
            }
        }

        return lst.toArray(new Integer[0]);

    }





}
