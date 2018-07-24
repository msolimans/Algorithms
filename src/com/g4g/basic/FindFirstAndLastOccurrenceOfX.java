package com.g4g.basic;
import java.util.Scanner;


//Find first and last occurrence of x
//Show Topic Tags
/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
// Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

//Examples:
//
//        Input : A[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}
//        x = 5
//        Output : First Occurrence = 2
//        Last Occurrence = 5
//
//        Input : A[] = {1, 3, 5, 5, 5, 5 ,7, 123 ,125 }
//        x = 7
//        Output : First Occurrence = 6
//        Last Occurrence = 6
//
//        Input:
//        The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array. The last line of each test case contains an integer x.
//
//        Output:
//        For each test case in a new line print two integers separated by space denoting the first and last occurrence of the element x. If the element is not present in the array print -1.
//
//        Constraints:
//        1<=T<=101
//        1<=N<=100
//        1<=A[],k<=100
//
//        Example:
//        Input:
//        2
//        9
//        1 3 5 5 5 5 67 123 125
//        5
//        9
//        1 3 5 5 5 5 7 123 125
//        7
//        Output:
//        2 5
//        6 6
//******************************************************************************************************************
//Companies:Amazon, LinkedIn
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x/0
//******************************************************************************************************************

public class FindFirstAndLastOccurrenceOfX {
    public static  void  main(String[] args){
        Scanner scan = new Scanner(System.in);


        int t = scan.nextInt();


        while(t-- > 0){

            int l = scan.nextInt();
            int[] arr = new int[l];

            for(int i =0;i<l;i++){
                arr[i] = scan.nextInt();
            }

            int n = scan.nextInt();

            System.out.println(run(arr, n));

        }
    }

    private static String run(int[] arr, int n) {
        int s = -1,e = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == n ){
                if(s == -1)
                    s = i;
                e = i;
            }
        }

        return s == -1? "-1": s + " " + e;
    }
}
