package com.g4g.basic;

import java.util.Scanner;


//Power Of 2
//Show Topic Tags

/**
 * Maths, Bit Operations
 */

/*Description*/
//******************************************************************************************************************
//Given a positive integer N, check if N is a power of 2.

//Input:
//        The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
//        Each test case contains a single positive integer N.
//
//
//        Output:
//        Print "YES" if it is a power of 2 else "NO". (Without the double quotes)
//
//
//        Constraints:
//        1<=T<=100
//        0<=N<=10^18
//
//        Example:
//        Input:
//        2
//        1
//        98
//
//        Output :
//        YES
//        ​NO
//
//        Explanation:  (2^0 == 1)
//******************************************************************************************************************
//Companies: Microsoft, Mallow Technologies, Intel, FactSet, BankBazaar, Adobe, Samsung, Practo, Oracle
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/power-of-2/0
//******************************************************************************************************************

public class PowerOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long n = scan.nextLong();

            System.out.println(run(n)? "YES": "NO");
        }
    }


    //using bit wise operations
    //only 1 bit should come as 1
    static boolean run(long n) {

        int ones = 0;
        //loop through 32 bits (integer size)
        for(char i=0;i<32;i++){
            //validate current bit and maintain count of 1s in ones variable
            if((n & (1 << i)) > 0)
                ones++;
            //validate if ones is greater than 1 which means we have more than 1 bits in the integer, exit and return false
            if(ones > 1)
                return false;
        }

        //validate if we have only 1
        if(ones == 1)
            return true;

        //otherwise we don't have any, it is zero, return false
        return false;



    }

    static boolean run2(int n){
        while(n % 2 == 0)
            n = n / 2;
        return n == 1;
    }

}
