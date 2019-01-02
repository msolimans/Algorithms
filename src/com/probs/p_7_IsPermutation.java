package com.probs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 4/25/17.
 */
public class p_7_IsPermutation {
    //check if there is an array is a permutation of another array (no duplicates there)

    public static void main(String[] args) {
        System.out.println(isPermutation_NSquared(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        System.out.println(isPermutation(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        //System.out.println(isPermutation_NSquared(new int[]{1,2,3},new int[]{2,1,3}));
        //System.out.println(isPermutation_NSquared(new int[]{1,2,3},new int[]{2,1,3}));

    }


    //no duplicates
    static boolean isPermutation(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        Set<Integer> set = new HashSet<>();

        for (int i : arr1)
            set.add(i);
        for (int i : arr2)
            if (!set.contains(i))
                return false;
            else
                set.remove(i);


        return true;

    }

    //brute force algorithm
    static boolean isPermutation_NSquared(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {

            boolean occured = false;

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (i != j)
                        diff++;

                    occured = true;
                }
            }

            if (!occured)
                return false;
        }

        return diff > 0;
    }
}
