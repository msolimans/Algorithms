package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;


//Maximum product of two numbers
//Show Topic Tags

/**
 * Array, Sorting
 */

/*Description*/
//******************************************************************************************************************
// Given an array with all elements greater than or equal to zero. Return the maximum product of two numbers possible.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N, N is size of array.
//        The second line of each test case contains N input A[i].
//
//        Output:
//
//        Print the maximum product of two numbers possible.
//
//        Constraints:
//
//        1 ≤ T ≤ 20
//        2 ≤ N ≤ 50
//        0 ≤ A[i] ≤ 1000
//
//        Example:
//
//        Input
//        1
//        5
//        1 100 42 4 23
//
//        Output
//        4200
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link:  http://practice.geeksforgeeks.org/problems/maximum-product-of-two-numbers/0
//******************************************************************************************************************

public class MaximumProductOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int l = scan.nextInt();
            int[] arr = new int[l];

            for(int i =0;i<l;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run1(arr));
        }
    }

    static int run1(int[] arr) {
        //here is an O(n), better than sorting
        //hold 2 vars of the largest numbers in the collecion
        int m1 , m2;
        if(arr[0] > arr[1]){
            m1 = arr[0];
            m2 = arr[1];
        }else{
            m1 = arr[1];
            m2 = arr[0];
        }

        //now we sure m1 is greater than m2

        for(int i = 2;i<arr.length;i++){
            if(arr[i] > m1)
            {
                m2 = m1;
                m1 = arr[i];
            }
            else if(arr[i] > m2)
                m2 = arr[i];
        }

        return m1 * m2;
    }


    static int run(int[] arr) {
        //best algorithm will be O(nlogn)
        //sort first then bring the last 2
        Arrays.sort(arr);
        return arr[arr.length - 1] * arr[arr.length - 2];


    }
}
