package com.g4g.Easy;

import java.util.HashSet;
import java.util.Scanner;


//Find K-th missing element
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given two sequences, one is increasing sequence a[] and another a normal sequence b[], find the K-th missing element in the increasing sequence which is not present in the given sequence.
// If no k-th missing element is there output -1
//        Input:  a[] = {0, 2, 4, 6, 8, 10, 12, 14, 15};
//        b[] = {4, 10, 6, 8, 12};
//        k = 3
//        Output: 14
//        Explanation : The numbers from increasing sequence that
//        are not present in the given sequence are 0, 2, 14, 15.
//        The 3rd missing number is 14.
//
//      Input:
//        The first line consists of an integer T i.e number of test cases. The first line of each test case consists of three integers n1, n2 and k.The next line consists of n1 spaced integers.
//        The next line consists of n2 spaced integers.
//
//      Output:
//        Print the kth number that is present in 1st array but not in 2nd.
//
//      Constraints:
//        1<=T<=100
//        1<=n1,n2,k,a[i],b[i]<=10000
//
//      Example:
//        Input:
//        1
//        9 5 3
//        0 2 4 6 8 10 12 14 15
//        4 10 6 8 12
//
//        Output:
//        14
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/find-k-th-missing-element/0/?ref=self
//******************************************************************************************************************

public class FindKthMissingElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] a = new int[scan.nextInt()];
            int[] b = new int[scan.nextInt()];
            int k = scan.nextInt();

            for(int i = 0;i< a.length;i++)
                a[i] = scan.nextInt();
            for(int i =0;i<b.length;i++)
                b[i] = scan.nextInt();

            System.out.println(run(a, b, k));
            System.out.println(run2(a, b, k));
        }
    }

    //loop through b array and put its elems in a hashset to be fast in getting its item
    //loop through "a" and once you found a missing elem, validate count if it equal to K return the current element as a result otherwise continue
    //if you reached the end and still count less than K return -1
    //O(n1 + n2)
    //Space O(n2) for the hashset
    static int run(int[] a, int[] b, int k) {
        int count = 0;
        HashSet<Integer> bSet = new HashSet<>();

        for(int i=0;i<b.length;i++)
            bSet.add(b[i]);

        for(int i =0;i<a.length;i++){
            if(!bSet.contains(a[i]) && ++count == k)
                return  a[i];

        }

        //count didn't reach or equivalent to K
        return -1;
    }



    //As per question, constraints were  1<=n1,n2,k,a[i],b[i]<=10000
    //so we can use different methodology to avoid using auxiliary storage like hashset we used in prev solution
    //we could loop through "b" and mark those elem found there in "a" O(logn) using binry search as "a" is already sorted
    //loop through "a" then find the Kth element missing  (Skip marked elements at this time)
    static int run2(int[] a, int[] b, int k){
        for(int i:b){
            //find it in "a" O(logn) using BS
            a[binarySearch(a, i)] = -1;
        }

        int c = 0;

        for(int i:a){
            if(i != -1 && ++c == k)
                return i;
        }

        //c is less than K
        return  -1;
    }


    //binary search inside "a" for element "n"
    static int binarySearch(int[] a, int n){
        int s = 0, e = a.length - 1;


        while(s <= e){
            int mid = (s + e) /2;
            if(a[mid] == n)
                return mid;
            else if(a[mid] > n)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return  -1;

    }

}
