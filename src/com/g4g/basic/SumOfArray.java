package com.g4g.basic;

import java.util.Scanner;


//Sum of array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array find sum of it.

//Input:
//        First line contains an integer, the number of test cases 'T' Each test case should contain an integer, size of array 'N' in the first line. In the second line Input the integer elements of the array in a single line separated by space.
//
//
//        Output:
//        Print the sum in seperate line.
//
//
//        Constraints:
//
//        1 <= T <= 30
//
//        1 <= N <= 100
//
//        1 <= Arr[i] <= 100
//
//
//
//        Example:
//
//        Input
//        1
//        4
//        1 2 3 4
//
//        Output:
//        10
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link:https://practice.geeksforgeeks.org/problems/sum-of-array/0
//******************************************************************************************************************

public class SumOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int len = scan.nextInt();
            int[] arr = new int[len];
            for(int i =0;i<len;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run(arr));
        }
    }


    static int run(int[] arr) {
        int result = 0;
        for(int i : arr)
            result += i;

        return result;
    }


}
