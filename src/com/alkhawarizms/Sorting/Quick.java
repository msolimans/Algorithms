package com.alkhawarizms.Sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by msoliman on 1/24/17.
 */

public class Quick {
    //O(n log n) in average case
    //O(n^2) in worst case
    //In Place
    //Randomized version of sorting
    //most libraries in programming languages are implemented based on quick sort
    //Pivot selection .. randomly
    public static int[] sort(int[] items) {

        //select random pivot and arrange or sort all keys around this pivot.
        //sometimes mid of array
        //items.length/2
        //[3,2,6,5,1]->6
        //3,2,5,6,1
        //3,2,5,1,6

        quickSortyRandomPivot(items, 0, items.length - 1);


        return items;
    }

    private static void quickSortyRandomPivot(int[] items, int from, int to){
        if(from>=to)
            return;

        //int pivotIndx = from + (Math.random() * (to - from ));
        int pivotIndx = ThreadLocalRandom.current().nextInt(from, to + 1);


        int pivot = items[pivotIndx];
        System.out.print(pivot);
        int mid = from;


        for(int i = from; i <= to;i++){
            if(items[i]<=pivot){
                swap(items, mid, i);



                if(i == pivotIndx)
                    pivotIndx = mid;


                mid++;
            }

        }

        swap(items, pivotIndx, mid-1);


        quickSortyRandomPivot(items, from, mid - 2);
        quickSortyRandomPivot(items, mid , to);



    }

    private static void quickSortTailPivot(int[] items, int from, int to) {

        if (from >= to)
            return;

        int pivot = items[to];

        //steps
        //all elements previous to middle should be less than the pivot
        //all elements next to middle should be greater than the pivot
        //put pivot in the middle
        int middle = from;

        //loop ends  up before last element as it was chosen as pivot
        for (int i = from; i < to; i++) {

            if (items[i] <= pivot) {
                //swap current item with middle position
                swap(items, middle, i);
                middle++;
            }

        }

        //put pivot in the mid of sorted parts or slices
        swap(items, middle, to);

        //start sorting the 2 halfes of the array
        quickSortTailPivot(items, from, middle - 1);
        quickSortTailPivot(items, middle + 1, to);
    }

    /*
    Tracing:
        10,2,20,-1,2,5,10,1
        pivot=10, mid=1, i=0..7
        2<=10 yes   => swap mid/i but mid = i => mid = 2    => 10,2,20,-1,2,5,10,1
        20<=10 no   => i++ => mid = 2 - i                   => 10,2,20,-1,2,5,10,1
        -1<=10 yes  => swap mid/i, mid = 3                  => 10,2,-1,20,2,5,10,1
        2<10 yes    => swap mid/1, mid = 4                  => 10,2,-1,2,20,5,10,1
        5<10 yes    => swap mid/1, mid = 5                  => 10,2,-1,2,5,20,10,1
        10<=10 yes  => swap mid/i, mid = 6                  => 10,2,-1,2,5,10,20,1
        1<=10  yes  => swap mid/i, mid = 7                  => 10,2,-1,2,5,10,1,20

        swap pivot/mid-1 (@ index = 7 - 1 = 6)
         1,2,-1,2,5,10,10,20

         Start recursively sorting again between
            All elements before pivot (@index = mid - 1) which means => between 0 to mid - 2
            All elements before pivot (@index = mid - 1) which means => between mid to length -1
     */
    private static void quickSortHeadPivot1(int[] items, int from, int to){
        if(from >= to)
            return;

        int pivot = items[from], mid = from + 1;

        //the first elem was skipped here as it was chosen as the pivot
        for(int i = from+1; i<= to ;i++){
            if(items[i] <= pivot) {
                swap(items, mid, i);
                mid++;
            }

        }

        swap(items, mid-1, from);

        //start sorting again
        quickSortHeadPivot1(items, from, mid - 2);
        quickSortHeadPivot1(items, mid, to);

    }

    /*
    Different Indexing (mid starts from the same loc as pivot
    Tracing:
       10,2,20,-1,2,5,10,1
       pivot=10, mid=0, i=0..7

       2<=10 yes   => mid++(1), swap mid/i                  => 10,2,20,-1,2,5,10,1
       20<=10 no   => i++, mid = 1                          => 10,2,20,-1,2,5,10,1
       -1<=10 yes  => mid++(2), swap mid/i,                 => 10,2,-1,20,2,5,10,1
       2<10 yes    => mid++(3), swap mid/1                  => 10,2,-1,2,20,5,10,1
       5<10 yes    => mid++(4), swap mid/1                  => 10,2,-1,2,5,20,10,1
       10<=10 yes  => mid++(5), swap mid/i                  => 10,2,-1,2,5,10,20,1
       1<=10  yes  => mid++(6), swap mid/i                  => 10,2,-1,2,5,10,1,20

       Swap pivot/mid (@ index = 6)
        1,2,-1,2,5,10,10,20

        Start recursively sorting again between
           All elements before pivot (@index = mid) which means => between "$from" and "mid - 1" (0...5)
           All elements before pivot (@index = mid) which means => between "mid + 1" and "to" (7...7)
    */
    private static void quickSortHeadPivot(int[] items, int from, int to){
        if(from >= to)
            return;

        int pivot = items[from], mid = from;

        //the first elem was skipped here as it was chosen as the pivot
        for(int i = from+1; i<= to ;i++){
            if(items[i] <= pivot) {
                mid++;
                swap(items, mid, i);

            }

        }

        swap(items, mid, from);

        //start sorting again
        quickSortHeadPivot(items, from, mid - 1);
        quickSortHeadPivot(items, mid + 1, to);


    }

    static void swap(int[] items, int l, int r) {


        int tmp = items[l];
        items[l] = items[r];
        items[r] = tmp;

    }


}
