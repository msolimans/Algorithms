package com.g4g.medium;


//Kth smallest element
//Show Topic Tags

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
//Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
//
//        Expected Time Complexity: O(n)
//
//        Input:
//        The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
//
//        Output:
//        Corresponding to each test case, print the kth smallest element in a new line.
//
//        Constraints:
//        1 <= T <= 100
//        1 <= N <= 105
//        1 <= arr[i] <= 105
//        1 <= K <= N
//
//        Example:
//        Input:
//        2
//        6
//        7 10 4 3 20 15
//        3
//        5
//        7 10 4 20 15
//        4
//
//        Output:
//        7
//        15
//
//        Explanation:
//        Testcase 1: 3rd smallest element in the given array is 7.
//******************************************************************************************************************
//Companies: ABCO, Amazon, Cisco, Microsoft, VMWare
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0/?ref=self
//******************************************************************************************************************



public class KthSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            String[] strs = line.trim().split("\\s+");
            int[] arr = new int[n];
            for(int i =0;i<n;i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            int k = Integer.parseInt(reader.readLine());

            System.out.println(FindKthMax(arr, k));
        }

    }

      static Integer FindKthMax(int[] arr, int k) {
        PriorityQueue<Integer> smallestK = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i =0;i<arr.length;i++) {
            if (smallestK.size() >= k) {
                if (arr[i] < smallestK.peek()) {
                    smallestK.poll();
                    smallestK.add(arr[i]);
                }
            } else {
                smallestK.add(arr[i]);
            }
        }

        return smallestK.poll();
    }

    @Test
    public void TestFindKthMax() {
        Assert.assertEquals((long)7,(long)FindKthMax(new int[]{7,10,4,3,20,15}, 3));
    }

}
