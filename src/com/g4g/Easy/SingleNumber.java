package com.g4g.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//Single Number
//Show Topic Tags

/**
 * Possible Solns:
 *  - Array
 *  - Hashset
 *  - Bitwise operations
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers, every element appears twice except for one. Find that single one.
//Note: There can be an element appearing odd number of times. That element needs to be counted as single number. In case of odd number of copies, the even ones get cancelled out
// from each other rendering just one element in the end.
//
//        Input:
//
//        First line will consist  a number T, the number of test cases.
//        Each test case will then consist of an Integer N depicting the size of array.
//        Next line will consist of N space separated integers ,the value of array.
//
//        Output:
//
//        Print the element that appears once in the array in a separate line.
//
//
//        Constraints:
//
//        1<=T<=30
//        1<=N<=100
//        0<=A[i]<=50
//
//        Example:
//
//        Input:
//        2
//        3
//        1 1 2
//        7
//        8 8 7 7 6 6 1
//
//        Output:
//        2
//        1
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/single-number/0/
//******************************************************************************************************************

public class SingleNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scan.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(run(arr));
            System.out.println(run1(arr));
            System.out.println(run2(arr));
        }
    }


    //different methods we can implement here
    //1) as long as it was mentioned in question that the numbers in array will be from 1 to 50 (it is static number)
    //we can create an array to preserve counts there and check it later after out scan
    //O(n) and space 50 items (const)
    static int run(int[] arr) {
        //0 to 50 counts
        int[] counts = new int[51];
        for (int i : arr) {
            //increment count and reset in case it is getting even (came in odd numbers)
            if (++counts[i] % 2 == 0)
                counts[i] = 0;
        }

        //loop through counts now and return the one with 1 val.
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1)
                return i;
        }

        return -1;
    }

    //2) based on hash set
    //loop through array, add the current item in hashset if it is not there. if it is not there add it.
    //we should end up with only one item in the set :)
    //O(n) and space required too
    static int run1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }

        return (int) set.toArray()[0];
    }

    //3) XOR all items together and get only the odd one (every even occurence of the same item cancel together after XOR
    //1 ^ 1 = 0
    //2 ^ 2 = 0
    // 1 ^ 1 ^ 1 = 1 :)
    //O(n) and no space required
    static int run2(int[] arr) {
        int result = 0;

        for (int i : arr) {
            result ^= i;
        }

        return result;
    }

}
