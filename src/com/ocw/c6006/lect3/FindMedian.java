package com.ocw.c6006.lect3;

import java.util.Arrays;

//in case of even: average of 2 mid-elems
//odd, mid of array
public class FindMedian {
    public static void main(String[] args) {
        System.out.println(calcMedian(new int[]{2, 10, 2}));
    }

    //sort O(nlogn)
    //median O(1)
    static int calcMedian(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {//even
            return arr[arr.length / 2] + arr[(arr.length / 2) + 1] / 2;
        }

        return arr[arr.length / 2];
    }
}
