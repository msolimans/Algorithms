package com.g4g.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Nth Fibonacci Number
//Show Topic Tags

/**
 * fibonacci, maths
 */

/*Description*/
//******************************************************************************************************************
//Given a positive integer N, find the Nth fibonacci number. Since the answer can be very large, print the answer modulo 1000000007.

//Input:
//
//        The first line of input contains T denoting the number of testcases.Then each of the T lines contains a single positive integer N.
//
//        Output:
//
//        Output the Nth fibonacci number.
//
//        Constraints:
//
//        1<=T<=200
//        1<=N<=1000
//
//        Example:
//
//        Input:
//        3
//        1
//        2
//        5
//
//        Output:
//        1
//        1
//        5
//******************************************************************************************************************
//Companies: MAQ-Software, MakeMyTrip
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/nth-fibonacci-number/0
//******************************************************************************************************************

public class NthFibonacciNumbers {
    //storing calculations to save time later
    static Map<Integer, Long> fib = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        fib.put(0, 1L);
        fib.put(1, 1L);
        while (T-- > 0) {
            int number = scan.nextInt();
            //subtract by 1 as long as we start from 0, I mean we have a defined fib(0)
            //so 4th fib number means fib(3) and 5th fib number means fib(4)
            System.out.println(run(number - 1));
        }
    }


    //bottom up algoeithm with dynamic programming O(n)
    //check all types of algorithms for fibonacci in  com/ocw/c6006/lect19/Fibonacci.java
    static long run(int n) {

        for(int i=2;i<=n;i++){
            if(!fib.containsKey(i))
                fib.put(i, ((fib.get(i-1) + fib.get(i-2)) % 1000000007));
        }

        return fib.get(n);
    }
}
