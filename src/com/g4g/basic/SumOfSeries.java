package com.g4g.basic;

import java.util.Scanner;

//Sum of Series
//Show Topic Tags

/**
 * Arrays, Maths
 */

/*Description*/
//******************************************************************************************************************
// Write a program to find the sum of the given series 1+2+3+ . . . . . .(N terms)

//Input:
//        First line contains an integer, the number of test cases 'T' Each test case should contain a positive integer N.
//
//
//        Output:
//        Print the sum in a separate line.
//
//
//        Constraints:
//        1<=T<=30
//        1<=N<=100
//
//
//        Example:
//        Input:
//        1
//        1
//
//        Output:
//        1
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-series/0/
//******************************************************************************************************************

public class SumOfSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();

            System.out.println(run(n));
        }
    }

    //recursive version
    static int run(int n) {
        if(n == 1)
            return  1;

        return n + run(n -1);
    }

    static int run1(int n){
        int s = 0;

        for(int i=1;i<=n;i++){
            s += i;
        }
        return  s;
    }
}
