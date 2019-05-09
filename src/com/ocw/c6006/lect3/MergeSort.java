package com.ocw.c6006.lect3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    //T(n) = C      +   2 T (n/2)   +   C n
    //     divide        splits         n to merge sub-arrays
    //                      CN                                  height is log(n)
    //              CN/2           CN/2
    //         CN/4      CN/4   CN/4    CN/4
    //                      ....
    //  C C C      ...... N TIMES .......    C C C

    //total:  n log(n)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{12, 3, 2})));

    }

    static int[] sort(int[] arr) {

        if (arr.length == 0 || arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];
        //split
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        int j = 0;
        for (int i = mid; i < arr.length; i++) {
            r[j++] = arr[i];
        }

        int[] sl = sort(l);
        int[] sr = sort(r);

        return merge(sl, sr);
    }

    @Test
    public void TestMerge() {
        Assert.assertArrayEquals(new int[]{0, 2, 3, 3}, merge(new int[]{2, 3}, new int[]{0, 3}));
        Assert.assertArrayEquals(new int[]{2, 3, 12}, merge(new int[]{12}, new int[]{2, 3}));
    }

    @Test
    public void TestSort() {
        Assert.assertArrayEquals(new int[]{0, 2, 3, 3}, sort(new int[]{2, 3, 0, 3}));
        Assert.assertArrayEquals(new int[]{2, 3, 12}, sort(new int[]{12, 2, 3}));
    }


    static int[] merge(int[] l, int[] r) {
        int i = 0, j = 0, c = 0;
        int[] result = new int[l.length + r.length];

        while (i <= l.length - 1 && j <= r.length - 1) {
            if (l[i] <= r[j]) {
                result[c++] = l[i];
                i++;
            } else if (r[j] <= l[i]) {
                result[c++] = r[j];
                j++;
            }
        }

        while (i <= l.length - 1) {
            result[c++] = l[i];
            i++;
        }

        while (j <= r.length - 1) {
            result[c++] = r[j];
            j++;
        }


        return result;
    }
}
