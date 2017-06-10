package com.probs;

import java.util.HashSet;

/**
 * Created by msoliman on 4/21/17.
 */
public class p_2_DuplicatedArray {
    // Problem 2
    // Given an array find the elements of duplicates, find the element that comes only once
    //O(n)
    public static int run(int[] arr){
        HashSet<Integer> set = new HashSet();

        for(int i: arr){
            if(set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }

        return (int)set.toArray()[0];

    }

    ////brute force, bad performance
    //O(n^2)
    public static int run1(int[] arr){

        for(int i=0; i< arr.length-1;i++){
            boolean exists = false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j])
                    exists = true;
            }

            if(!exists)
                return arr[i];
        }

        return arr[arr.length-1];
    }

    //after sorting O(n log n)
    public static int run3(int[] arr){
        arr = com.alkhawarizms.Sorting.Quick.sort(arr);


        for(int i=0;i<arr.length - 1;i+=2){
            if(arr[i] != arr[i+1])
                return arr[i];
        }

        return arr[arr.length - 1];
    }




}
