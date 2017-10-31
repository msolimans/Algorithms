package com.ocw.c6006.lect19;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman
 * Fibonacci Numbers can be computed using the following rules/equations:
        F(0) = 1
        F(1) = 1
        F(n) = F(n-1) + F(n-2)

 * Dynamic Programming:
    - Split your problem into subproblems and reuse solution of your sub-problems (by saving those solutions somewhere in case we need it) to solve your problem.
    - Memoize (Remember) and re-use solutions to sub-problems that help solve the who;e problem.


 * Example:
    - If we noticed the following sequences which involves a lot of the same computation repeatedly so we can use the same concept to save a lot of computation.
 *      f(5) = f(4) + f(3)
 *      f(4) = f(3) + f(2) => notice the repeateness of f(2) and f(3)
 *      f(3) = f(2) + f(1) => f(2) and f(1) is also computed somewhere why shouldn't we save it somewhere to avoid its computation multiple times
 *      f(2) = f(1) + f(0)
 *
 */

public class Fibonacci {
    static Map<Integer,Long> mem = new HashMap<>();

    public static void main(String[] args){

        System.out.println(naive_fib(10));
        System.out.println(memoizedTopDownFib(10));
        System.out.println(memoizedBottomUpFib(10));

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //naive recursive algorithm
    // Exponential running time
    //T(n) = T(n-1) + T(n-2) + O(1) => notice recurrence in T(n-1) + T(n-2)
    //T(n) = 2 T(n-2) => as T(n-2) is less (same as AVL tree discussed in previous lect.)
    //     = O(2^n/2) = O(2^n)
    static long naive_fib(int i){
        if(i == 0 || i == 1)
            return  1;

        //calc every time
        return  naive_fib(i - 1) + naive_fib(i-2);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Applying dynamic programming here (by using memoization)
    // Linear Running Time O(n)
    // If you want to see O(logn) check c6046
    // It costs only # of non-memoized calls = fib(1) fib(2) fib(3) ... fib(n)
    // Time Complexity = (Number of sub-problems that you have to solve)  X  (Amount of time you spent per sub-problem)
    // Time Complexity = (              O(n)                           )  X  (              O(1)                      )
    // Time Complexity = O(n)
    static long memoizedTopDownFib(int i){

        //check first in case we calculate this before, if so return it and save calc time.
        if(mem.containsKey(i)) return mem.get(i);

        if(i < 2 )
        {
            mem.put(i, 1L);
            return  1;
        }
        //calc and save into memory in case we need it in the future calc
        long result = memoizedTopDownFib(i - 1) + memoizedTopDownFib(i-2);
        mem.put(i, result);

        return result;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Bottom-up Dynamic Programming Algorithm for Fibonacci
    // Keeping previous 2 elements in an array (In the lecture he used a dictionary or HashMap in Java, however it is better to use here an array as we can use the index of array)
    // it is considered as a toplogical sort or form as we move from bottom to up
    //Time = O(n), Space = O(n)
    static long memoizedBottomUpFib(int n){
        int[] arr = new int[n];
        //fib(0) = 1
        arr[0] = 1;
        //fib(1) = 1
        arr[1] = 1;

        //loop from 2 to n  and apply equation
        for(int i = 2;i<=n;i++){
            //fib(n) = fib(n-1) + fib(n-2)
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }


    //To save space: the next version is only saving the last 2 values as at each step we need only to know the last 2 values not all of them
    //Time = o(n), Space = constant (only 2 variables that maintains the previous 2 fibs)
    static long memoizedBottomUpFib2(int n){
        //only save the last 2 calcs (no need for the whole array)
        //f(0)
        long prevprev = 1;
        //f(1)
        long prev = 1;
        long temp;


        for(int i =2;i<=n;i++){
            //preserve pev as it will be prevprev
            temp = prev;
            //it actually the current, it will be prev next step
            prev = prevprev + prev;
            //make prevprev = prev for the current step
            prevprev = temp;
        }

        return  prev;
    }


















}
