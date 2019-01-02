package com.g4g.medium;

import java.util.Scanner;


//Find Missing And Repeating
//Show Topic Tags

/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
// Given an unsorted array of size n. Array elements are in range from 1 to n. One number 'A' from set {1, 2, …n} is missing and one number 'B' occurs twice in array. Find these two numbers.
//Note: If you find multiple answers then print the Smallest number found.
//
//        Input:
//
//        The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
//        The first line of each test case contains a single integer N denoting the size of array.
//        The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//
//        Output:
//
//        Print B, the repeating number followed by A which is missing in a single line.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 40
//        1 ≤ N ≤ 100
//        1 ≤ A[i] ≤ N
//
//
//        Example:
//
//        Input
//        2
//        2
//        2 2
//        3
//        1 3 3
//        Output
//        2 1
//        3 2
//******************************************************************************************************************
//Companies: MAQ-Software
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/find-missing-and-repeating/0/?ref=self
//******************************************************************************************************************

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
           int l = scan.nextInt();

           int[] arr = new int[l];

           for(int i =0;i<l;i++){
               arr[i] = scan.nextInt();
           }

           run(arr);
        }
    }


    static void run(int[] arr) {

        //arr.length + 1 as array has zero-based index
        int[] count = new int[arr.length + 1];

        //get all counts
        for(int i: arr){
            count[i] += 1;
        }

        //get the reapeated and the missing one by full scan
        //safe to be 0 as A[i] >= 1
        //missing now is the one which has "0"
        //repeated is the one that came up multiple times, count is more than once > 1
        int missing = 0, repeated = 0;

        for(int i =0;i<count.length;i++){
            if(missing == 0 && count[i] == 0)
                missing = i;

            if(repeated == 0 && count[i] > 1)
                repeated = i;

            if(missing > 0 && repeated > 0)
                break;
        }

        //repeated first then missing
        System.out.println(repeated + " " + missing);

    }
}
