package com.leetcode;

//e_204 Count Primes
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Count the number of prime numbers less than a non-negative number, n.
//
//Example:
//
//Input: 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/count-primes/
//******************************************************************************************************************

public class e_204_CountPrimes {


    public static void main(String[] args) {
        System.out.println(new e_204_CountPrimes().countPrimes(10));
        System.out.println(new e_204_CountPrimes().countPrimes2(10));

    }

    public int countPrimes(int n) {
        boolean[] nonPrimes = new boolean[n];
        int count = 0;

        //mark non-prime numbers
        //recall for any prime number it is divisible only by itself and 1
        //we can only check the range from 2 .. sqrt(n) if the number is divisible by any number in this range so it is not prime
        //so we loop from 2 .. sqrt(n) to find out only NON-prime numbers .. from number's factors discover non prime numbers
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            //we start loop from i^2 .. n .. multiples of i such that it doesn't exceed n
            //examples:
            // 2*2 = 4 which is not a prime .. 2*2+2 = 6 ... 2*2+2+2=8, these are not primes
            // 3*3 = 9 which is not a prime .. 3*3+3 = 12 .. and so on!
            for (int j = i * i; j < n; j += i)
                nonPrimes[j] = true;
        }

        //we count anything in the array that were not marked as NON-prime
        for (int i = 2; i < n; i++) {
            if (nonPrimes[i] == false) {
                count++;
            }
        }

        return count;
    }

    //naive/brute force solution, might give you timeout in leetcode though but just for learners
    public int countPrimes2(int n) {
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i))
                count++;

        return count;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    @Test
    public void TestisPrime() {
        Assert.assertEquals(true, isPrime(2));
        Assert.assertEquals(true, isPrime(3));
        Assert.assertEquals(true, isPrime(5));
        Assert.assertEquals(true, isPrime(7));
        Assert.assertEquals(false, isPrime(8));
        Assert.assertEquals(false, isPrime(9));


    }

    @Test
    public void TestcountPrimes() {
        Assert.assertEquals(4, countPrimes(10));
    }

    @Test
    public void TestcountPrimes2() {
        Assert.assertEquals(4, countPrimes2(10));
    }
}
