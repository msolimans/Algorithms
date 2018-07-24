package com.g4g.basic;

import java.util.Scanner;


//Number of occurrence
//Show Topic Tags

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
// Given a sorted array C[] and a number X, write a function that counts the occurrences of X in C[].
//
//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N and X, N is the size of array.
//        The second line of each test case contains N input C[i].
//
//        Output:
//
//        Print the counts the occurrence of X, if zero then print -1.
//
//        Constraints:
//
//        1 ≤ T ≤ 100
//        1 ≤ N ≤ 300
//        1 ≤ C[i] ≤ 500
//
//        Example:
//
//        Input:
//        2
//        7 2
//        1 1 2 2 2 2 3
//        7 4
//        1 1 2 2 2 2 3
//
//        Output:
//        4
//        -1
//
//        Explanation:
//        In first test case, 2 occurs 4 times in 1 1 2 2 2 2 3
//        In second test case, 4 is not present in 1 1 2 2 2 2 3
//******************************************************************************************************************
//Companies: Amazon, MakeMyTrip
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/stickler-theif/0/?ref=self
//******************************************************************************************************************

public class NumberOfOccurrence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int l = scan.nextInt();
            int n =scan.nextInt();
            int[] arr = new int[l];
            for(int i =0;i<l;i++)
                arr[i] = scan.nextInt();

            System.out.println(binary_search(arr, n));

        }
    }

    //O(log n)
    static int binary_search(int[] arr, int n){
        //find the elem first.
        int start = 0;
        int end = arr.length - 1;



        while(start <= end) {
            int mid = ( end + start ) / 2;
            if (arr[mid] == n) {
                //found, our meat code here
                //go all way to the left until you find different number
                int i = mid;
                int count  = 1;
                while(--i>=0 && arr[i] == n)
                    count++;

                //go all way to the right unril you find different number
                i = mid;
                while(++i <= arr.length-1 && arr[i] == n)
                    count++;


                return count;


            } else if (arr[mid] > n) {
                //go left
                end = mid - 1;
            } else {
                //go right
                start = mid + 1;
            }

        }

        return -1;
    }

    //O(n)
    static int linear_search(int[] arr, int n) {

        int count = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == n)
                count ++;

            if(arr[i] != n && count > 0)
                break;
        }

        return count == 0? -1: count ;
    }


}
