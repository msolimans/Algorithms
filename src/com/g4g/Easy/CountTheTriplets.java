package com.g4g.Easy;


//Count the triplets

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HashMap, Naiv Comparisons (O(n^2)
 * Sorting, 2Pointer Algorithm Sort => O(nlogn) and Comparisons O(n^2)
 */

/*Description*/
//******************************************************************************************************************
//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//        Output:
//        For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".
//
//        Constraints:
//        1 <= T <= 100
//        3 <= N <= 105
//        1 <= A[i] <= 106
//
//        Example:
//        Input:
//        2
//        4
//        1 5 3 2
//        3
//        3 2 7
//        Output:
//        2
//        -1
//
//        Explanation:
//        Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5
//******************************************************************************************************************
//Companies: Arcesium
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/count-the-triplets/0
//******************************************************************************************************************

public class CountTheTriplets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //do your action here for each test case
            int length = scan.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = scan.nextInt();
            }

            System.out.println(SortAndFind(arr));
        }
    }

    //O(n^2)
    //Auxiliary Space: O(n)
    static int IndexAndFind(int[] arr) {
        Set<Integer> set = new HashSet<>();
        //O(n)
        for (int i : arr) {
            set.add(i);
        }
        int count = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum))
                    count++;
            }
        }

        return count == 0 ? -1 : count;

    }

    //O(n^2)
    //Auxilary Space: N/A
    static int SortAndFind(int[] arr) {
        Arrays.sort(arr);
        int i = arr.length;
        int count = 0;
        //in case less than 2 it won't exec while loop n return 0 => -1
        while (--i > 1) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == arr[i]) {
                    count++;
                    start++;
                    end++;
                } else if (sum > arr[i]) {
                    end--;
                } else { // sum < arr[i]
                    start++;
                }
            }

        }

        //-1 in case nothing found
        return count == 0 ? -1 : count;
    }

    @Test
    public void TestSortAndFind() {
        Assert.assertEquals(2, SortAndFind(new int[]{1, 5, 3, 2}));
        Assert.assertEquals(3, SortAndFind(new int[]{1, 5, 3, 2, 8}));
        Assert.assertEquals(-1, SortAndFind(new int[]{3, 2, 7}));
    }
    @Test
    public void TestIndexAndFind() {
        Assert.assertEquals(2, IndexAndFind(new int[]{1, 5, 3, 2}));
        Assert.assertEquals(3, IndexAndFind(new int[]{1, 5, 3, 2, 8}));
        Assert.assertEquals(-1, IndexAndFind(new int[]{3, 2, 7}));
    }

}
