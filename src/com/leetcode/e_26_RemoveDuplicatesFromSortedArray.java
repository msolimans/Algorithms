package com.leetcode;

//e_26_RemoveDuplicatesFromSortedArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//Example 1:
//
//Given nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//
//It doesn't matter what you leave beyond the returned length.
//Example 2:
//
//Given nums = [0,0,1,1,1,2,2,3,3,4],
//
//Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
//
//It doesn't matter what values are set beyond the returned length.
//Clarification:
//
//Confused why the returned value is an integer but your answer is an array?
//
//Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
//
//Internally you can think of this:
//
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len elements.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_26_RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        System.out.println(new e_26_RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2}));
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        //keep index of last non-repeatable elem
        int iprev = 0;
        for (int i = 1; i < nums.length; i++) {
            //if current elem is different than prev elem [at index iprev]:
            //increment iprev with 1 and move current elem to that index
            if(nums[i] != nums[iprev]) {
                nums[++iprev] = nums[i];
            }
        }

        return iprev+1;
    }

    @Test
    public void TestRemoveDuplicates() {
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1,1,1,1,1}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1,2,3,4,5}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2,2,2}));
        Assert.assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2}));
    }
}
