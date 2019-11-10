package com.leetcode;

//e_303_RangeSumQueryImmutable 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//Example:
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//Note:
//You may assume that the array does not change.
//There are many calls to sumRange function.

//******************************************************************************************************************
//Companies: Palantir
//******************************************************************************************************************
//Link: https://leetcode.com/problems/range-sum-query-immutable/
//******************************************************************************************************************

//Easier to understand with 2 hashmaps
class NumArray {

    Map<Integer, Integer> forward = new HashMap<>();
    Map<Integer, Integer> backward = new HashMap<>();

    int sum = 0;

    public NumArray(int[] nums) {
        //subtract left side and right side to keep only the middle .. I made it this way to make it easier for beginners to understand
        //another soln can be //you can have sum array and subtract sum at index i+1 from index j+1
        forward.put(-1, 0);
        forward.put(nums.length, 0);
        backward.put(-1, 0);
        backward.put(nums.length, 0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            forward.put(i, forward.get(i - 1) + nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            backward.put(i, backward.get(i + 1) + nums[i]);
        }
    }

    //O(1) soln
    public int sumRange(int i, int j) {
        return sum - forward.get(i - 1) - backward.get(j + 1);
    }


}


//Better in space
class NumArray2 {


    int[] sum;

    public NumArray2(int[] nums) {
        //another soln can be //you can have sum array and subtract sum at index i+1 from index j+1

        sum = new int[nums.length  ];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    //O(1) soln
    public int sumRange(int i, int j) {
        if (i == 0)
            return sum[j];
        return sum[j] - sum[i - 1];
    }
}

public class e_303_RangeSumQueryImmutable {


    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        NumArray2 obj2 = new NumArray2(nums);

        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj2.sumRange(0, 2));



    }

    @Test
    public void TestSumRange() {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray obj = new NumArray(nums);
        Assert.assertEquals(1, obj.sumRange(0, 2));
        Assert.assertEquals(-1, obj.sumRange(2, 5));
        Assert.assertEquals(-3, obj.sumRange(0, 5));

    }

    @Test
    public void TestSumRange1() {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray2 obj = new NumArray2(nums);
        Assert.assertEquals(1, obj.sumRange(0, 2));
        Assert.assertEquals(-1, obj.sumRange(2, 5));
        Assert.assertEquals(-3, obj.sumRange(0, 5));
        Assert.assertEquals(-2, obj.sumRange(0, 0));

    }

}
