package com.g4g.basic;

import java.util.Scanner;


//Value equal to index value
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array, we need to find that element whose value is equal to that of its index value.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N,N is the size of array.
//        The second line of each test case contains N input A[].
//
//        Output:
//
//        Print that element whose value is equal to index value. Print "Not Found" when index value does not match with value.
//        Note: There can be more than one element in the array which have same value as their index. You need to print every such element's index separated by a single space. Follows 1-based indexing of the array.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 30
//        1 ≤ N ≤ 50
//        1 ≤ A[i] ≤ 1000
//
//        Example:
//
//        Input
//        2
//        5
//        15 2 45 12 7
//        1
//        1
//
//        Output
//        2
//        1
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/value-equal-to-index-value/0
//******************************************************************************************************************

public class ValueEqualToIndexValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int l = scan.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1;i<=l;i++){
                if(scan.nextInt() == i)
                    stringBuilder.append(i + " ");
            }

            String s = stringBuilder.toString().trim();

            System.out.println(s.isEmpty()? "Not Found": s);
        }
    }


}
