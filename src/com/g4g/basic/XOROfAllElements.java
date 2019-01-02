package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;


//XOR of all elements
//Show Topic Tags

/**
 * Bitwise Manipulation
 */

/*Description*/
//******************************************************************************************************************
//Given an array A[] having n positive elements. The task to create another array B[] such as B[i] is XOR of all elements of array A[] except A[i].

//Examples:
//
//        Input : A[] = {2, 1, 5, 9}
//        Output : B[] = {13, 14, 10, 6}
//
//        Input : A[] = {2, 1, 3, 6}
//        Output : B[] = {4, 7, 5, 0}
//
//
//        Input:
//        The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array (B[]).
//
//        Output:
//        For each test case in a new line print the space separated values of the new array (B[]).
//
//        Constraints:
//        1<=T<=100
//        1<=N<=100
//        1<=A[]<=100
//
//        Example:
//        2
//        4
//        2 1 5 9
//        4
//        2 1 3 6
//        Output:
//        13 14 10 6
//        4 7 5 0
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/stickler-theif/0/?ref=self
//******************************************************************************************************************

public class XOROfAllElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scan.nextInt()];

            for(int i =0;i<arr.length;i++)
                arr[i] = scan.nextInt();

            System.out.println(Arrays.toString(run2(arr)).replaceAll("[\\[\\]\\,]", "").trim());
        }
    }

    //brute force algorithm O(n^2), better solution in run2()
    static int[] run(int[] arr) {
        //is to loop through all array items and inside each item XOR all items except current item
        int[] result = new int[arr.length];

        for(int i =0;i<arr.length;i++){

            for(int j = 0;j<arr.length;j++){
                if(j != i)
                    result[i] ^= arr[j];
            }
        }

        return  result;

    }

    //O(n), no auxiliary space required
    static int[] run2(int[] arr){
        //XOR all of them O(n)
        int sum = 0;
        for(int i:arr)
            sum ^= i;


        //loop through and exclude only the current item by making XOR again, it will cancel the current item as XORed same item = 0 - e.g. 4 ^ 4 = 0
        for(int i =0;i<arr.length;i++){
            arr[i] = sum ^ arr[i];
        }

        return  arr;
    }
}
