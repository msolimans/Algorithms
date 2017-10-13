package com.alkhawarizms.Sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by msoliman on 4/19/17.
 * Linear time, O(n+k) where n is the number of elements in input array and k is the range of the input or the counts array
 * Items (n) should be in range from 1 to k => O(n+k)
 * Counting sort is Stable Algorithm that maintains positions of elements into a reverse order, countingSort() is an example while countingSort2() should not be considered as stable version.
 * Not in place as it needs another array (auxiliary space) for preserving counts
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Description:
 * Counting sort is a simple algorithm where we are having another array or storage for preserving the counts of each element in the array (some kind of hashing values)
 * then start distributing or populating the values according to those counters
 * Steps:
 * 1. Instantiate and Initialize valeus for Counts array
 * 2. Modify counts Array such that each element at each index stores the sum of the previous counts
 * 3. Loop through input array and look for its value in the counts array, put it in the index specified and decrease that index in counts array by 1
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Problems:
 *
 * Can not be used with negative numbers (Indexes should be positives) -> one solution: we can make 2 arrays for positive and negative numbers
 * Should know upper bound of the numbers you are sorting
 * Waste of memory in case we are having big gaps with large numbers
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
public class Counting {

    public static void main(String[] args) {
        //stable version [preserves items' order (reverse order)]
        System.out.println(Arrays.toString(new Counting().sort(new int[]{1, 2, 33, 4, 2, 10, 10, 3, 1, 7, 18})));

        //unstable version
        System.out.println(Arrays.toString(new Counting().sort2(new int[]{1, 2, 33, 4, 2, 10, 10, 3, 1, 7, 18})));
    }

    public int[] sort(int[] items) {
        if (items == null || items.length == 0)
            return null;

        //get the upper bound (max)
        //Linear Time O(n)
        int max = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i] > max)
                max = items[i];
        }

        return sort(items, 0, max);
    }


    public   int[] sort(int[] items, int upperBound) {
        return sort(items, 0, upperBound);
    }

    //items is the input array to be sorted
    //lowerBound is the min in range of auxiliary space we need to use to preserve counting array, it should be the smallest number in the array
    //upperBound is the max in range of auxiliary space we need to use to preserve counting array, it should be the maximum number in the array
    public int[] sort(int[] items, int lowerBound, int upperBound){

        int size = upperBound - lowerBound;
        int[] counts = new int[size + 1];
        for(int i = 0; i< counts.length;i++){
            counts[i] = 0;
        }

        for(int i= 0; i < items.length;i++){
            //subtract here from lower to put all items within the range of [ 0 ..... (upper-lower) ]
            int item = items[i];
            counts[item - lowerBound] += 1;
        }

        for(int i=1;i<counts.length;i++){
            //cumulative counts, calculate offsets for each item in counts
            counts[i] = counts[i] + counts[i-1];
        }

        int[] result = new int[items.length];
        //loop through input array
        for(int i = 0; i < items.length;i++){
            //items[i] is the actual item we need to put in its correct position in the results array
            //lower is the lower bound of the items or the input array, min value in the input array
            //calculate the difference between them to get the correct index of it in counts array
            int indxInCount = items[i] - lowerBound;//return to line# 68 to know why

            //get the current value of that item, current value means where to put it in the index array
            int indexInResult = counts[indxInCount];
            if(indexInResult >= 0) {
                //populate/put current items into its correct position in the result array
                result[--indexInResult] = items[i];
                //update indx in result for this item
                counts[indxInCount] = indexInResult;
            }
        }

        return result;
    }





    //not stable, doesn't care about places of items/elements
    public int[] sort2(int[] items) {
        int min = items[0], max = items[0];
        //O(n)
        if (items.length > 1)
            for (int i = 1; i < items.length; i++) {
                if (items[i] > max)
                    max = items[i];
                if (items[i] < min)
                    min = items[i];
            }
        //O(n+k)
        return sort2(items, min, max);
    }

    public int[] sort2(int[] items, int upperBound) {
        return sort2(items, 0, upperBound);
    }


    public int[] sort2(int[] items, int lowerBound, int upperBound) {
        int size = upperBound - lowerBound;
        int[] counts = new int[size + 1];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        for (int i = 0; i < items.length; i++) {
            int indx = items[i] - lowerBound;
            counts[indx] += 1;
        }

        int indx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;

            int elem = i + lowerBound;
            int c = counts[i];
            while (c-- > 0) {
                items[indx++] = elem;
            }
        }

        return items;
    }


}
