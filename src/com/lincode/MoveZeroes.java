package com.lincode;

import java.util.Arrays;

/**
 * Created by msoliman on 2/16/17.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(moveZeroes(new int[]{1,2,3,0,0})));
    }

//    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//    Notice
//
//    You must do this in-place without making a copy of the array.
//    Minimize the total number of operations.
//
//    Example
//    Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
    static int[] moveZeroes(int[] nums) {
        for (int i = 0; i <= nums.length - 2; i++) {
            if(nums[i] != 0)
                continue;

            int next = i + 1;

            while (next <= nums.length - 1 && nums[next] == 0)
                if(next==nums.length-1)
                    break;
                else
                    next++;

            //swap
            nums[i] = nums[next];
            nums[next] = 0;
        }

        return nums;


    }
}
