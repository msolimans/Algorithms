package com.g4g.easy;

import java.util.Arrays;
import java.util.Scanner;


//Move all zeroes to end of array
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
// Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is
// {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.

//Input:
//        The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.
//
//        Output:
//        Print the array after shifting all 0's at the end.​
//
//        Note: An extra space is expected at the end after output of every test case
//
//        Constraints:
//        1 <= T <=100
//        1 <= N <=1000
//        0 <= a[i] <=100
//
//        Example:
//        Input:
//        1
//        5
//        3 5 0 0 4
//
//        Output:
//        3 5 4 0 0
//******************************************************************************************************************
//Companies: Paytm, Bloomberg, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array/0/?ref=self
//******************************************************************************************************************

public class MoveAllZeroesToEndOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int l = scan.nextInt();
            int[] arr = new int[l];
            for (int i = 0; i < l; i++) {
                arr[i] = scan.nextInt();
            }

            run(arr);
        }
    }


    static void run(int[] arr) {
        int indx = arr.length - 1;
        while (indx >= 0) {
            if (arr[indx] == 0) {
                indx--;
            } else
                break;
        }

        for (int i = 0; i < indx; i++) {
            //if item is zero, skip all zeros for the first swap only
            if (arr[i] == 0) {
                //shift all elements from index to that position
                //shift all elements starting from @i to @indx
                int zeros = 0, j = i + 1;
                //count how many zeros coming after current item
                if (arr[j] == 0) {

                    for (; j <= indx; j++)
                        if (arr[j] == 0)
                            zeros++;
                        else
                            break;
                }

                //continue looping after zeros
                for (; j <= indx; j++) {

                    //swap the first occurrence of non-zero elem with the original one
                    arr[j - (zeros + 1)] = arr[j];
                    //no skipping anymore (as it will affect on other zeros coming after)
                    zeros = 0;

                }

                //set current item @ index = 0
                arr[indx] = 0;

                indx--;
            }
        }


        System.out.println(Arrays.toString(arr).replaceAll("[\\,\\[\\]]", ""));
    }


    //better in performance however g4g did not accept it cause of items positions (idiot :))
    static void run_better(int[] arr) {
        int indx = arr.length - 1;
        while (indx >= 0) {
            if (arr[indx] == 0) {
                indx--;
            } else
                break;
        }

        int temp = 0;

        for (int i = 0; i < indx; i++) {
            if (arr[i] == 0) {
                //swap
                arr[i] = arr[indx];
                arr[indx--] = 0;
            }
        }


        System.out.println(Arrays.toString(arr).replaceAll("[\\,\\[\\]]", ""));
    }
}
