package com.leetcode;

//e_747_LargestNumberAtLeastTwiceofOthers
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 */

/*Description*/
//******************************************************************************************************************


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_747_LargestNumberAtLeastTwiceofOthers {


    public static void main(String[] args) {
        System.out.println(new e_747_LargestNumberAtLeastTwiceofOthers().dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(new e_747_LargestNumberAtLeastTwiceofOthers().dominantIndex2(new int[]{3, 6, 1, 0}));
    }

    //O(n)
    public int dominantIndex(int[] nums) {
        //we store counts of elems inside different array called `counts`
        int[] counts = new int[101];
        //we calc the max and preserve its index in case we need to return it
        int max = nums[0], imax = 0;//length will have range from 1 to 50 based on note/assumption. 1

        //don't forget to store 1 count of first elem
        counts[max] += 1;

        //calc max and preserve counts of each elem
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                imax = i;
            }

            counts[nums[i]] += 1;
        }

        //check if we have any occurrence of any elem bigger than mid of biggest elem in array
        int mid = max / 2;
        for (int i = mid + 1; i < 100; i++) {
            if (i != max && counts[i] > 0)
                return -1;
        }

        return imax;
    }


    //Another solution can be done using priority queue
    //O(nlogn)
    public int dominantIndex2(int[] nums) {
        //we store counts of elems inside different array called `counts`

        //we calc the max and preserve its index in case we need to return it
        int imax = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(nums[0]);

        //calc max and preserve counts of each elem
        for (int i = 1; i < nums.length; i++) {

            if (pq.size() > 0 && nums[i] > pq.peek()) {
                imax = i;
            }

            pq.add(nums[i]);
        }

        int biggest = pq.size() > 0 ? pq.poll() : 0;
        int secondBiggest = pq.size() > 0 ? pq.poll() : Integer.MIN_VALUE;

        return secondBiggest * 2 > biggest ? -1 : imax;
    }

    @Test
    public void TestDominantIndex() {
        Assert.assertEquals(5, dominantIndex(new int[]{1,2,16,35,44,100,27,0}));
        Assert.assertEquals(0, dominantIndex(new int[]{1}));
        Assert.assertEquals(3, dominantIndex(new int[]{0,0,0,1}));
        Assert.assertEquals(-1, dominantIndex(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));

        //2nd solution
        Assert.assertEquals(5, dominantIndex2(new int[]{1,2,16,35,44,100,27,0}));
        Assert.assertEquals(0, dominantIndex2(new int[]{1}));
        Assert.assertEquals(3, dominantIndex2(new int[]{0,0,0,1}));
        Assert.assertEquals(-1, dominantIndex2(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, dominantIndex2(new int[]{3, 6, 1, 0}));
    }


}
