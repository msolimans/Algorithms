package com.leetcode;

//e_88_MergeSortedArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//
//The number of elements initialized in nums1 and nums2 are m and n respectively.
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//Example:
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/merge-sorted-array/
//******************************************************************************************************************

public class e_88_MergeSortedArray {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new e_88_MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        m -= 1;
        n -= 1;
        //current index from left [a pointer to the next elem to be moved in the empty part]
        int current = nums1.length - 1;

        //keep moving elems as long as n is greater than or equal to zero
        while (n >= 0) {
            //if m  >= 0 and current elem in nums1 greater than current elem in nums2, shift or move that one from nums1 otherwise move elem from nums2
            //first part of condition will handle such case [0,0,0],0,[1,2],2
            //second part will handle this case [5,0,0],1,[1,2],2
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[current--] = nums1[m--];
            } else {//will handle this case [1,0],1,[6],1
                nums1[current--] = nums2[n--];
            }
        }

    }

    @Test
    public void TestMerge() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{1, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        merge(nums1, 1, nums2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 6}, nums1);


        nums1 = new int[]{0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        merge(nums1, 0, nums2, 3);
        Assert.assertArrayEquals(new int[]{2, 5, 6}, nums1);


        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        Assert.assertArrayEquals(new int[]{1,2}, nums1);


    }

}
