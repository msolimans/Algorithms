package com.alkhawarizms.Sorting;

import java.util.Arrays;

/**
 * Created by msoliman on 1/20/17.
 * O(n^2), Stable, in place
 * Description:
 * Compares each element with previous elements in the sorted sublist or partition and orderly put it where it should be in the sorted list
 * Stable sort (keeps relatively the same order of duplicates) e.g. if we have 2,1(1st),3,1(2nd) => 1(1st),1(2nd),2,3 notice the first and second 1s are coming in the same order as input
 * In place sort (no need for temp or out of place storage or array
 * Usually runs for small sets of input data but not for large sets
 * <p>
 * Time Complexity:
 * Worst case:     O(n^2)
 * Average case:   O(n^2)
 * Best case:      O(n)      in an already sorted list
 * <p>
 * Trace:
 * 9 2 1 8 3 10  (9 <-> 2)
 * 2 9 1 8 3 10  (9 <-> 1 .. 2 <-> 1)
 * 1 2 9 8 3 10  (9 <-> 8)
 * 1 2 8 9 3 10  (9 <-> 3 .. 8 <-> 3)
 * 1 2 3 8 9 10  (10 <-> 9)
 * <p>
 * Tests:
 * int[] o = Insertion.sort(new int[]{1,20,3,5,9,18,2,0});
 * int[] o1 = Insertion.sort(new int[]{1,2,3,4,5,6);
 * System.out.println(Arrays.toString(o));
 * System.out.println(Arrays.toString(o1));
 * <p>
 * More info:
 * https://en.wikipedia.org/wiki/Insertion_sort
 */


public class Insertion {

    public static int[] sort(int[] list) {

        //loop through all elements in array/list
        for (int i = 1; i <= list.length - 1; i++) {

            //current elem (we are starting from index 1)
            int tomove = list[i];


            //loop back to previous elements to the current element we are processing now (to find where correctly should we insert it)
            for (int j = i - 1; j >= 0; j--) {

                //if current elem is greater than its previous elem, stop the loop and move forward to next elem
                if (tomove > list[j])
                    break;

                //swap 2 elems
                list[j + 1] = list[j];
                list[j] = tomove;

            }

        }

        return list;

    }

    //Different Impl: No swapping done, but only shifting until we find proper place/index to insert
    //System.out.println(Arrays.toString(sort2(new int[]{0,3,1,4,2,2,1,0,-1}));
    static int[] sort2(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int toMove = items[i];
            int indx = i - 1;

            //shift items and make a new space to the new item to be finally inserted after this while loop
            while (indx >= 0 && items[indx] > toMove) {

                //just shifting
                items[indx + 1] = items[indx];

                indx--;
            }

            //insert item in sorted portion/part of the array
            items[indx + 1] = toMove;

        }

        return items;
    }




    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{9, 3, 2, 1, 2})));
    }
}
