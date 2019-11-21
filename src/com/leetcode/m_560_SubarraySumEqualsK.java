package com.leetcode;

//m_560_SubarraySumEqualsK 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//Example 1:
//Input:nums = [1,1,1], k = 2
//Output: 2
//Note:
//The length of the array is in range [1, 20,000].
//The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/subarray-sum-equals-k/
//******************************************************************************************************************

public class m_560_SubarraySumEqualsK {


    public static void main(String[] args) {
        System.out.println(new m_560_SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        //[1,1,1] , 2
        //0,1
        //1,1
        //2,1 => 2-2=0 => exists => 1
        //3-2 => 1 => exists => 1
        //2

        int sum = 0;
        int result = 0;

        //map has accumulative sums
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i : nums) {
            sum += i;
            //diff between current sum with k, in case we have this difference before add it to the result
            result += map.getOrDefault(sum - k, 0);
            //add 1 to cumulative sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }


    @Test
    public void TestSubArraySum() {
        Assert.assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
    }
}
