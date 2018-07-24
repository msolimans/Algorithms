package com.glassdoor.opentable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 10/24/17.
 */
public class Fibonacci {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args){

        //calc fibonacci(10) - non recursive
        System.out.println(fib1(10));

        //calc fibonacci(10)
        System.out.println(fib(10));


    }

    //non-recursive version
    static  int fib1(int n){
        int prev = 1;
        int prevprev = 1;
        int t ;
        for(int i=2;i<n;i++){
            t = prev;

            prev = prev + prevprev;
            prevprev = t;
        }

        return prev + prevprev;
    }

    //recursive version (dynamic programming, memoization)
    static int fib(int n){
        if(n == 0 || n ==1 )
            return  1;

        if(map.get(n) != null)
            return map.get(n);

        Integer result =  fib(n-1) + fib(n-2);
        map.put(n, result);

        return result;
    }
}
