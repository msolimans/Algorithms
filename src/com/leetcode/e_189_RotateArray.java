package com.leetcode;

//e_189_RotateArray 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//Example 1:
//
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//Note:
//
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//Could you do it in-place with O(1) extra space?

//******************************************************************************************************************
//Companies: Microsoft | 4  Amazon | 2  Goldman Sachs | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/rotate-array/
//******************************************************************************************************************

public class e_189_RotateArray {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        new e_189_RotateArray().rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    //brute force, O(n * k) with O(1) space
    public void rotate(int[] nums, int k) {

        //shift all elems k times
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }

    }

    @Test
    public void TestRotate() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 1);
        Assert.assertArrayEquals(arr, new int[]{7, 1, 2, 3, 4, 5, 6});

        arr = new int[]{-1, -100, 3, 99};
        rotate(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{3, 99, -1, -100});


        int[] arr1 = new int[]{1, 2};
        rotate(arr1, 2);
        Assert.assertArrayEquals(arr1, new int[]{1, 2});

        int[] arr2 = new int[]{1, 2};
        rotate(arr2, 3);
        Assert.assertArrayEquals(arr2, new int[]{2, 1});


    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //extra space, O(n) with O(n) space
    public void rotate2(int[] nums, int k) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }

    }


    @Test
    public void TestRotate2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotate2(arr, 3);
        Assert.assertArrayEquals(arr, new int[]{5, 6, 7, 1, 2, 3, 4});

        arr = new int[]{-1, -100, 3, 99};
        rotate2(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{3, 99, -1, -100});


        int[] arr2 = new int[]{2, 3};
        rotate2(arr2, 2);
        Assert.assertArrayEquals(arr2, new int[]{2, 3});

        int[] arr3 = new int[]{1, 2};
        rotate2(arr3, 3);
        Assert.assertArrayEquals(arr3, new int[]{2, 1});
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Using Reverse approach
    //this comes in three steps:
    //  1) Reverse all elems from 0 - n-1
    //  2) Reverse first K times
    //  3) Reverse last n-K times
    public void rotate3(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] arr, int s, int e) {

        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    @Test
    public void TestReverse() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr, 2, 4);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 4, 3}, arr);
        reverse(arr, 0, 4);
        Assert.assertArrayEquals(new int[]{3, 4, 5, 2, 1}, arr);
        reverse(arr, 0, 2);
        Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
        reverse(arr, 2, 4);
        Assert.assertArrayEquals(new int[]{5, 4, 1, 2, 3}, arr);
    }

    @Test
    public void TestRotate3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(arr, 3);
        Assert.assertArrayEquals(arr, new int[]{5, 6, 7, 1, 2, 3, 4});


        arr = new int[]{-1, -100, 3, 99};
        rotate3(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{3, 99, -1, -100});


        int[] arr1 = new int[]{1, 2};
        rotate3(arr1, 2);
        Assert.assertArrayEquals(arr1, new int[]{1, 2});

        int[] arr2 = new int[]{1, 2};
        rotate3(arr2, 3);
        Assert.assertArrayEquals(arr2, new int[]{2, 1});
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Solution 4: Circular Rotation where we rotate and shift elems by k steps one time
    public void rotate4(int[] nums, int k) {

        k %= nums.length;

        int count = 0;
        //loop until we shift all elems [count = nums.length]
        for (int i = 0; count < nums.length; i++) {
            //find next elem to shift current elem to
            int next = (i + k) % nums.length;
            //prev is the current elem
            int prev = nums[i];

            //continue shifting all elems until we reach back to the same index we started with
            while (next != i) {
                //save in temp the next elem
                int temp = nums[next];
                //next elem should now have prev elem
                nums[next] = prev;
                //update prev elem with replaced elem
                prev = temp;
                //count shifted elems to make sure we shift all
                count++;
                //calc next elem to shift
                next = (next + k) % nums.length;
            }
            //after we finish all, next now points to the index we started with
            //make sure you put into it the last elem we shifted
            //check this example below where k = 2
            // 1 2 3 4 5  6
            // |-->|-->|->|
            // |<-------<-|
            nums[i] = prev;
            count++;
        }
    }

    @Test
    public void TestRotate4() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate4(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{6, 7, 1, 2, 3, 4, 5});

        arr = new int[]{-1, -100, 3, 99};
        rotate4(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{3, 99, -1, -100});


        int[] arr1 = new int[]{1, 2};
        rotate4(arr1, 2);
        Assert.assertArrayEquals(arr1, new int[]{1, 2});

        int[] arr2 = new int[]{1, 2};
        rotate4(arr2, 3);
        Assert.assertArrayEquals(arr2, new int[]{2, 1});
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Solution 6: Same as solution 5 but in a recursive way
    public void rotate5(int[] nums, int k) {

        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            count += rotate5(nums, i, k, (i + k) % nums.length, nums[i]);
        }

    }

    int rotate5(int[] nums, int startIndex, int k, int index, int prev) {
        if (startIndex == index) {
            nums[index] = prev;
            return 1;
        }
        int temp = nums[index];
        nums[index] = prev;
        return 1 + rotate5(nums, startIndex, k, (index + k) % nums.length, temp);
    }


    @Test
    public void TestRotate5() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate5(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{6, 7, 1, 2, 3, 4, 5});

        arr = new int[]{-1, -100, 3, 99};
        rotate5(arr, 2);
        Assert.assertArrayEquals(arr, new int[]{3, 99, -1, -100});


        int[] arr1 = new int[]{1, 2};
        rotate5(arr1, 2);
        Assert.assertArrayEquals(arr1, new int[]{1, 2});

        int[] arr2 = new int[]{1, 2};
        rotate5(arr2, 3);
        Assert.assertArrayEquals(arr2, new int[]{2, 1});
    }


}
