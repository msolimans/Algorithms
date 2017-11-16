package com.g4g.school;

import java.util.Scanner;


//Perfect Array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//There is an array contains some non-negative integers. Check whether the array is perfect or not. An array is called perfect if it is first strictly increasing, then constant and finally strictly decreasing. Any of the three parts can be empty.
//
//Input:
//        The first line of the input contains an integer T, denoting number of test cases. The first line of each test case contains an integer N denoting the size of the array. The second line of each test cases N space separated integers.
//        Output:
//        For each test case, print "Yes" if it satisfies the condition else "No".
//
//        Constraints:
//        1<=T<=100
//        1<=N<=10^3
//        Each element in the array will be in range [1,100000]
//
//        Example:
//        Input:
//        2
//        6
//        1 8 8 8 3 2
//        5
//        1 1 2 2 1
//        Output:
//        Yes
//        No
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/perfect-array/0
//******************************************************************************************************************

public class PerfectArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //do your action here for each test case
            int N = scan.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<arr.length;i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(run(arr)?"Yes": "No");
        }
    }


    static boolean  run(int[] arr) {
        int prev = arr[0];
        int state = 0; //0 means initial - 1 increasing - 2 means constant - 3 means descreasing


        for(int i=1;i<arr.length;i++){

            //Those conditions are defined to reflect requirements in question "Any of the three parts can be empty."
            //increasing state 1, can only come from initial (0 1) or increasing state (0 1 2 3) in case of elem 3 (state = 1) coming after 2 (state = 1)
            //but increasing not coming after const nor decreasing
            if(arr[i] > prev) {
                if (state > 1)
                    return false;

                //don't forget to update prev elem here
                prev = arr[i];
                state = 1;
            }

            //optional state 2: can come from previous state (initial, increasing, const) but not from decreasing state
            else if(arr[i] == prev) {
                if(state > 2)
                    return  false;

                prev = arr[i];
                state = 2;
            }

            //decreasing state 3: can come from any state
            else if(arr[i] < prev) {


                prev = arr[i];
                state = 3;
            }
        }

        return true;

    }
}
