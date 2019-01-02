package com.g4g.easy;

import java.util.Scanner;

//Maximum sum of subarray less than or equal to x
//Show Topic Tags

/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
// Given an array of integers and a number x. We have to find sum of subarray having maximum sum less than or equal to given value of x.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of an integer n. Next line of each test case consists of n spaced integers.The next line consists of an integer x.
//
//        Output:
//        Print the maximum sum of any subarray that is less than or equal to x.
//
//        Constraints:
//        1<=T<=100
//        1<=n<=1000
//        1<=a[i],x<=100000
//
//        Example:
//        Input:
//        2
//        5
//        1 2 3 4 5
//        11
//        5
//        2 4 6 8 10
//        7
//
//        Output:
//        10
//        6
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link:    http://practice.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x/0
//******************************************************************************************************************

public class MaximumSumOfSubArrayLessThanOrEqualToX {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //scan array len
            int len = scan.nextInt();
            //initialize array
            int[] arr = new int[len];

            //fill array
            for(int i =0;i<len;i++)
                arr[i] = scan.nextInt();

            //read target number n
            int n = scan.nextInt();

            //call func
            System.out.println(run(arr, n));
        }
    }


    //brute force algorithm o(n^2)
    static int run(int[] arr, int n) {

        int current = 0, max = 0;
        //loop through array's elements
        for(int i =0;i<arr.length;i++){
            //skip the element if it is greater than n
            if(arr[i] > n)
                continue;
            //current keeps the current subarray sum
            current = arr[i];

            //loop through all array's elements starting from next current's element.
            for(int j = i+1;j<arr.length;j++){
                if(current + arr[j] <= n)
                    current += arr[j];
                else
                    //break once we exceeded the target number n
                    break;
            }

            //keep always max updated
            if(current > max)
                max = current;
        }

        return  max;
    }


}
