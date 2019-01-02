package com.alkhawarizms.Sorting;


/**
 *
 * Created by msoliman on 4/12/17.
 *
 * Description:
    Optimized version of merge sort in which I make one while loop in the merge function and also depends on offset instead of spliting array.

    Check Original Merge.java to find out more about time complexity, tests, and tracing.

 * Test:
    int[] a =OptimizedMerge.sort(new int[]{3,1,4,2,2,1,-1,0,9});
    System.out.print(Arrays.toString(a)); //[-1, 0, 1, 1, 2, 2, 3, 4, 9]

 */

public class OptimizedMerge  {


    public static int[] sort(int[] items) {

        mergeSort(items, 0, items.length - 1);
        return items;
    }


    static void mergeSort(int[] items, int lo, int hi){
        if(lo >= hi)
            return;


        //get the mid of the array within specific range starting from "lo" to "hi"
        int mid = (hi - lo) / 2 + lo;

        //recursion to continue sorting or splitting
        mergeSort(items, lo,mid);
        mergeSort(items, mid + 1, hi);


        //merge and sort
        merge(items, lo, mid, hi);

    }

    private static void merge(int[] items, int lo, int mid, int hi) {
        //merge 2 parts of the array using offsets or indexes into results then copy the results into the original array.
        //left part: starts from "lo" to "mid"
        //right part: starts from "mid+1" to "hi"
        int left = lo;
        int right = mid + 1;
        int indx = 0;
        int[] results = new int[hi - lo + 1];

        while(true){
            //left part starts from "lo" to "mid" so our stopping condition for left is to exceed "mid"
            //right part starts from "mid + 1" to "hi" so our stopping condition for right is to exceed "hi"

            if(left == mid + 1 && right == hi + 1 )
                break;

            if(left < mid + 1 && right < hi + 1){
                if(items[left] <= items[right])
                    results[indx++] = items[left++];
                else
                    results[indx++] = items[right++];
            }
            else if(left < mid + 1)
                results[indx++] = items[left++];
            else if(right < hi + 1)
                results[indx++] = items[right++];

        }

        //copy from results to original array
        for(int i = 0;i<results.length;i++)
            //copy into correct place considering we already have offset into original array starting from "lo"
            items[lo+i] = results[i];
    }
}
