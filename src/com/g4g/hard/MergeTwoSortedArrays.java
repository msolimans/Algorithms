package com.g4g.hard;


//Merge Two Sorted Arrays
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Array, Math, Sorting
 */

/*Description*/
//******************************************************************************************************************
//Given two sorted arrays P[] and Q[] in non-decreasing order with size X and Y. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
//
//        Note: Expected time complexity is O((X+Y) log(X+Y)). DO NOT use extra space.
//
//        Input:
//        First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.
//
//        Output:
//        For each test case, print (X + Y) space separated integer representing the merged array.
//
//        Constraints:
//        1 <= T <= 100
//        1 <= X, Y <= 5*104
//        0 <= Pi, Qi <= 109
//
//        Example:
//        Input:
//        1
//        4 5
//        1 3 5 7
//        0 2 6 8 9
//
//        Output:
//        0 1 2 3 5 6 7 8 9
//
//        Explanation:
//        Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.
//******************************************************************************************************************
//Companies: Amazon, AmDocs, Brocade, Glodman Sachs, Juniper Networks, LinkedIn, Microsoft, Quickr, Snapdeal, Synopsys, Zoho
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
//******************************************************************************************************************


public class MergeTwoSortedArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String nline = reader.readLine();
            String[] ns = nline.trim().split("\\s+");
            int n1 = Integer.parseInt(ns[0]);
            int n2 = Integer.parseInt(ns[1]);

            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String[] strs1 = line1.trim().split("\\s+");
            String[] strs2 = line2.trim().split("\\s+");
            int[] nums1 = new int[n1];
            int[] nums2 = new int[n2];

            for (int i = 0; i < n1; i++) {
                nums1[i] = Integer.parseInt(strs1[i]);
            }

            for (int i = 0; i < n2; i++) {
                nums2[i] = Integer.parseInt(strs2[i]);
            }

            System.out.println(Arrays.toString(Merge(nums1, nums2)).trim().replaceAll("[\\[\\]\\,]", ""));

        }

    }

    static int[] Merge(int[] arr1, int[] arr2) {
        int i1 = 0;
        int i2 = 0;
        int[] result = new int[arr1.length + arr2.length];
        int indx = 0;

        while (i1 < arr1.length && i2 < arr2.length) {

            if (arr1[i1] <= arr2[i2]) {
                result[indx++] = arr1[i1++];
            } else {
                result[indx++] = arr2[i2++];
            }

        }

        //left over in arr1
        while (i1 < arr1.length) {
            result[indx++] = arr1[i1++];
        }

        //left over in arr2
        while (i2 < arr2.length) {
            result[indx++] = arr2[i2++];
        }

        return result;

    }

    @Test
    public void TestMerge() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9}, Merge(new int[]{1, 3, 5, 7}, new int[]{0, 2, 6, 8, 9}));
    }

}
