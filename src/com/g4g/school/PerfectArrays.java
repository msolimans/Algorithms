package com.g4g.school;

import java.util.Scanner;
import java.util.Stack;


//Perfect Arrays (Same as Palindrome)
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an N length array and you have to tell whether the array is perfect or not.An array is said to be perfect if it's reverse array matches the original array. If the array is perfect then print "PERFECT" else print "NOT PERFECT".

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an integer N (size of the array)and the second line contains N elements a1,a2,......aN of an array .
//
//        Output:
//        For each test case, print either "PERFECT" or "NOT PERFECT" in new line as your answer.
//
//        Constraints:
//        1<=T<=100
//        1<=N<=100
//
//        1<=aN<=1000
//
//        Example:
//        Input:
//        2
//        5
//        1 2 3 2 1
//        5
//        1 2 3 4 5
//        Output:
//        PERFECT
//
//        NOT PERFECT
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/perfect-arrays/0/?ref=self
//******************************************************************************************************************

public class PerfectArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scan.nextInt()];
            for(int i =0;i<arr.length;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run(arr)?"PERFECT": "NOT PERFECT");
            System.out.println(run2(arr)?"PERFECT": "NOT PERFECT");
            System.out.println(run3(arr)?"PERFECT": "NOT PERFECT");
        }
    }



    //check both sides of the arrays with 2 indexes
    static boolean run(int[] arr) {
        int s = 0, e = arr.length - 1;
        while(s <= e && e >= 0 && s <= arr.length - 1){
            if(arr[s] != arr[e])
                return false;
            s++;
            e--;
        }

        return  true;
    }

    //Stack can be used as a solution
    //I just put this as a solution but doesn't mean it is a perfect
    static boolean run3(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<=arr.length/2 - 1;i++){
            stack.push(arr[i]);
        }

        for(int i=arr.length % 2 == 0?arr.length/2:arr.length/2+1;i<arr.length - 1;i++)
            if(stack.pop() != arr[i])
                return  false;

        return  true;
    }

    //bitwise XOR all elems in the array and check if number of elems in array are odd it should be equal to the middle elem in array otherwise ZERO
    //however this solution is looking good but order of elements in the array might change and it gave me wrong result for some of the test cases but I kept for only reference here
    //e.g. 3 4 5 2 3 5 4 => it should be NOT PERFECT however this function will result in PERFECT
    static boolean run2(int[] arr) {
        int result = 0;

        for(int i: arr){
            result ^= i;
        }

        //Example
        //suppose we have 1 2 1 => count of elems are 3 which is odd => 1 ^  2 ^ 1 = 2 => 2 is the middle elem of array
        //suppose we have 1 1   => count of elems are 2 which is even => 1 ^ 1 = 0
        return arr.length % 2 == 0? result == 0: result == arr[arr.length/2];
    }

}
