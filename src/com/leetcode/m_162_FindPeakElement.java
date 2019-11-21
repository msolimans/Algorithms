package com.leetcode;

//m_162_FindPeakElement
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//A peak element is an element that is greater than its neighbors.
//
//Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//You may imagine that nums[-1] = nums[n] = -∞.
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.
//Example 2:
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5
//Explanation: Your function can return either index number 1 where the peak element is 2,
//             or index number 5 where the peak element is 6.
//Note:
//
//Your solution should be in logarithmic complexity.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/find-peak-element/
//******************************************************************************************************************

public class m_162_FindPeakElement {


    public static void main(String[] args) {
        System.out.println(new m_162_FindPeakElement().findPeakElement(new int[]{1,2,3,4,2}));

    }


    public int findPeakElement(int[] nums) {
        //if length is zero, return -1
        if (nums.length == 0)
            return -1;
        //lenght is one, return zero index
        if (nums.length == 1)
            return 0;



        int start = 0;
        int end = nums.length - 1;
        //keep searching for a peak until you get a match index-1<arr[index]>index+1 or last arr index or first arr index
        while (start <= end) {
            int mid = (start + end) / 2;
            //first or last elem in arr
            if (mid == 0)
                return nums[0] > nums[1] ? 0 : 1;
            if (mid == nums.length - 1)
                return nums[nums.length - 1] > nums[nums.length - 2] ? nums.length - 1 : nums.length - 2;

            //check if we have a peak here
            if (mid > 0 && nums[mid] > nums[mid - 1] && mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            //otherwise eleminate search space
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return -1;
    }


    @Test
    public void TestfindPeakElement() {
        Assert.assertEquals(0, findPeakElement(new int[]{1}));
        Assert.assertEquals(1, findPeakElement(new int[]{3, 4, 3, 2, 1}));
        Assert.assertEquals(0, findPeakElement(new int[]{2, 1}));
        Assert.assertEquals(1, findPeakElement(new int[]{1, 2}));
        Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 3}));
        Assert.assertEquals(0, findPeakElement(new int[]{3, 2, 1}));
        Assert.assertEquals(0, findPeakElement(new int[]{4, 3, 2, 1}));
        Assert.assertEquals(3, findPeakElement(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, findPeakElement(new int[]{0, 3, 2, 1}));
        Assert.assertEquals(2, findPeakElement(new int[]{0, 3, 4, 1}));
        Assert.assertEquals(3, findPeakElement(new int[]{0, 3, 4, 5}));
        Assert.assertEquals(3, findPeakElement(new int[]{0, 3, 4, 5, 0}));
        Assert.assertEquals(7, findPeakElement(new int[]{0, 3, 4, 5, 6, 7, 8, 9, 3, 2, 1}));
        Assert.assertEquals(8, findPeakElement(new int[]{0, 3, 4, 5, 6, 7, 8, 9, 10, 2, 1}));
        Assert.assertEquals(9, findPeakElement(new int[]{0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1}));
    }
}
