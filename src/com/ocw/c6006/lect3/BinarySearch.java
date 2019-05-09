package com.ocw.c6006.lect3;

import org.junit.Assert;
import org.junit.Test;

//find a K element in a sorted array
public class BinarySearch {

    public static void main(String[] args) {
        System.out.print(find(new int[]{1, 2, 3, 4, 5}, 10));
    }

    //arr is a sorted (recursion)
    //O(logn)
    static boolean find(int[] arr, int k) {
        return find(arr, k, 0, arr.length - 1);
    }

    static boolean find(int[] arr, int k, int s, int e) {
        int mid = (s + e) / 2;
        if (arr.length == 0 || s > arr.length - 1 || e < 0)
            return false;

        if (k == arr[mid])
            return true;
        if (k < arr[mid])
            return find(arr, k, s, mid - 1);
        else
            return find(arr, k, mid + 1, e);
    }

    //local find, using while
    //T(n) = O(1) + T(n/2)
    //T(n) = O(1) + O(1) + O(1) .... => log n times
    //O(logn)
    static boolean find2(int[] arr, int k) {
        if (arr.length == 0)
            return false;

        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                return true;
            }
            if (k < arr[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }

        return false;
    }

    @Test
    public void TestFind() {
        Assert.assertTrue(find(new int[]{1, 2, 3, 4, 5}, 5));
        Assert.assertTrue(find(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertFalse(find(new int[]{1, 2, 3, 4, 5}, 10));
        Assert.assertTrue(find(new int[]{1, 2, 3, 4, 5}, 3));
        Assert.assertFalse(find(new int[]{}, 1));

    }

    @Test
    public void TestFind2() {

        Assert.assertTrue(find2(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertFalse(find2(new int[]{1, 2, 3, 4, 5}, 10));
        Assert.assertTrue(find2(new int[]{1, 2, 3, 4, 5}, 3));
        Assert.assertFalse(find2(new int[]{}, 1));


    }

}

//data compression => sort then count frequencies
