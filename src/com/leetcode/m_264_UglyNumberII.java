package com.leetcode;

//m_264_UglyNumberII 
//Show Topic Tags

import com.leetcode.shared.Queue;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a program to find the n-th ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
//Example:
//
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//Note:
//
//1 is typically treated as an ugly number.
//n does not exceed 1690.

//******************************************************************************************************************
//Companies: Amazon | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/ugly-number-ii/
//******************************************************************************************************************

public class m_264_UglyNumberII {


    public static void main(String[] args) {

    }


    //this makes a lot of calculations so we can pre-calc results and return any further calls in O(1) .. this will be addressed in second solution
    public int nthUglyNumber0(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        Set<Long> set = new HashSet<>();
        int res = 0;

        while (pq.size() > 0 && set.size() < n) {

            long ip = pq.poll();
            if (set.contains(ip))
                continue;

            set.add(ip);

            //last elem added is the result when set size equals n
            res = (int) ip;
            //add other elems to heap
            pq.add(ip * 2);
            pq.add(ip * 3);
            pq.add(ip * 5);
        }


        return res;
    }


    //Use this helper class to initialize all calculations from 1 ... 1960
    class Helper {
        //1960 is constant here
        //pre-calc all of them to be able to retrieve answer in constant time
        int[] nums = new int[1960 + 1];

        Helper() {
            //make all calculation for each one from 0 ... n-1
            PriorityQueue<Long> pq = new PriorityQueue<>();
            pq.add(1L);
            Set<Long> set = new HashSet<>();
            int i = 1;
            long current = 0;

            //loop thru as long as we didn't finish calcs and priority queue's size has elems
            while (i < nums.length && pq.size() > 0) {

                //poll the min elem from heap O(logn)
                current = pq.poll();
                //if visited, skip it
                if (set.contains(current))
                    continue;

                //add value of current elem to its correct index
                nums[i++] = (int) current;
                //add it to visited set
                set.add(current);

                //don't add previously-visited elems to the set
                //add only those with prime factors 2, 3, and 5 using multiplication [the other way around, no divisions needed]
                if (!set.contains(current * 2))
                    pq.add(current * 2);
                if (!set.contains(current * 3))
                    pq.add(current * 3);
                if (!set.contains(current * 5))
                    pq.add(current * 5);

            }
        }
    }

    Helper h = new Helper();

    public int nthUglyNumber(int n) {
        return h.nums[n];
    }


    @Test
    public void TestNthUglyNumber0() {
        Assert.assertEquals(12, nthUglyNumber0(10));
        Assert.assertEquals(2123366400, nthUglyNumber0(1690));

        Assert.assertEquals(12, nthUglyNumber(10));
        Assert.assertEquals(2123366400, nthUglyNumber(1690));
    }


}
