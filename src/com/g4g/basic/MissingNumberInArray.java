package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;


//Missing number in array
//Show Topic Tags

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
//Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N.
//        The second line of each test case contains N-1 input C[i],numbers in array.
//
//        Output:
//
//        Print the missing number in array.
//
//        Constraints:
//
//        1 ≤ T ≤ 200
//        1 ≤ N ≤ 1000
//        1 ≤ C[i] ≤ 1000
//
//        Example:
//
//        Input
//        2
//        5
//        1 2 3 5
//        10
//        1 2 3 4 5 6 7 8 10
//
//        Output
//        4
//        9

//******************************************************************************************************************
//Companies: Payu, Ola-Cabs, Microsoft, Intuit, Cisco, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/missing-number-in-array/0
//******************************************************************************************************************

public class MissingNumberInArray {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {

            int n = scan.nextInt();
            int[] nums = new int[n+1];

            //notice the index here as it starts from 1 to n-1 (the number entered in the example in the question was 5 however we have only 4 elements (one missing)
            for(int i =1;i<n;i++){
                //assign the value as 1 (to indicate it exists) otherwise it is 0 (not exist or mentioned in the input)
                nums[scan.nextInt()] = 1;
            }

           //loop through array from 1 to n and check which is missing
           for(int i=1;i<=n;i++){
                if(nums[i] == 0)
                    System.out.println(i);
           }
        }
    }



}
