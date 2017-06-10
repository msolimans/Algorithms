package com.alkhawarizms.Search;

/**
 * Created by msoliman on 1/21/17.
 */
public class Binary {
    //prerequisities: input array is already sorted
    //O(log n)
    //in insertion:
    //  Using binary search .. we can find where to put the new element to be inserted in O(log n) time
    //  however time of insertion in the array involves shifting which costs O(n) unless we use BST
    // O(logn) in search-insertion-deletion (but keep it balanced = O(logn) in case it's not balanced it is gonna be O(n)

    public static int search(int[] sorted, int term){
        int min = 0;
        int max = sorted.length - 1;

        while(min <= max){
            int mid = (min + max ) / 2;
            if(sorted[mid] == term)
                return mid;
            else if(sorted[mid] < term)
                min = mid + 1;
            else
                max = mid - 1;
        }

        return -1;

    }
}
