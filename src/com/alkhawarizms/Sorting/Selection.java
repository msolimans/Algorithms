package com.alkhawarizms.Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by msoliman on 1/24/17.
 * O(n^2), NOT STABLE, IN PLACE
 * Description:
    Selection sort loops through elements and find the minimal value then swap it with the current index or the marker of the sorted partition or sublist
    In-place sorting algorithm
    Not stable sort (which means it is not keeping the same order of duplicates
 * Time Complexity:
     Worst case:     O(n^2)
     Average case:   O(n^2)
     Best case:      O(n) - in an already sorted list

 * Tests:
     int[] o = Selection.sort(new int[]{1,20,3,5,9,18,2,0});
     int[] o1 = Selection.sort(new int[]{1,2,3,4,5,6);
     System.out.println(Arrays.toString(o));
     System.out.println(Arrays.toString(o1));

 * For more info:
     https://www.youtube.com/watch?v=fgYlVyrt1vE&list=PLpPXw4zFa0uKKhaSz87IowJnOTzh9tiBk&index=77
     https://en.wikipedia.org/wiki/Selection_sort

 */

public class Selection {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Selection().sort(new int[]{1,22,9,2,-1})));
        System.out.println(Arrays.toString(new Selection().sort(new int[]{-1})));
        System.out.println(Arrays.toString(new Selection().sort(new int[]{})));

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int j = scan.nextInt();
        int j1 = scan.nextInt();
        int j2 = scan.nextInt();
        System.out.println(i + " " + j);



    }


    public int[] sort(int[] items){
        int indx = 0;

        while(indx < items.length - 2){
            //holds the most minimum value before current elem
            int min = items[indx];
            //hold the index of the most minimum value or element before current element
            int minIndx = indx;

            for(int i = indx + 1 ; i<= items.length - 1;i++)
                if(items[i] < min) {
                    min = items[i];
                    minIndx = i;
                }

            if(min < items[indx]) {
                //Swap with least element we already found
                items[minIndx] = items[indx];
                items[indx] = min;
            }

            indx++;
        }


        return items;
    }
}
