package com.g4g.basic;

import java.util.Scanner;


//Set Bits
//Show Topic Tags

/**
 * Bit Manipulation
 */

/*Description*/
//******************************************************************************************************************
//Given a positive integer N, print count of set bits in it. For example, if the given number is 6, output should be 2 as there are two set bits in it.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The next T lines will contain an integer N.
//
//        Output:
//        Corresponding to each test case, in a new line, print count of set bits in it.
//
//        Constraints:
//
//        1 ≤ T ≤ 100
//
//        1 ≤ N ≤ 1000000
//
//
//        Example:
//
//        Input:
//
//        2
//        6
//        11
//
//
//        Output:
//        2
//        3
//******************************************************************************************************************
//Companies: Qualcomm, Juniper Networks, Cisco, Brocade, Adobe
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/set-bits/0
//******************************************************************************************************************

public class SetBits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            run(scan.nextInt());
        }
    }


    static void run(int n) {
        int ones = 0;
        for(char i=0;i<32;i++){
            if((n & (1 << i)) > 0)
                ones++;
        }

        System.out.println(ones);

    }
}
