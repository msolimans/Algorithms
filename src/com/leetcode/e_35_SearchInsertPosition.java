package com.leetcode;

//e_35_SearchInsertPosition
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Example 1:
//
//Input: [1,3,5,6], 5
//Output: 2
//Example 2:
//
//Input: [1,3,5,6], 2
//Output: 1
//Example 3:
//
//Input: [1,3,5,6], 7
//Output: 4
//Example 4:
//
//Input: [1,3,5,6], 0
//Output: 0

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/search-insert-position/
//******************************************************************************************************************

public class e_35_SearchInsertPosition {


    public static void main(String[] args) {


    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    //O(log n)
    public int searchInsert(int[] nums, int start, int end, int target) {


        int mid = (start + end) / 2;
        //if target is less than current elem and (either the first element in nums or the target is greater than the previous elem)
        if (target <= nums[mid] && (mid - 1 < 0 || target > nums[mid - 1])) {
            return mid;
        }

        //if target is greater than current elem and (either the next element exceed length of arr or the target is less than next)
        if (target > nums[mid] && (mid + 1 > nums.length - 1 || target <= nums[mid + 1])) {
            return mid + 1;
        }

        //if less than current elem, search in the left side, start to mid - 1
        if (target <= nums[mid])
            return searchInsert(nums, start, mid - 1, target);
            //otherwise, search in the right side, mid + 1 to end
        else
            return searchInsert(nums, mid + 1, end, target);
    }


    @Test
    public void TestsearchInsert() {
        Assert.assertEquals(1, searchInsert(new int[]{1}, 4));
        Assert.assertEquals(0, searchInsert(new int[]{3}, 3));

        //even count
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 4));
        Assert.assertEquals(3, searchInsert(new int[]{1, 3, 5, 6}, 6));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assert.assertEquals(2, searchInsert(new int[]{1, 3}, 4));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3}, 2));
        Assert.assertEquals(3, searchInsert(new int[]{1, 3, 5}, 6));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5}, 2));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5}, 3));
//
//        ///
//
//        //odd count
        Assert.assertEquals(3, searchInsert(new int[]{1, 3, 4, 5, 6}, 5));
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 4, 5, 6}, 4));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 4, 5, 6}, 6));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 4, 5, 6}, 2));
        Assert.assertEquals(5, searchInsert(new int[]{1, 3, 4, 5, 6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 4, 5, 6}, 0));

    }
}
