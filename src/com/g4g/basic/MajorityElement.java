package com.g4g.basic;


//Majority Element
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
//
//        Input:
//        The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.
//
//        Output:
//        For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.
//
//        Constraints:
//        1 <= T<= 100
//        1 <= N <= 107
//        0 <= Ai <= 106
//
//        Example:
//        Input:
//        2
//        5
//        3 1 3 3 2
//        3
//        1 2 3
//
//        Output:
//        3
//        -1
//
//        Explanation:
//        Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
//******************************************************************************************************************
//Companies: Accorlite, Amazon, D-E-Shaw, Microsoft, Nagarro
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/majority-element/0
//******************************************************************************************************************


public class MajorityElement {
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


            System.out.println(FindMajorityElement(arr));
        }

    }

    static int FindMajorityElement(int[] arr) {
        Map<Integer, Integer> elems = new HashMap<>();
        int max = 0;
        int result = 0;

        for (int item : arr) {
            int count = elems.getOrDefault(item, 0) + 1;
            elems.put(item, count);
            if (count > max) {
                max = count;
                result = item;
            }
        }

        if (max <= arr.length / 2) {
            return -1;
        }

        return result;
    }

    @Test
    public void TestFindMajorityElement() {
        Assert.assertEquals(3, FindMajorityElement(new int[]{3, 1, 3, 3, 2}));
        Assert.assertEquals(-1, FindMajorityElement(new int[]{3, 1, 3, 2, 2}));
        Assert.assertEquals(-1, FindMajorityElement(new int[]{1, 2, 3}));
    }

}
