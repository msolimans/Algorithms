package com.g4g.Easy;

import java.util.Arrays;
import java.util.Scanner;


//Sort an array of 0s, 1s and 2s
//Show Topic Tags

/**
 * Arrays, Sorting, Counting Sort
 */

/*Description*/
//******************************************************************************************************************
//Write a program to sort an array of 0's,1's and 2's in ascending order.

//Input:
//        The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.
//
//        Output:
//        Print the sorted array of 0's, 1's and 2's.
//
//        Constraints:
//
//        1 <= T <= 100
//        1 <= N <= 100
//        0 <= arr[i] <= 2
//
//        Example:
//
//        Input :
//
//        2
//        5
//        0 2 1 2 0
//        3
//        0 1 0
//
//
//        Output:
//
//        0 0 1 2 2
//        0 0 1
//******************************************************************************************************************
//Companies:  Ola-Cabs, Morgan-Stanley, MAQ-Software, Hike, Amazon, Adobe, Yatra, Walmart, SAP-Labs, Paytm
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
//******************************************************************************************************************

public class SortAnArrayOf0s1sAnd2s {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int len = scan.nextInt();

            int[] arr = new int[len];

            for(int i =0;i<len;i++)
                arr[i] = scan.nextInt();

            System.out.println(
                    Arrays.toString(
                        run(arr)
                    ).replaceAll("[\\,\\[\\]]", "").trim()
            );
        }
    }

    static int[] run(int[] arr){
        //count 0s, 1s and 2s in an array of static size
        int[] counts = new int[3];
        for(int i =0;i<arr.length;i++){
            counts[arr[i]]++;
        }

        //print 0s
        int i = 0;
        while(counts[0]-- > 0){
            arr[i++] = 0;
        }

        //print 1s
        while(counts[1]-- > 0){
            arr[i++] = 1;
        }

        //print 2s
        while(counts[2]-- > 0){
            arr[i++] = 2;
        }

        return arr;
    }

}
