package com.alkhawarizms.Sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by msoliman on 4/13/17.
 * Not in place
 * Description:
 * Depends on another bucket/array that distribute the values in buckets, we must know in advance that items are fairly distributed over intervals. we should divide this interval in K equal-sized (buckets)
 * then for every bucket we use some linear sorting algoorithm (e.g. Counting Sort)
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Steps:
 * Create a bucket array,
 * Start t put all items in each bucket (by dividing on length of bucket array),
 * Put Collisioned items in LinkedList/Array
 * Sort each bucket's content in case it has many items in each bucket (using insertion sort)
 * Start to list all items from buckets
 * Algorithm:
 *  For each element i from L
        If B[i] is not empty
            Put A[i] into B[i] using insertion sort;
        Else B[i] := A[i]
    Concatenate B[i .. n] into one sorted list;
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Time Complexity: O(n+k) where n is the number of items in the array to be sorted and K is the number of buckets
 */
public class Bucket {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Bucket().sort(new int[]{1,6,3,78,12,3,5,1,3}, 9)));

    }

    public int[] sort(int[] items, int bk){
        if(items == null || items.length == 0)
            return  null;

        //list or arraylist
        List<Integer>[] buckets = new ArrayList[bk];

        for(int i: items){
            //find where to save ... its bucket (space)
            int indx = (int) Math.floor(i/bk);
            if(buckets[indx] == null){
                buckets[indx] = new ArrayList<>();
            }
            buckets[indx].add(i);
        }

        //insertion sort for all ArrayList you have added into each bucket
        int indx = 0;
        for(List<Integer> bucket: buckets){
            if(bucket != null){
                //sort first, items should be sorted using some linear sorting algorithm, we can use CountingSort O(n)
                //Collections.sort(bucket) can be used for simplicity too - Insertion Sort can be used for small sized arrays
                int[] sorted = Counting.sort(bucket.stream().filter( t -> t!=null).mapToInt(t -> t).toArray());

                //list them for output
                for(int i : sorted){
                    items[indx++] = i;
                }

            }
        }


        return items;
    }

}
