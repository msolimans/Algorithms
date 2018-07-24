package com.g4g.easy;

import java.util.Scanner;


//Count Substrings
//Show Topic Tags

/**
 * String
 */

/*Description*/
//******************************************************************************************************************
// Given a binary string, count number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
//
//Input:
//        The first line contains T denoting the number of testcases. Then follows description of testcases.
//        Each case contains a string containing 0's and 1's.
//
//
//        Output:
//        For each test case, output a single line denoting number of substrings possible.
//
//        Constraints:
//        1<=T<=100
//        1<=Lenght of String<=100
//
//
//        Example:
//        Input:
//        1
//        10101
//
//        Output:
//        3
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/count-substrings/0/
//******************************************************************************************************************

public class CountOfSubstrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            System.out.println(run(scan.next()));
        }
    }


    static int run(String str) {
        int n = 0;

        //count all ones in the string
       for(int i =0;i<str.length();i++){
           if(str.charAt(i) == '1')
               n++;
       }

       //suppose we have 1001001
        //we have 3 ones here which will be represented as
        //1001001
        //1001
        //1001001           => 2
        //   1001           => 1
        //all = 2 + 1 (where we had 3 ones) SUM(3-1) = SUM(2)

        //Another example
        //1001001001 (4 ones)
        //1001
        //1001001
        //1001001001         => 3
        //   1001
        //   1001001         => 2
        //      1001         => 1
        //all = 3 + 2 + 1 (where we had 4 ones) SUM(4-1) = SUM(3)
       return sum(n-1);
    }


    static int sum(int n){

        if(n == -1)
            return  0;

        if(n == 1 || n == 0)
            return 1;

        return n + sum(n-1);
    }
}
