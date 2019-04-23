package com.g4g.easy;

import org.junit.Test;
import org.junit.Assert;


import java.util.Scanner;


//Subarray with given sum
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
//
//        Output:
//
//        Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.
//
//        Note: Position of 1st element of the array should be considered as 1.
//
//        Expected Time Complexity: O(n)
//
//        Constraints:
//        1 ≤ T ≤ 100
//        1 ≤ N ≤ 100
//        1 ≤ an array element ≤ 200
//
//        Example:
//
//        Input:
//        2
//        5 12
//        1 2 3 7 5
//        10 15
//        1 2 3 4 5 6 7 8 9 10
//
//        Output:
//        2 4
//        1 5
//
//        Explanation :
//        In first test case, sum of elements from 2nd position to 4th position is 12
//        In second test case, sum of elements from 1st position to 5th position is 15
//******************************************************************************************************************
//Companies: Visa, Google, Facebook, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/?ref=self
//******************************************************************************************************************

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int len = scan.nextInt();
            int n = scan.nextInt();
            int[] arr = new int[len];
            for(int i=0;i<len;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run(arr, n));


        }
    }


    //O(n)
    static String run(int[] arr, int n) {
        if (arr.length == 0) {
            return "-1";
        }

        int start = 0, end = 0, sum = 0;
        while (start < arr.length && end < arr.length) {

            if (arr[start] > n) {
                sum = 0;
                start++;
                end++;
                continue;
            }

            if (arr[end] > n) {
                sum = 0;
                start = end + 1;
                end++;
                continue;
            }

            if (sum + arr[end] > n) {
                sum -= arr[start];
                start++;
                continue;
            }

            sum += arr[end];

            if (sum == n) {
                return (start + 1) + " " + (end + 1);
            }

            end++;
        }

        return "-1";

    }

    @Test
    public void TestRun() {
        int[] notfound = {1, 2, 3};
        String result = run(notfound, 9);
        Assert.assertEquals("-1", result);

        int[] found = {1, 2, 5, 3};
        String fresult = run(found, 10);
        Assert.assertEquals("2 4", fresult);

        int[] found2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String fresult2 = run(found2, 15);
        Assert.assertEquals("1 5", fresult2);

        Assert.assertEquals("2 2", run(found2, 2));

        int[] found3 = {1};

        Assert.assertEquals("-1", run(found3, 2));
    }
}
