package com.g4g.basic;

import java.util.Scanner;

//Problem Title
//Show Topic Tags

/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
// Given an array of N elements and a integer K , return the position of first occurence of K in given array.  Position of first element is considered as 1.
//Output -1 if the number is not found in an array.
//
//        Input:
//
//        The first line contains 'T' denoting the number of testcases. Then follows description of testcases.
//        Each case begins with a two space separated integer N and K denoting the size of array and the value of K respectively. The next line contains the N space separated integers denoting the elements of array.
//
//
//        Output:
//
//        For each test case, print the index of first occurrence of given number K.
//        Print -1 if the number is not found in array.
//
//
//        Constraints:
//
//        1<=T<=100
//        1<=N<=1000
//        1<=K<=100000
//        1<=A[i]<=100000
//
//
//        Example:
//
//        Input :
//        2
//        5 16
//        9 7 2 16 4
//        7 98
//        1 22 57 47 34 18 66
//
//        Output :
//        4
//        -1
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/searching-a-number/0/
//******************************************************************************************************************

public class SearchingANumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int indx ;
        while (T-- > 0) {
            int len = scan.nextInt();
            int n = scan.nextInt();

            indx = -1;


            for(int i =1;i<= len;i++){
                if(scan.nextInt() == n && indx == -1)
                    indx = i;
            }

            System.out.println(indx);

        }
    }



}
