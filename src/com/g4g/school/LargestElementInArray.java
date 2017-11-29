package com.g4g.school;

import java.util.Scanner;


//Largest Element In Array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an array, find the largest element in it.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n , the no of elements in the array. Then next line contains n integers of the array.
//
//        Output:
//        Print the maximum element in the array.
//
//        Constraints:
//        1<=T<=100
//        1<=n<=100
//        1<=a[i]<=1000
//
//        Example:
//        Input:
//        2
//        5
//        10 324 45 90 9808
//        7
//        1 2 0 3 2 4 5
//
//        Output :
//        9808
//        5
//

//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/largest-element-in-array/0/?ref=self
//******************************************************************************************************************

public class LargestElementInArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

           //notice n is greater than or equal to 1 in the question's constraints section => 1<=n<=100
           int[] arr = new int[scan.nextInt()];

           for(int i =0;i<arr.length;i++){
               arr[i] = scan.nextInt();
           }

           //print result
           System.out.println(run(arr));
        }
    }


    static int run(int[] arr) {

        //as long as 1<=n<=1000 there is at least one elem in array
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] > max)
                max = arr[i];
        }

        return max;

    }
}
