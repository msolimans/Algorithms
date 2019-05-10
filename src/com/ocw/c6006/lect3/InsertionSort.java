package com.ocw.c6006.lect3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,10,3,4,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //O(n^2) // at any given step, we can have n swaps (for each step (len n), we may have n work)
    static int[] sort(int[] arr) {
        int i = 0;

        while (i <= arr.length - 1) {
            int item = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (item > arr[j])
                    break; //already n right place

                arr[j + 1] = arr[j]; //swap with item as long as arr[j] is bigger
                arr[j] = item;//shift item to right position (insert into the right index)
            }

            i++;
        }
        return arr;
    }

    @Test
    public void TestSort(){
        Assert.assertArrayEquals(new int[]{1,2,3,4}, sort(new int[]{2,1,3,4}));
        Assert.assertArrayEquals(new int[]{0}, sort(new int[]{0}));
        Assert.assertArrayEquals(new int[]{2,3,10,11}, sort(new int[]{10,11,2,3}));
        Assert.assertArrayEquals(new int[]{10,10}, sort(new int[]{10,10}));
        Assert.assertArrayEquals(new int[]{1,2,3}, sort(new int[]{1,2,3}));
    }
}
