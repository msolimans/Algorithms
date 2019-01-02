package com.glassdoor.vivintsolar;

import java.util.Arrays;

/**
 * Created by msoliman on 11/5/17.
 */
public class MathProbs {

    //find the mean (average) of elements
    static int mean(int[] ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum / ar.length;
    }

    //find the median of arr elements
    static int median(int[] arr) {
        //sort the array
        Arrays.sort(arr);

        //get mid of array
        int mid = arr.length / 2;

        //if number of elements in the array is even return (@mid and @mid-1 / 2)
        if (arr.length % 2 == 0) {
            //even
            return (arr[mid] + arr[mid - 1]) / 2;

        //if number of elements in the array is odd, return @mid
        } else {
            //odd
            return arr[mid];
        }
    }

    public static void main(String[] args) {
        //System.out.println(mean(new int[] {10,20,30}));
        System.out.println(median(new int[]{1, 2, 3, 4}));
        System.out.println(median(new int[]{1, 2, 3, 4, 5}));
    }
}
