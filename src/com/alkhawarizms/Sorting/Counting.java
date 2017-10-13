package com.alkhawarizms.Sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by msoliman on 4/19/17.
 * O(n), Stable, Not in place as it needs another array for preserving counts
 * Description:
 *  Counting sort is a simple algorithm where we are having a nother array or storage for preserving the counts of each element in the array
 *  then start distributing or populating the values according to those counters
 *  ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
public class Counting {

    public  static int[] sort(int[] items){
        if(items == null || items.length == 0)
            return null;

        //get the upper bound (max)
        //Linear Time O(n)
        int max = items[0];
        for(int i = 1; i<items.length; i++){
            if(items[i] > max)
                max = items[i];
        }

        return sort(items, max);
    }


    public static int[] sort(int[] items, int bound) {
        return countingSort(items, bound);
    }

    private static int[] countingSort(int[] items, int bound) {
        //instantiate an array for preserving counts of each element in the array
        int[] counts = new int[bound+1];

        //initialize counters with zeros (all items in counters array) O(k) K is the upper bound of counts
        //As long as K is less than or equal to n, it is okay however if K is so bigger than n it will badly affect on time complexity
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        //collecting: how many times an elem occurred/encountered in the array
        for (int item : items) {
            counts[item] = counts[item] + 1;
        }

        //count the occurrence of prefixes or preceding items for each item
        //cumulative count for elements preceding each element.
        if (counts.length > 1)
            for (int i = 1; i < counts.length; i++)
                counts[i] = counts[i] + counts[i - 1];

        int[] results = new int[items.length];
        for (int item : items) {
            results[counts[item] - 1] = item;
            counts[item] = counts[item] - 1;
        }

        return results;

    }


//    private static int[] countingSortUsingHashTable(int[] items, int bound) {
//
//        HashMap<Integer, Integer> counts = new HashMap<>();
//
//        for (int i = 0; i < bound; i++)
//            counts.put(i, 0);
//
//        for (int i = 0; i < items.length; i++)
//            counts[i] = counts[i] + 1;
//
//        if (counts.length > 1)
//            for (int i = 1; i < counts.length; i++)
//                counts[i] = counts[i] + counts[i - 1];
//
//        int[] results = new int[items.length];
//        for (int i = 0; i < items.length; i++) {
//            results[counts[items[i]]] = items[i];
//            counts[items[i]] = counts[items[i]] - 1;
//
//        }
//
//        return results;
//
//    }


}
