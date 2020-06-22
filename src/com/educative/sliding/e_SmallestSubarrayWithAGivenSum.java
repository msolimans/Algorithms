package com.educative.sliding;

//Smallest Subarray with a given sum (easy)

//Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to
// ‘S’. Return 0, if no such subarray exists.

import org.junit.Assert;
import org.junit.Test;

//
//        Example 1:
//
//        Input: [2, 1, 5, 2, 3, 2], S=7
//        Output: 2
//        Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
//        Example 2:
//
//        Input: [2, 1, 5, 2, 8], S=7
//        Output: 1
//        Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
//        Example 3:
//
//        Input: [3, 4, 1, 1, 6], S=8
//        Output: 3
//        Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
//link:
// ttps://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
public class e_SmallestSubarrayWithAGivenSum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));

    }

    //check this soln: looks better n straightforward
    public static int findMinSubArray(int s, int[] arr) {
        //combine first occurence of array
        int l = 0, r = 0, size = Integer.MAX_VALUE, sum = 0;
        //count until getting sum >= s
        while (r < arr.length) {
            sum += arr[r];
            if (sum >= s) {
                size = (r - l) + 1;
                break;
            }

            r++;
        }

        //r points to right side of window (at current element)
        //l points to left side of window (affects on window size)
        while (r >= l && r < arr.length) {
            //check current sum
            //Check if the current window size is the smallest so far, and if so, remember its length.
            if (sum >= s && size > (r - l) + 1)
                size = (r - l) + 1;

            //if we have sum less than s and ++r doesn't exceed length add it
            if (sum < s && ++r < arr.length) {
                sum += arr[r];
            } else {//shrink array as much as you can and always check for sum in next iteration
                sum -= arr[l++];
            }

        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }


    @Test
    public void TestFindMinSubArray() {
        Assert.assertEquals(2, findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        Assert.assertEquals(1, findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        Assert.assertEquals(3, findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }


}
