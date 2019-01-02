package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;


//Reverse An Array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an array, print reverse of it.
//
//Input:
//
//        First line contains an integer, the number of test cases 'T' Each test case should contain an integer, size of array 'N' in the first line. In the second line Input the integer elements of the array in a single line separated by space.
//
//        Output:
//
//        Print the array in reverse order in a single line separated by space.Each array is to be printed in separate line.
//
//        Constraints:
//
//        1 <= T <= 100
//
//        1 <= N <=100
//
//        0 <= Arr[i] <= 100
//
//        Example:
//
//        Input
//        1
//        4
//        1 2 3 4
//
//        Output:
//        4 3 2 1
//******************************************************************************************************************
//Companies: Moonfrog-Labs, Infosys
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/reverse-an-array/0/?ref=self
//******************************************************************************************************************

public class ReverseAnArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] arr = new int[n];

            for(int i =0; i<n;i++)
                arr[i] = scan.nextInt();

           System.out.println(Arrays.toString(run(arr)).replaceAll("[\\[\\]\\,]", "").trim());
        }
    }


    static int[] run(int[] arr) {
        int s=0,e = arr.length -1, t = 0 ;
        while(s <= e){
            t = arr[s];
            arr[s++] = arr[e];
            arr[e--] = t;
        }

        return arr;
    }
}
