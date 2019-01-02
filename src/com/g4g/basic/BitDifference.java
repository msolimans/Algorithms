package com.g4g.basic;

import java.util.Scanner;


//Problem Title
//Show Topic Tags

/**
 * Bit Manipulation
 */

/*Description*/
//******************************************************************************************************************
//You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.
//
//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is a and b.
//
//        Output:
//
//        Print the number of bits needed to be flipped.
//
//        Constraints:
//
//        1 ≤ T ≤ 100
//        1 ≤ a,b ≤ 1000
//
//        Example:
//
//        Example:
//        Input
//        1
//        10 20
//
//        Output
//        4
//
//
//        Explanation:
//
//        A  = 1001001
//        B  = 0010101
//        No of bits need to flipped = set bit count i.e. 4
//******************************************************************************************************************
//Companies: Samsung, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/bit-difference/0/
//******************************************************************************************************************

public class BitDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            System.out.println(run(scan.nextInt(), scan.nextInt()));
        }
    }



    //xor both inputs and count how many ones
    //XOR operations
    //1 ^ 1 = 0
    //0 ^ 1 = 1
    //1 ^ 0 = 1
    //0 ^ 0 = 0
    //notice in case if there is any difference it brings for you one otherwise it results in 0
    //count all results and return
    static int run(int n1, int n2) {
        int result = 0;
        for(char i = 0;i<32;i++){
            //xor 2 bits at the same location
            if(((n1 & (1 << i)) ^ (n2 & (1 << i))) > 0)
                result++;
        }


        return result;

    }
}
