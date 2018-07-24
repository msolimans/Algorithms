package com.alkhawarizms.DynamicProg;

/**
 * Created by msoliman on 1/31/17.
 */
public class Fibonacci {


    static int[] F;
    static int countRecursiveCall = 0;

    public static void main(String[] args) {

        countRecursiveCall = 0;
        System.out.println("Brute force Method: ");
        System.out.println("Fibonacci Number: " + bruteForceFibo(30));
        System.out.println("Recursive calls counts: " + countRecursiveCall);
        countRecursiveCall = 0;
        System.out.println("Memoized Method 1: ");
        System.out.println("Fibonacci Number :" + memoizedFibo(30));
        System.out.println("Recursive calls counts: " + countRecursiveCall);


        countRecursiveCall = 0;
        System.out.println("Memoized Method 2: ");
        System.out.println("Fibonacci Number :" + memoizedFib(30, new int[31]));
        System.out.println("Recursive calls counts: " + countRecursiveCall);

    }

    public static int bruteForceFibo(int n) {
        countRecursiveCall++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return bruteForceFibo(n - 2) + bruteForceFibo(n - 1);
    }

    //another way of doing memoization
    //array passed in the first time should be n+1
    //example of call
    //System.out.println("Fibonacci Number :" + memoizedFib(30, new int[31]));
    public static int memoizedFib(int n, int[] memo) {
        countRecursiveCall++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        else if (memo[n] == 0)
            memo[n] = memoizedFib(n - 1, memo) + memoizedFib(n - 2, memo);


        return memo[n];
    }

    public static int memoizedFibo(int n) {
        //initializes array of fibos (as memoization array)
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = -1;
        }
        return fibo(n);
    }

    public static int fibo(int n) {
        countRecursiveCall++;
        if (F[n] < 0) {
            if (n == 0)
                F[n] = 0;
            else if (n == 1)
                F[n] = 1;
            else
                F[n] = fibo(n - 2) + fibo(n - 1);
        }
        return F[n];
    }


}
