package com.leetcode;

//e_27_RemoveElement 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//Example 1:
//
//Given nums = [3,2,2,3], val = 3,
//
//Your function should return length = 2, with the first two elements of nums being 2.
//
//It doesn't matter what you leave beyond the returned length.
//Example 2:
//
//Given nums = [0,1,2,2,3,0,4,2], val = 2,
//
//Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
//
//Note that the order of those five elements can be arbitrary.
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
//int len = removeElement(nums, val);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len elements.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/remove-element/
//******************************************************************************************************************

public class e_27_RemoveElement {


    public static void main(String[] args) {
        System.out.println(new e_27_RemoveElement().removeElement(new int[]{1,2,3,4},2));
    }

    public int removeElement(int[] nums, int val) {

        //keeps track of last index where our result array will have elems excluding passed `val`
        int vindex = 0;
        for (int i = 0; i < nums.length; i++) {
            //if current elem not equal val, either we move tracker [vindex] or [update and move index as well]
            if (nums[i] != val) {
                //in this case where current elem doesn't equal `val` and indicator points to current element e.g. index=0 1,,... val=2
                if (vindex == i)
                    vindex++;
                else {
                    //we move current elem to last index where we stop our indicator once we encountered `val`  then increase vindex for next moves
                    nums[vindex++] = nums[i];
                }
            }
        }

        return vindex ;
    }

    @Test
    public void TestRemoveElement() {
        Assert.assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
        Assert.assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        Assert.assertEquals(3, removeElement(new int[]{0,1,2,3}, 2));
        Assert.assertEquals(4, removeElement(new int[]{0,1,2,3}, 33));
        Assert.assertEquals(1, removeElement(new int[]{0}, 33));
        Assert.assertEquals(1, removeElement(new int[]{3,2,3,3,3}, 3));
    }

}
