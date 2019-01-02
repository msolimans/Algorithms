package com.g4g.Easy;

import java.util.HashSet;
import java.util.Scanner;


//Pairs with Difference less than K
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of N integers, the task is to find all pairs with difference less than K.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case
//        contains two integers N & K and the second line contains N space separated array elements.
//
//        Output:
//        For each test case, print the count of required pairs in new line.
//
//        Constraints:
//        1<=T<=100
//        2<=N<=104
//        0<=K<=103
//        1<=A[i]<=105
//
//        Example:
//        Input:
//        2
//        4 3
//        1 10 4 2
//        3 5
//        2 3 4
//
//        Output:
//        2
//        3
//
//        Explanation:
//
//        Input : a[] = {1, 10, 4, 2}
//        K = 3
//        Output : 2
//        We can make only two pairs with difference less than 3.
//        (1, 2) and (4, 2)
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/pairs-with-difference-less-than-k/0/?ref=self
//******************************************************************************************************************

public class PairsWithDifferenceLessThanK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scan.nextInt()];
            int k = scan.nextInt();
            for(int i=0;i<arr.length;i++)
                arr[i] = scan.nextInt();

            System.out.println(run(arr, k));
        }
    }

    //brute force algorithm
    static int run(int[] arr, int k) {
        int c = 0;

        for(int i =0;i<arr.length-1;i++)
            for(int j = i+1;j<arr.length;j++)
                if(Math.abs(arr[i] - arr[j])< k)
                    c++;

        return  c;

    }

    //how many pairs in arr that have difference less than k
    static int run1(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i: arr){
            Math.abs(k - i)
        }


    }
}
