package com.g4g.basic;

import java.util.Scanner;


// Sum Of First n Terms
//Show Topic Tags
/**
 * Maths
 */

/*Description*/
//******************************************************************************************************************
// Given and integer n. Print the sum of series 13 + 23 + 33 + 43 + …….+ n3 till n-th term.

//Input:
//        The first line consists of an integer T i.e number of test cases. The first and only line of each test case consists of an integer n. As the output could be large so take mod with 109+7.
//
//        Output:
//        Print the required sum.
//
//        Constraints:
//        1<=T<=100
//        1<=n<=109
//
//        Example:
//        Input:
//        2
//        5
//        7
//
//        Output:
//        225
//        784
//******************************************************************************************************************
//Companies:
//******************************************************************************************************************

public class SumOfFirstNTerms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

           System.out.println( run(scan.nextInt()));
        }
    }

    //cast or change return type based on problem's needs
    static double run(int n) {
        long result = 0 ;

        while(n > 0){

            result += (n * n * n);

            n--;
        }

        return result % (Math.pow(10,9) + 7);
    }

    static  double run_recursive (long n){
        if(n == 1)
            return  1;

        return ((n * n * n) + run_recursive(n -1)) % (Math.pow(10,9) + 7);
    }
}
