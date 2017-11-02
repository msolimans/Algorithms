package com.g4g.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


//Problem Title
//Show Topic Tags

/**
 * Arrays, Maths, Sorting, Merge Sort
 */

/*Description*/
//******************************************************************************************************************
//You have to merge the two sorted arrays into one sorted array (in non-increasing order)

//Input:
//
//        First line contains an integer T, denoting the number of test cases.
//        First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays.
//        Second line of each test case contains X space separated integers, denoting the first sorted array P.
//        Third line of each test case contains Y space separated integers, denoting the second array Q.
//
//
//        Output:
//
//        For each test case, print (X + Y) space separated integer representing the merged array.
//
//
//        Constraints:
//
//        1 <= T <= 100
//        1 <= X, Y <= 5*104
//        0 <= Pi, Qi <= 109
//
//
//        Example:
//
//        INPUT:
//
//        1
//        4 5
//        7 5 3 1
//        9 8 6 2 0
//
//        OUTPUT:
//
//        9 8 7 6 5 3 2 1 0


//This problem is not well descriptive as the input arrays might come in asc. or desc. orders and you have to implement both I guess
//Another thing, the output should be printed without parenthesis nor commas
//******************************************************************************************************************
//Companies: Quickr, Microsoft, LinkedIn, Juniper, Goldman-Sachs, Brocade, Amdocs, Zoho, Synopsys, Snapdeal
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0
//******************************************************************************************************************

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //length of first array
            int x = scan.nextInt();
            //length of second array
            int y = scan.nextInt();

            int[] arr1 = new int[x];
            int[] arr2 = new int[y];

            for(int i =0;i<x;i++) {
                arr1[i] = scan.nextInt();
            }

            for(int i=0;i<y;i++){
                arr2[i] = scan.nextInt();
            }

            System.out.println(
                    Arrays.toString(
                    run(arr1, arr2)
                    ).replaceAll("[\\[\\]\\,]", "").trim()
            );
        }
    }

    static int[] run(int[] arr1, int[] arr2){
        //choose which algorithm
        if(
                (arr1.length > 1 && arr1[0] > arr1[arr1.length - 1]) ||
                (arr2.length > 1 && arr2[0] > arr2[arr2.length - 1]) )
            //desc ordered
            return runDescSorted(arr1, arr2);


        return runAscSorted(arr1,arr2);

    }


    static int[] runAscSorted(int[] arr1, int[] arr2){
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        int[] result = new int[arr1.length + arr2.length];
        int index = 0;


        //make sure we are still in boundaries of arrays
        while(i1 >= 0 && i2 >= 0){

            //if item in arr1 is bigger move it and move the cursor one more step
            if(arr1[i1] >= arr2[i2]){
                result[index++] = arr1[i1--];
            }else{
                //if item in arr2 is bigger copy it to the results and move the cursor one more step
                result[index++] = arr2[i2--];
            }
        }

        //add the rest in arr1 from arr1 to the results
        while(i1 >= 0){
            result[index++] = arr1[i1--];
        }

        //add the rest from arr2 if any to the results
        while(i2 >= 0){
            result[index++] = arr2[i2--];
        }

        return  result;
    }

    static int[] runDescSorted(int[] arr1, int[] arr2) {

        int i1 = 0;
        int i2 = 0;
        int[] result = new int[arr1.length + arr2.length];
        int index = 0 ;


        //make sure we are still in boundaries of arrays
        while(i1 < arr1.length && i2 < arr2.length){

            //if item in arr1 is bigger move it and move the cursor one more step
            if(arr1[i1] >= arr2[i2]){
                result[index++] = arr1[i1++];
            }else{
                //if item in arr2 is bigger copy it to the results and move the cursor one more step
                result[index++] = arr2[i2++];
            }
        }

        //add the rest in arr1 from arr1 to the results
        while(i1 < arr1.length){
            result[index++] = arr1[i1++];
        }

        //add the rest from arr2 if any to the results
        while(i2 < arr2.length){
            result[index++] = arr2[i2++];
        }

        return  result;

    }
}
