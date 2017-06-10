package com.alkhawarizms.Sorting;

/**
 * Created by msoliman on 1/20/17.
 * O(n^2), Stable, in place
 * Description:
    Compares each element with previous elements in the sorted sublist or partition and orderly put it where it should be in the sorted list
    Stable sort (keeps relatively the same order of duplicates) e.g. if we have 2,1(1st),3,1(2nd) => 1(1st),1(2nd),2,3 notice the first and second 1s are coming in the same order as input
    In place sort (no need for temp or out of place storage or array
    Usually runs for small sets of input data but not for large sets

 * Time Complexity:
    Worst case:     O(n^2)
    Average case:   O(n^2)
    Best case:      O(n)      in an already sorted list

 * Trace:
    9 2 1 8 3 10  (9 <-> 2)
    2 9 1 8 3 10  (9 <-> 1 .. 2 <-> 1)
    1 2 9 8 3 10  (9 <-> 8)
    1 2 8 9 3 10  (9 <-> 3 .. 8 <-> 3)
    1 2 3 8 9 10  (10 <-> 9)

 * Tests:
    int[] o = Insertion.sort(new int[]{1,20,3,5,9,18,2,0});
    int[] o1 = Insertion.sort(new int[]{1,2,3,4,5,6);
    System.out.println(Arrays.toString(o));
    System.out.println(Arrays.toString(o1));

 * More info:
    https://en.wikipedia.org/wiki/Insertion_sort
 */


public class Insertion {

    public static int[] sort(int[] list) {
        for (int i = 1; i <= list.length - 1; i++) {

            //current elem (we are starting from index 1)
            int tomove = list[i];


            for (int j = i - 1; j > 0; j--) {
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
}
