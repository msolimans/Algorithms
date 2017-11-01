package com.g4g.Easy;

import javarepl.internal.totallylazy.Sets;

import java.util.*;


//Pairs with Positive Negative values
//Show Topic Tags

/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
//Given an array of distinct integers, print all the pairs having positive value and negative value of a number that exists in the array.

//NOTE: If there is no such pair in the array , print "0".
//
//        Input:
//        The first line consists of an integer T i.e number of test cases. The first line of each test case consists of an integer n.The next line of each test case consists of n spaced integers.
//
//        Output:
//        Print all the required pairs in the increasing order of their absolute numbers.
//
//        Constraints:
//        1<=T<=100
//        1<=n<=1000
//        -1000<=a[i]<=1000
//
//        Example:
//        Input:
//        2
//        6
//        1 -3 2 3 6 -1
//        8
//        4 8 9 -4 1 -1 -8 -9
//
//        Output:
//        -1 1 -3 3
//        -1 1 -4 4 -8 8 -9 9
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0
//******************************************************************************************************************

public class PairsWithPositiveNegativeValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int len = scan.nextInt();
            int[] arr = new int[len];

            for (int i = 0; i < len; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(run(arr, len));
        }
    }


    //O(n)
    static String run(int[] arr, int len) {
        //O(n) operation to pick all negatives
        Set<Integer> negatives = new HashSet<>();
        for (int i : arr) {
            if (i < 0)
                negatives.add(i);
        }

        //priority queuue to keep all numbers in sorted mode
        //just store only positives in this heap
        PriorityQueue<Integer> sortedResult = new PriorityQueue<>();

        for (int i : arr) {
            if (i > 0 && negatives.contains(-1 * i)) {
                //remove it from the set to avoid duplication
                negatives.remove(-1 * i);
                sortedResult.add(i);
            }
        }

        //in case we don't have anything in the heap, it means we don't have any duplication (return 0)
        if(sortedResult.size() == 0)
            return  "0";

        //construct a string builder and construct the output in a sorted way
        StringBuilder builder = new StringBuilder();
        while (!sortedResult.isEmpty()) {
            int i = sortedResult.poll();
            builder.append(-1 * i + " " + i + " ");
        }

        return builder.toString().trim();
    }
}
