package com.alkhawarizms.Sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by msoliman on 4/19/17.
 * O(n), Stable, Not in place
 * Description:
 *  Counting sort is a simple algorithm where we are having a nother array or storage for preserving the counts of each element in the array
 *  then start calculating the
 */
public class Counting {
    public static int[] sort(int[] items, int bound) {
        return countingSort(items, bound);
    }

    private static int[] countingSort(int[] items, int bound) {
        int[] counts = new int[bound+1];
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        //how many times an elem occured in the array
        for (int i = 0; i < items.length; i++) {
            counts[items[i]] = counts[items[i]] + 1;
        }

        //count the occurrence of prefixes or preceding items for each item
        //cumulative count for elements preceding each element.
        if (counts.length > 1)
            for (int i = 1; i < counts.length; i++)
                counts[i] = counts[i] + counts[i - 1];

        //
        int[] results = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            results[counts[items[i]] - 1] = items[i];
            counts[items[i]] = counts[items[i]] - 1;
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
