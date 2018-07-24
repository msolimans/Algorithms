package com.g4g.easy;

import java.util.Scanner;


//Minimum element in a sorted and rotated array
//Show Topic Tags

/**
 * Arrays, Binary Search O(logn)
 */

/*Description*/
//******************************************************************************************************************
//A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

//Expected Time Complexity: O(Log n)
//
//        Input:
//
//        The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.
//        The second line of each test case contains N space separated integers denoting array elements.
//
//        Output:
//        Corresponding to each test case, in a new line, print the minimum element in the array.
//
//        Constraints:
//
//        1 ≤ T ≤ 200
//        1 ≤ N ≤ 500
//        1 ≤ A[i] ≤ 1000
//
//        Example:
//
//        Input
//        1
//        5
//        4 5 1 2 3
//
//        Output
//        1
//******************************************************************************************************************
//Companies: Times Internet, Snapdeal, Morgan-Stanely, Microsoft, Amazon, Adobe
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array/0
//******************************************************************************************************************

public class MinimumElementInSortedAndRotatedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[]arr = new int[scan.nextInt()];

            for(int i=0;i<arr.length;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run(arr));
        }
    }

    //Algorithm Analysis
    //simple, get the mid point and check if the element at mid is less than the one to the left and the one to the right then it is our target
    //otherwise, check which one is smaller point, if the element at start is less than the one at end point, move and shrink your search space to the left side
    // It simply eliminates the problem in each iteration to its half thus O(logn)
    static int run(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while(s < e){
            //get mid
            int mid = (s + e) / 2;

            //smaller than both neighbors (left/right)
            if((mid == arr.length - 1 || arr[mid] < arr[mid+1]) && (mid == 0 || arr[mid] < arr[mid - 1]))
                return arr[mid];

            //To avoid this test case 5 4 3 2 1 0 7 8
            //get the minimal element from right side
            //each point might be a rotation point so we have to check each one (@start, @end, @mid) and get the min of each one and compare
            int minE = arr[e];
            int minS = arr[s];

            if(s-1 >= 0 && arr[s - 1] < minS)
                minS = arr[s-1];

            if(s+1 <= arr.length - 1 && arr[s+1] < minS)
                minS = arr[s+1];

            if(e-1 >= 0 && arr[e - 1] < minE)
                minE = arr[e-1];

            if(e+1 <= arr.length - 1 && arr[e+1] < minE)
                minE = arr[e+1];


            int minRight = mid == arr.length - 1? minE:   arr[mid+1] < minE? arr[mid+1]: minE;
            //get the minimal one from left side
            int minLeft = mid == 0 ? minS:   arr[mid-1]<minS? arr[mid-1]: minS;

            //compare the left and right side now and move or shrink to left or to right
            if(minLeft < minRight)
                e = mid - 1;
            else
                s = mid + 1;
        }

        //array is empty
        return  arr[s];


    }
}
