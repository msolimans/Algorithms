package com.alkhawarizms.Search;

/**
 * Created by msoliman on 1/21/17.
 */
public class Binary {
    //Prerequisities: input array is already sorted
    //O(log n)
    //in insertion:
    //  Using binary search .. we can find where to put the new element to be inserted in O(log n) time
    //  however time of insertion in the array involves shifting which costs O(n) unless we use BST, check datastructure/bst for its implementation.
    // O(logn) in search-insertion-deletion (but keep it balanced = O(logn) in case it's not balanced it is gonna be O(n)

    //================================================================================
    //WHILE LOOP VERSION
    //================================================================================

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

    //================================================================================
    //RECURSIVE CALL VERSION
    //================================================================================

    public static  int search2(int[] sorted, int term){
        return search2(sorted, term, 0, sorted.length-1);
    }

    static int search2(int[] sorted, int term, int start, int end){
        int mid = (end - start) / 2;
        int guess = sorted[mid];
        //stopping conditions
        if(guess == term)
            return mid;
        if(start >= end)
            return -1;

        if(guess > term){
            //go before guess (lower), update only end
            end = mid - 1;
        }else{
            //go after guess (upper), update only start
            start = mid + 1;
        }

        return search2(sorted, term, start, end);
    }


    //testing
    public  static void main(String[] args){
        System.out.println(Binary.search(new int[]{1,2,3,4,5,6,7}, 4));
        System.out.println(Binary.search2(new int[]{1,2,3,4,5,6,7}, 4));
    }
}
