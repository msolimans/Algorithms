package com.ocw.c6006.lect3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinaryInsertionSort {

    //Make a binary search to check the correct position where you want to put the item
    //helps with comparisons to decrease it to O(logn) => O(nlogn) for only comparisons operations .. swap is a problem
    //still shifting will be a problem as we have to shift all elements to the right to empty a space for this item to be inserted at the right position
    //worst case scenario still O(n^2)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{3,2,6,3})));

    }

    static int[] sort(int[] arr) {
        int i = 1;
        while (i <=arr.length - 1) {
            int index = find(arr, arr[i], 0, i - 1);
            int item = arr[i];
            for (int j = i; j > index;j--){
                arr[j] = arr[j-1];
            }
            arr[index] = item;
            i++;
        }
        return arr;

    }

    static int find(int[] arr, int k, int s, int e) {
        int mid = (s + e) / 2;

        if (mid - 1 >= 0 && k <= arr[mid] && k >= arr[mid - 1])
            return mid;

        if (mid + 1 <= arr.length - 1 && k >= arr[mid] && k <= arr[mid + 1])
            return mid + 1;

        if (mid == 0 && k <= arr[mid])
            return mid;
        if (mid == arr.length - 1 && k <= arr[mid])
            return mid - 1;


        if (k < arr[mid])
            return find(arr, k, s, mid - 1);
        else
            return find(arr, k, mid + 1, e);
    }

    @Test
    public void TestFind() {
        Assert.assertEquals(2,find(new int[] {1,2,3,4,}, 3, 0 , 4));
        Assert.assertEquals(3,find(new int[] {1,2,3,4,}, 4, 0 , 4));
        Assert.assertEquals(2,find(new int[] {2,3,6,5}, 5, 0 , 4));
        Assert.assertEquals(0,find(new int[] {3,2}, 2, 0 , 2));
    }

    @Test
    public void TestSort() {
        Assert.assertArrayEquals(new int[]{1,2,3,4}, sort(new int[]{2,1,3,4}));
        Assert.assertArrayEquals(new int[]{2,3,10,11}, sort(new int[]{10,11,2,3}));
        Assert.assertArrayEquals(new int[]{10,10}, sort(new int[]{10,10}));
        Assert.assertArrayEquals(new int[]{1,2,3}, sort(new int[]{1,2,3}));
    }

}
