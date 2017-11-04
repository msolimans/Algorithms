package com.g4g.Easy;

import java.util.PriorityQueue;
import java.util.Scanner;


//Floor In a Sorted Array
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a sorted array having no duplicates, arr[] and a value, x, find floor of x in given array. Floor of x is the largest element in arr[] such that the element is smaller than or equal to x. If floor exists, then return index of it, else return -1.

//Examples:
//
//        Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 5
//        Output : 1
//        1 is index of 2. 2 is the largest element in arr[]
//        smaller than 5.
//
//        Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 20
//        Output : 6
//        19 is the largest element in arr[] smaller than 20.
//
//        Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 0
//        Output : -1
//        Since floor doesn't exist, output is -1.
//        Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N and x, N is the size of array.
//        The second line of each test case contains N array elements.
//
//        Output:
//
//        Print index of floor of x if it exists, else print -1
//
//        Constraints:
//
//        1 ≤ T ≤ 500
//        1 ≤ N ≤ 1000
//        0 ≤ X ≤ 1000
//        1 ≤ arr[i] ≤ 10000
//
//        Example:
//
//        Input:
//        3
//        7 0
//        1 2 8 10 11 12 19
//        7 5
//        1 2 8 10 11 12 19
//        7 10
//        1 2 8 10 11 12 19
//
//        Output:
//        -1
//        1
//        3
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array/0
//******************************************************************************************************************

public class FloorInSortedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int len = scan.nextInt();
            int n= scan.nextInt();

            int[] arr = new int[len];
            for(int i =0;i<len;i++){
                arr[i] = scan.nextInt();
            }
            System.out.println(run1( arr, n));
        }
    }

    //brute force, O(n), check better solution down
    static int run(int[] arr, int n){
        int max = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] <= n && arr[i] > max)
                max = i;
            else if (arr[i] > n)
                break;
        }

        return max;
    }

    //binary search solution O(logn)
    //As long as the array is sorted
    static int run1(int[] arr, int n) {
        int s=0,e=arr.length - 1;
        int max = -1;

        while(s <= e){

            int mid = (s+e)/2;


            if(arr[mid] < n) {
                max = mid;
            }if(arr[mid] == n) {
                max = mid;
                break;
            }

            if(arr[mid] > n)
                e = mid - 1;
            else {
                s = mid + 1;
            }

        }

        return max;

    }
}
