package com.g4g.medium;


//Find Missing And Repeating
//Show Topic Tags

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Array, Queue, Sliding Window
 */

/*Description*/
//******************************************************************************************************************
//Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//        Output:
//        Print the maximum for every subarray of size k.
//
//        Constraints:
//        1 ≤ T ≤ 200
//        1 ≤ N ≤ 107
//        1 ≤ K ≤ N
//        0 ≤ A[i] <= 107
//
//        Example:
//        Input:
//        2
//        9 3
//        1 2 3 1 4 5 2 3 6
//        10 4
//        8 5 10 7 9 4 15 12 90 13
//
//        Output:
//        3 3 4 5 5 5 6
//        10 10 10 15 15 90 90
//
//        Explanation:
//        Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.
//******************************************************************************************************************
//Companies: Amazon, Cisco, Directi, FlipKart
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0/?ref=self
//******************************************************************************************************************


public class MaximumOfAllSubArraysOfSizeK {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {

            String statsLine = reader.readLine();
            String[] stats = statsLine.trim().split("\\s+");
            int n = Integer.parseInt(stats[0]);
            int k = Integer.parseInt(stats[1]);

            String line = reader.readLine();
            String[] strs = line.trim().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(FindAllMax(arr, k));
        }

    }

    public static class MaxComparator implements Comparator<Map.Entry<Integer, Integer>> {

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            if (o1.getKey().equals(o2.getKey())) {
                return 0;
            } else if (o1.getKey() < o2.getKey()) { //this will make it reversal, desc order
                return 1;
            } else {
                return -1;
            }
        }

    }


    static Integer extractMax(PriorityQueue<Map.Entry<Integer, Integer>> maxes, int start, int end) {

        while (maxes.size() > 0) {
            Map.Entry<Integer, Integer> max = maxes.peek();
            int index = max.getValue();
            if (index >= start && index <= end) {
                if (index == start) {
                    //clean, first item
                    maxes.poll();
                }
                return max.getKey();
            } else {
                //clean outdated maxes
                maxes.poll();
            }
        }

        return -1;
    }

    // Return a map entry (key-value pair) from the specified values
    public static <T, U> Map.Entry<T, U> pair(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }

    //1 2 3 1 4 5 2 3 6
    //4 1 1 0 1 2
    //O(n) solution
    //Auxiliary space: priority queue to keep/store maxes of the current window
    static String FindAllMax(int[] arr, int k) {
        MaxComparator comparator = new MaxComparator();
        StringBuffer sb = new StringBuffer();

        int start = 0;
        int end = 0;


        //max heap
        PriorityQueue<Map.Entry<Integer, Integer>> maxes = new PriorityQueue<>(k, comparator);

        while (end < arr.length) {

            maxes.add(pair(arr[end], end));

            if (end - start == k - 1) {
                sb.append(extractMax(maxes, start, end));
                sb.append(" ");
                start++;
                end++;
            } else {
                end++;
            }
        }

        return sb.toString().trim();
    }

    static String FindAllMax2(int[] arr, int k) {

        StringBuffer sb = new StringBuffer();
        int start = 0;
        int end = 0;


        //max heap
        PriorityQueue<Integer> maxes = new PriorityQueue<>(k, Collections.reverseOrder());

        while (end < arr.length) {

            maxes.add(arr[end]);

            if (end - start == k - 1) {
                sb.append(maxes.peek() + " ");
                maxes.remove(arr[start]);
                start++;
                end++;
            } else {
                end++;
            }
        }


        return sb.toString().trim();
    }


    @Test
    public void TestMaxComparator() {

        MaxComparator comparator = new MaxComparator();
        PriorityQueue<Map.Entry<Integer, Integer>> maxes = new PriorityQueue<>(2, comparator);
        maxes.add(pair(10, 2));
        maxes.add(pair(20, 1));
        maxes.add(pair(50, 1));
        maxes.add(pair(30, 1));

        Map.Entry<Integer, Integer> i = maxes.poll();
        int ss = i.getKey();
        Assert.assertEquals(50, ss);

        i = maxes.poll();
        ss = i.getKey();
        Assert.assertEquals(30, ss);

        i = maxes.poll();
        ss = i.getKey();
        Assert.assertEquals(20, ss);
    }

    @Test
    public void TestFindAllMax() {
        Assert.assertEquals("3 3 4 5 5 5 6", FindAllMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
        Assert.assertEquals("3 3 4 5 5 5 3", FindAllMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 1}, 3));
        Assert.assertEquals("5 3", FindAllMax(new int[]{5, 2, 3, 1}, 3));
        Assert.assertEquals("5 3", FindAllMax(new int[]{5, 3, 2, 1}, 3));
        Assert.assertEquals("10 10 10 15 15 90 90", FindAllMax(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4));
    }

    @Test
    public void TestFindAllMax2() {
        Assert.assertEquals("3 3 4 5 5 5 6", FindAllMax2(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
        Assert.assertEquals("3 3 4 5 5 5 3", FindAllMax2(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 1}, 3));
        Assert.assertEquals("5 3", FindAllMax2(new int[]{5, 2, 3, 1}, 3));
        Assert.assertEquals("5 3", FindAllMax2(new int[]{5, 3, 2, 1}, 3));
        Assert.assertEquals("10 10 10 15 15 90 90", FindAllMax2(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4));
    }

}
