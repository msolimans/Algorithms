package com.g4g.basic;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Missing number in array
//Show Topic Tags

/**
 * Array, Searching
 */

/*Description*/
//******************************************************************************************************************
//Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N.
//        The second line of each test case contains N-1 input C[i],numbers in array.
//
//        Output:
//
//        Print the missing number in array.
//
//        Constraints:
//
//        1 ≤ T ≤ 200
//        1 ≤ N ≤ 1000
//        1 ≤ C[i] ≤ 1000
//
//        Example:
//
//        Input
//        2
//        5
//        1 2 3 5
//        10
//        1 2 3 4 5 6 7 8 10
//
//        Output
//        4
//        9

//******************************************************************************************************************
//Companies: Payu, Ola-Cabs, Microsoft, Intuit, Cisco, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/missing-number-in-array/0
//******************************************************************************************************************

public class MissingNumberInArray {


    public static void main(String[] args) throws IOException {
        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] nums = new int[n + 1];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            //notice the index here as it starts from 1 to n-1 (the number entered in the example in the question was 5 however we have only 4 elements (one missing)
            for (int i = 0; i < n - 1; i++) {
                //assign the value as 1 (to indicate it exists) otherwise it is 0 (not exist or mentioned in the input)

                nums[Integer.parseInt(strs[i])] = 1;

            }

            // loop through array from 1 to n and check which is missing


            System.out.println(FindMissing(nums, n));
           // System.out.println(FindMissingByCount(nums, n));
        }
    }

    public static int FindMissing(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0)
                return i;
        }
        return -1;
    }

    public static int FindMissingByCount(int[] arr, int n) {
        int expected = 0;
        for (int i = 1; i <= n; i++) {
            expected += i;
        }
        int actual = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                actual += i;
            }
        }

        return expected - actual;
    }

    @Test
    public void TestFindMissing() {
        Assert.assertEquals(4, FindMissing(new int[]{0, 1, 1, 1, 0}, 4));
        Assert.assertEquals(2, FindMissing(new int[]{0, 1, 0, 1, 1}, 4));
    }
  @Test
    public void TestFindMissingByCount() {
        Assert.assertEquals(4, FindMissingByCount(new int[]{0, 1, 1, 1, 0}, 4));
        Assert.assertEquals(2, FindMissingByCount(new int[]{0, 1, 0, 1, 1}, 4));
    }


}
