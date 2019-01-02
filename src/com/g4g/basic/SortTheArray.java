package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;

//Sort the array
//Show Topic Tags
/**
 * Sort
 * Array
 * Counting
 */

/*Description*/
//**************************************************************
//Given a random set of numbers, Print them in sorted order.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//Output:
//Print each sorted array in a separate line. For each array its numbers should be seperated by space.
//
//Constraints:                    => Analysis Tips
//1 ≤ T ≤ 10                      => test cases at most is 10 which is not a big issue to use counting sort
//1 ≤ N ≤ 1000                    => as long as the numbers are positive it is easy to implement counting sort O(n+k) .. k is also constant here (100)
//1 ≤A[i]<100                     => item values are not too big, so counts array, auxiliary space, will be small (100 items)
//
//Example:
//Input:
//1
//2
//3 1
//
//Output:
//1 3
//
//http://practice.geeksforgeeks.org/problems/sort-the-array/0
//
//** For More Input/Output Examples Use 'Expected Output' option **

public class SortTheArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] counts = new int[101];
        while (--T >= 0) {
            //read how many items in each array
            int N = scan.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scan.nextInt();
            }

            String out = Arrays.toString(sort(arr, counts)).replace("[", "").replace("]", "").replace(",", "");
            System.out.println(out);
        }


    }

    static int[] sort(int[] arr, int[] counts) {

        if (arr == null || arr.length == 0)
            return new int[]{};

        if (arr.length == 1)
            return arr;

        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        for (int i : arr) {
            counts[i] += 1;
        }
        int indx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            for (int j = 0; j < counts[i]; j++)
                arr[indx++] = i;
        }

        return arr;
    }

}
