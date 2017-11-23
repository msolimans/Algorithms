package com.g4g.school;

import java.util.Scanner;


//Sum of array elements
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array, find sum of elements in it.

//Input:
//
//        First line contains an integer denoting the test cases 'T'. Every test case contains an integer value depicting size of array 'N' and N integer elements are to be inserted in the next line with spaces between them.
//
//        Output:
//
//        Print the sum of all elements of the array in separate line.
//
//        Constraints:
//
//        1 <= T <= 100
//
//        1 <= N<= 100
//
//        1 <= Arr[i] <= 100
//
//        Example:
//
//        Input:
//        2
//        3
//        3 2 1
//        4
//        1 2 3 4
//
//        Output:
//        6
//        10
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-array-elements/0
//******************************************************************************************************************

public class SumOfArrayElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<arr.length;i++)
                arr[i] = scan.nextInt();

            System.out.println(run(arr));
        }
    }

    //cast or change return type based on problem's needs
    static int run(int[] arr) {
        int sum = 0;
        for(int i =0;i<arr.length;i++)
            sum += arr[i];

        return sum;
    }
}
