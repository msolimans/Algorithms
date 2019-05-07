package com.ocw.c6006.lect1;

import org.junit.Assert;
import org.junit.Test;

//Description
//Find Peak Element in an array, an element is peak iff a[i] >= a[i-1] and a[i] >= a[i+1]
//Link: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-1-algorithmic-thinking-peak-finding/
public class FindPeakInArray {

    public static void main(String[] args) {

        System.out.println(RunBinarySearch(new int[]{1, 2, 3}));
        System.out.println(RunN(new int[]{1, 8, 3}));
    }

    //O(log n)
    static int RunBinarySearch(int[] arr) {
        if (arr.length == 0)
            return -1;
        if (arr.length == 1)
            return arr[0];


        int s = 1, e = arr.length - 1;


        while (s <= e) {

            int mid = (s + e) / 2;
            if (mid == arr.length - 1)
                return arr[mid] >= arr[mid - 1] ? arr[mid] : -1;

            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
                return arr[mid];
            else if (arr[mid] < arr[mid - 1])
                e = mid - 1;
            else
                s = mid + 1;
        }

        return -1;
    }

    //O(n) Linear
    static int RunN(int[] arr) {
        if (arr.length == 0)
            return -1;
        if (arr.length == 1) {
            return arr[0];
        }

        int i = 1;
        while (i <= arr.length - 1) {
            if (i == arr.length - 1) {
                return arr[i] >= arr[i - 1] ? arr[i] : -1;
            }

            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return arr[i];
            i++;
        }

        return -1;
    }


    @Test
    public void TestRunN() {
        Assert.assertEquals(2, RunN(new int[]{1, 2}));
        Assert.assertEquals(3, RunN(new int[]{1, 2, 3}));
        Assert.assertEquals(3, RunN(new int[]{1, 2, 3, 2}));
        Assert.assertEquals(4, RunN(new int[]{1, 4, 2}));
        Assert.assertEquals(1, RunN(new int[]{1}));
        Assert.assertEquals(-1, RunN(new int[]{}));
    }

    @Test
    public void TestRunBinarySearch() {
        //   Assert.assertEquals(2, RunBinarySearch(new int[]{1,2}));
        Assert.assertEquals(3, RunBinarySearch(new int[]{1, 2, 3}));
        Assert.assertEquals(3, RunBinarySearch(new int[]{1, 2, 3, 2}));
        Assert.assertEquals(4, RunBinarySearch(new int[]{1, 4, 2}));
        Assert.assertEquals(1, RunBinarySearch(new int[]{1}));
        Assert.assertEquals(-1, RunBinarySearch(new int[]{}));
    }
}


