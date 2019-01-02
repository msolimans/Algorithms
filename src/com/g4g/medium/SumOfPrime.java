package com.g4g.medium;

import java.util.*;


//Problem Title
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
// Given a number ( greater than 2 ), Print two prime numbers whose sum will be equal to given number, else print -1 if no such number exists.

//NOTE: A solution will always exist if the number is even. Read Goldbach’s conjecture.
//
//        If [a, b] is one solution with a <= b,
//        and [c,d] is another solution with c <= d, and a < c then print [a, b] only and not all possible solutions.
//
//
//
//        Input:
//
//        The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N.
//
//
//        Output:
//
//        Print the two prime numbers in a single line with space in between.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 50
//        1 ≤ N ≤ 1000000
//
//
//        Example:
//
//        Input
//        2
//        8
//        3
//        Output
//        3 5
//        -1
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-prime/
//******************************************************************************************************************

public class SumOfPrime {
    static Set<Integer> primesSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            System.out.println(run(scan.nextInt()));
        }
    }



    //loop through 1 to n and check current number is a prime
    //if it is a prime and subtraction of n - this number = a number that exists in a saved set of prime numbers => return pair of 2 numbers that makes our target number
    //otherwise if it is a prime only, save it inside the set of primes
    //keep going until you exhaust all iterations, return -1.
    static String run(int n) {

        Map<Integer, Integer> results = new HashMap<>();

        for(int i = 2;i<=n;i++){
            //check first if it is a prime
            boolean isPrime = true;
            for(int j = 2; j<=Math.sqrt(i);j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            //prime but the set doesn't have it
            //add it first in case we have a number that is an addition of 2 same primes  like 6 = 3 + 3
            if(isPrime)
                primesSet.add(i);

            //if prime, and set has n-i => save the pair
            if(isPrime && primesSet.contains(n - i)){
                //check condition for listing only the smaller first
                int k = (i < (n -i)? i : (n - i));
                results.put(k , n - k);
            }
        }

        //loop through all results and get the one the least/min key
        if(results.size() > 0){

            int min = Integer.MAX_VALUE;
            for(Integer i: results.keySet()){
                if(i < min)
                    min = i;
            }

            //return the pair here
            return min + " " + results.get(min);
        }

        //no results in the map means -1
        return  "-1";
    }

}
