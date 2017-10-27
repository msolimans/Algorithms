package com.g4g.basic;

import java.util.Scanner;

//Problem Title
//Show Topic Tags




/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
//          Index of first 1 in a sorted array of 0’s and 1’s
//
//                Given a sorted array consisting 0’s and 1’s. The task is to find the index of first ‘1’ in the sorted array.
//
//                Input:
//                The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated 0 and 1.
//
//                Output:
//                For each test case, in a new line print the index of first 1. If 1 is not present in the array then print “-1”.
//
//                Constraints:
//                1<=T<=300
//                1<=N<=105
//                0<=A[i]<=1
//
//                Example:
//                Input:
//                2
//                10
//                0 0 0 0 0 0 1 1 1 1
//                4
//                0 0 0 0
//                Output:
//                6
//                -1
//
//                ** For More Input/Output Examples Use 'Expected Output' option **
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************


public class IndexOfFirst1InSortedArray {

    public static  void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        int length;
        int indx;


        while(T-- > 0){
            length = scan.nextInt();
            indx = -1;

            for(int i=0;i<length;i++)
            {
                //no need to use arrays to save memory, however you can still use it but you should only initialize one array for all of them instead of initialize for 300 test cases
                if( scan.nextInt() == 1 && indx == -1) {
                    indx = i;
                }
            }

            System.out.println(indx);
        }


    }


}
