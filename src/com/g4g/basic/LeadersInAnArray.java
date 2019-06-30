package com.g4g.basic;

//Majority Element
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
//Given an array of positive integers. Your task is to find the leaders in the array.
//        Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
//        The first line of each test case contains a single integer N denoting the size of array.
//        The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//        Output:
//        Print all the leaders.
//
//        Constraints:
//        1 <= T <= 100
//        1 <= N <= 107
//        0 <= Ai <= 107
//
//        Example:
//        Input:
//        3
//        6
//        16 17 4 3 5 2
//        5
//        1 2 3 4 0
//        5
//        7 4 5 7 3
//        Output:
//        17 5 2
//        4 0
//        7 7 3
//
//        Explanation:
//        Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.
//******************************************************************************************************************
//Companies: Payu
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
//******************************************************************************************************************


public class LeadersInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            String[] strs = line.trim().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(Arrays.toString(FindLeaders(arr)).replaceAll("[\\[\\]\\,]", "").trim());

        }
    }

    static int[] FindLeaders(int[] arr) {
        LinkedList<Integer> lst = new LinkedList<>();
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                lst.addLast(arr[i]);
                max = arr[i];
            }
        }

        int[] result = new int[lst.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = lst.pollLast();
        }

        return result;
    }

    @Test
    public void TestFindLeaders() {

        Assert.assertArrayEquals(new int[]{17, 5, 2},  FindLeaders(new int[]{16, 17, 4, 3, 5, 2}));
        Assert.assertArrayEquals(new int[]{4,0}, FindLeaders(new int[]{1, 2, 3, 4, 0}));
        Assert.assertArrayEquals(new int[]{7,7,3}, FindLeaders(new int[]{7,4,5,7,3}));
    }
}
