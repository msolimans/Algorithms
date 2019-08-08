package com.leetcode;

//m_34_FindFirstandLastPositionofElementinSortedArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class m_34_FindFirstandLastPositionofElementinSortedArray {


    public static void main(String[] args) {


    }

    public int[] searchRange(int[] nums, int target) {
        //in case of empty array, return -1,-1
        if (nums.length == 0)
            return new int[]{-1, -1};

        //search inside the range of the array
        return searchRange(nums, 0, nums.length - 1, target);
    }

    public int[] searchRange(int[] nums, int start, int end, int target) {

        //if we got out of the range of the array, that means we finished our search and the target doesn't exist
        if (start < 0 || start > nums.length - 1 || end < 0 || end > nums.length - 1) {
            return new int[]{-1, -1};
        }

        //if we shrank the range until we start equals end and target not equal to current elem, return -1,-1
        if (start == end && target != nums[start]) {
            return new int[]{-1, -1};
        }

        //calc mid within the range
        int mid = (start + end) / 2;


        //if target equals current elem at mid
        //start searching to get the min/max index, we may have duplicates of the target in the left and right side of current index
        if (nums[mid] == target) {
            return findIndx(nums, mid, target);
        } else if (target < nums[mid]) {//if target less than current elem, eleminate the search range from start .. mid - 1
            return searchRange(nums, start, mid - 1, target);
        } else {//if target greater than current elem, eleminate the search range from mid +1 .. end
            return searchRange(nums, mid + 1, end, target);
        }

    }


    int[] findIndx(int[] nums, int index, int target) {
        //curren will hold current index in our loops
        int current = index;
        //start will hold the min index at which elem equals target
        int start = index;
        //loop from current index to left side until 0 and every time update start in case current elem still equals target otherwise exit
        while (current >= 0) {
            if (nums[current] == target) {
                start = current;
            } else {
                break;
            }
            current--;
        }

        current = index;
        int end = index;

        //loop from current index to right side until length-1 and every time update start in case current elem still equals target otherwise exit
        while (current <= nums.length - 1) {
            if (nums[current] == target) {
                end = current;
            } else {
                break;
            }
            current++;
        }

        //return start and end
        return new int[]{start, end};
    }

    @Test
    public void Testssss() {
        Assert.assertArrayEquals(new int[]{3, 4}, findIndx(new int[]{5, 7, 7, 8, 8, 10,}, 3, 8));
    }


    @Test
    public void Testss() {
        Assert.assertArrayEquals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Assert.assertArrayEquals(new int[]{0, 0}, searchRange(new int[]{5}, 5));
        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{2, 2}, 1));
    }

}
