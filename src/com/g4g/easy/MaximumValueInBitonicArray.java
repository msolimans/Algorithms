package com.g4g.easy;

import java.util.Scanner;


//Maximum value in a bitonic array
//Show Topic Tags

/**
 * Array, Searching, Binary Search, Greedy Algorithm
 */

/*Description*/
//******************************************************************************************************************
//Given an array of elements which is first increasing and then decreasing, find the maximum element in the array.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N, the size of array
//        The second line of each test case contains N integers which are the array elements.
//
//        Output:
//
//        Print the maximum element in the array.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 50
//        3 ≤ N ≤ 100
//        1 ≤ a[i] ≤ 100000
//
//
//        Example:
//
//        Input
//        2
//        9
//        1 15 25 45 42 21 17 12 11
//        5
//        1 45 47 50 5
//
//        Output
//        45
//        50
//

//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array/0
//******************************************************************************************************************

public class MaximumValueInBitonicArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int[] arr = new int[scan.nextInt()];
            for(int i =0;i<arr.length;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run1(arr));
        }
    }


    //O(n) algorithm, however we could do better using greedy algorithm and binary search
    static int run(int[] arr) {

        for(int i = 1;i<arr.length;i++){
            if(arr[i] < arr[i-1])
                return arr[i - 1];
        }

        return arr[0];
    }

    //Depends on binary search and greed algorithm .. O(logn)
    static  int run1(int[] arr){
        int s = 0;
        int e = arr.length - 1;

        while(s < e){
            int mid = (s + e) / 2;

            //stop condition (find an item which is bigger than left/right items)
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];

            //move to the direction that has a bigger item
            if(arr[mid + 1] > arr[mid])//move right
                s = mid + 1;
            else
                e = mid - 1;
        }

        return arr[s];
    }
}
