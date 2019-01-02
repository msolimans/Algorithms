package com.g4g.school;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Scanner;


//Row with minimum number of 1's
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Determine the row index with minimum number of ones. The given 2D matrix has only zeroes and ones and also the matrix is sorted row wise . If two or more rows have same number of 1's than print the row with smallest index.
//
//        Note: If there is no '1' in any of the row than print '-1'.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of two integer n and m. The next line consists of n*m spaced integers.
//
//        Output:
//        Print the index of the row with minimum number of 1's.
//
//        Constraints:
//        1<=T<=200
//        1<=n,m<=100
//
//        Example:
//        Input:
//        2
//        3 3
//        0 0 0 0 0 0 0 0 0
//        4 4
//        0 0 0 1 0 1 1 1 0 0 1 1 0 0 1 1
//
//        Output:
//        -1
//        0
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s/0
//******************************************************************************************************************


public class RowWithMinimumNumberOf1s {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int rows = scan.nextInt();
            int cols = scan.nextInt();

            int[] arr = new int[rows];

            for(int i =0;i<rows;i++){
                int ones = 0;
                for(int j=0;j<cols;j++){
                    if(scan.nextInt() == 1)
                        ones++;
                }
                arr[i] = ones;
            }


            //calculate the min number of 1s
            int min = cols+1;
            int minIndx = -1;
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= 1 && arr[i] < min){
                    min = arr[i];
                    minIndx = i;
                }
            }

            System.out.println(minIndx);

        }
    }
}
