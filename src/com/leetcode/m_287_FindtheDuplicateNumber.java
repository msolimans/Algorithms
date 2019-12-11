package com.leetcode;

//m_287_FindtheDuplicateNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * HashSet, Sorting, Arrays, Floyd's Tortoise-Hare Algorithm
 */

/*Description*/
//******************************************************************************************************************
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//Example 1:
//
//Input: [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: [3,1,3,4,2]
//Output: 3
//Note:
//
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.

//******************************************************************************************************************
//Companies: Amazon | 5  Microsoft | 2  Google | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/find-the-duplicate-number/
//******************************************************************************************************************

public class m_287_FindtheDuplicateNumber {


    public static void main(String[] args) {


    }

    //Naive answer, sort array and check the duplicate however in the notes, we can't change array
    public int findDuplicate0(int[] nums) {
        if (nums.length <= 1)
            return -1;

        //O(nlogn)
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }

        return -1;
    }


    //also another solution is to use hashset
    //but again it is in one of the notes where it said we must use constant space O(1)
    public int findDuplicate1(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return i;
            set.add(i);
        }

        return -1;
    }

    //this mutates array which is not acceptable answer as well based on one of the notes but it's O(n)
    public int findDuplicate2(int[] nums) {

        //since 0 is not considered as not valid, as the range is between 1 to n + 1 => so we can swap elems with that elem at index 0
        //it is some sort of bucket sorting until we end up with elem at index @0 equals elems at index nums[0]
        //0, 1, 2, 3, 4
        //1, 3, 4, 2, 2
        ///////////////
        //swap 1 at index 0 with 3 at index 1
        //3  1  4, 2, 2
        //swap 2 at index 0 with 4 at index 2
        //2  1, 4, 3, 2
        //swap 4 at index 0 with 2 at index 4
        //4  1, 2, 3, 2
        //2 == elem at index @2 => exit while loop
        //2  1, 2, 3, 4

        //return elem at 0 as answer

        while (nums[0] != nums[nums[0]]) {
            int t = nums[0];
            nums[0] = nums[nums[0]];
            nums[t] = t;
        }

        return nums[0];
    }



    public int findDuplicate(int[] nums) {
        //tortoise-hare algorithm to detect cycles
        int tortoise = nums[0];//one jump
        int hare = nums[0];
        hare = nums[hare];//2 jumps

        while (nums[tortoise] != nums[hare]) {
            //tortoise is slower,  only one jump at atime
            tortoise = nums[tortoise];
            //hare is faster, 2 jumps at atime
            hare = nums[hare];
            hare = nums[hare];//can be abbreviated to hare = nums[nums[hare]];
        }

        //once detected 2 exact matches, it might be same elem or index like this example
        // 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 if we run only the first while loop we will get result as 7 which is not true

        //So we need to detect actual duplication
        //with 2 pointers and one jump at atime [both are slow] until we get the 2 pointers pointing to 2 similar elems at different indexes [guaranteed]
        int p1 = 0;
        int p2 = tortoise;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }


    @Test
    public void TestFindDuplicate() {
        Assert.assertEquals(2, findDuplicate0(new int[]{1, 3, 4, 2, 2}));
        Assert.assertEquals(3, findDuplicate0(new int[]{3, 1, 3, 4, 2}));

        Assert.assertEquals(2, findDuplicate1(new int[]{1, 3, 4, 2, 2}));
        Assert.assertEquals(3, findDuplicate1(new int[]{3, 1, 3, 4, 2}));

        Assert.assertEquals(2, findDuplicate2(new int[]{1, 3, 4, 2, 2}));
        Assert.assertEquals(3, findDuplicate2(new int[]{3, 1, 3, 4, 2}));


        Assert.assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
        Assert.assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
        Assert.assertEquals(9, findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));

    }


}
