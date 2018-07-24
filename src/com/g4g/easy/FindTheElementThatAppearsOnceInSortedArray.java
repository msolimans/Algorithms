package com.g4g.easy;

import java.util.Scanner;


//Find the element that apears once in a sorted array
//Show Topic Tags

/**
 * Array, Divide and Conquer, Searching, Bitwise
 */

/*Description*/
//******************************************************************************************************************
//Given a sorted array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.

//Input:
//
//        The first line of input consists number of the test cases. The description of T test cases is as follows:
//
//        The first line of each test case contains the size of the array, and the second line has the elements of the array.
//
//        Output:
//
//        In each separate line print the number that appears only once in the array.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 70
//        1 ≤ N ≤ 100
//        0 ≤ A[i] ≤ 100000
//
//
//        Example:
//
//        Input:
//
//        1
//        11
//        1 1 2 2 3 3 4 50 50 65 65
//
//        Output:
//
//        4
//******************************************************************************************************************
//Companies: Ola-Cabs, D-E-Show
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array/0/?ref=self
//******************************************************************************************************************

public class FindTheElementThatAppearsOnceInSortedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scan.nextInt()];
            for(int i = 0;i<arr.length;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run2(arr, arr.length));

        }
    }


    //Check ./SingleNumber.java for more solutions
    //HashSet, Array, XOR operations

    //3) XOR all items together and get only the odd one (every even occurence of the same item cancel together after XOR
    //1 ^ 1 = 0
    //2 ^ 2 = 0
    // 1 ^ 1 ^ 1 = 1 :)
    //O(n) and no space required
    static int run(int[] arr) {
        int result = 0;

        for (int i : arr) {
            result ^= i;
        }

        return result;
    }

//https://www.cryptocompare.com/mining/calculator/eth?HashingPower=172&HashingUnit=MH%2Fs&PowerConsumption=850&CostPerkWh=0.12

    //Divide and conquer (based on binary search)
    //O(logn)
    static int run2(int[] arr, int len) {
        int lo = 0;
        int hi = len - 1;
        int mid;
        int res = 0;

        while ((hi - lo) >= 2) {
            if (arr[lo] != arr[lo + 1]) {
                res = lo;
                break;
            } else if (arr[hi] != arr[hi - 1]) {
                res = hi;
                break;
            } else {
                mid = (lo + hi) / 2;


                if (isEven(mid - lo + 1)) {
                    if (arr[mid] == arr[mid - 1]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    if (arr[mid] == arr[mid - 1]) {
                        hi = mid - 2;
                    } else if (arr[mid] == arr[mid + 1]) {
                        lo = mid + 2;
                    } else {
                        res = mid;
                        break;
                    }
                }
            }
        }


        return arr[res];
    }

    static boolean isEven(int n) {
        return ((n % 2) == 0);
    }

}
