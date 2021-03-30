package com.leetcode;

//e_645_SetMismatch 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//Given an array nums representing the data status of this set after the error.
// Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
//
//Example 1:
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Note:
//The given array size will in the range [2, 10000].
//The given array's numbers won't have any order.

//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/problems/set-mismatch/
//******************************************************************************************************************

public class e_645_SetMismatch {


    public static void main(String[] args) {

    }

    //XOR all elems => will result in => MISSING ^ DUPLICATE
    //Find Duplicate
    //Remove duplicate By using XOR, this should result in XOR
    public int[] findErrorNums(int[] nums) {
        //should contain missing and duplicate XOR'd
        int xors = 0;

        for (int i = 0; i < nums.length; i++) {
            //xor index with its value
            //notice index here is not ZERO-BASED .. we start from 1
            xors ^= (i + 1) ^ nums[i];
        }

        Set<Integer> s = new HashSet<>();
        int i = 0;
        //detect duplicate
        while (i < nums.length && s.add(nums[i])) i++;

        int dup = nums[i];

        //remove duplicate from xors by making one more XOR
        int missing = xors ^ dup;

        //removing missing from xor xors ^ missing
        return new int[]{dup, missing};
    }


    public int[] findErrorNums2(int[] nums) {

        Set<Integer> s = new HashSet<>();

        int dup = 0, sum = 0, i = 0;
        //find duplicate
        while (i < nums.length) {
            if (!s.add(nums[i]))
                dup = nums[i];
            //calc sum of all elems
            sum += nums[i];
            i++;
        }

        //gauss' formula to calc sum from 1 .. n
        int n = nums.length * (nums.length + 1) / 2;


        return new int[]{dup, n - (sum - dup)/*exclude duplicate from sum (nums) to get all arrays from (1...n without missing) and then subtract result from sum (1...n) */};
    }


    //discover duplicate in an elegant way
    //each time we visit an elem, negate its index (* -1)
    //in case you get the same index, check it before you negate and if it is negative that means it is duplicated
    //to guarantee we will have right index, the higher boundary is "N" and the range from 0 .. N
    // but array starts from 0 so we need to subtract elem's value with -1 to make sure we will get a correct index
    //in case we encounter 4, this will update elem at index @3
    //in case we encounter 4 again, this will check elem at index @3 whether it is negative, if so this the duplicate [don't negate it]
    //loop thru again and check the only number that is not negative and add one to it to result in missing one
    public int[] findErrorNums3(int[] nums) {
        int dup = -1, sum = 0;
        for (int n : nums) {
            //make sure you sum correct value [positive]
            sum += Math.abs(n);
            //if it is negative, means it was viisted or encountered before => this is our duplicate
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                //mark it as visited => just negate its value
                nums[Math.abs(n) - 1] *= -1;

        }

        //find the missing
        int n = nums.length * (nums.length + 1) / 2;

        return new int[]{dup, n - (sum - dup)};
    }


    @Test
    public void TestFindErrorNums() {


        Assert.assertArrayEquals(new int[]{4, 7}, findErrorNums(new int[]{1, 4, 3, 4, 2, 6, 5}));
        Assert.assertArrayEquals(new int[]{4, 5}, findErrorNums(new int[]{4, 2, 3, 1, 4}));

        Assert.assertArrayEquals(new int[]{4, 7}, findErrorNums2(new int[]{1, 4, 3, 4, 2, 6, 5}));
        Assert.assertArrayEquals(new int[]{4, 5}, findErrorNums2(new int[]{4, 2, 3, 1, 4}));

        Assert.assertArrayEquals(new int[]{4, 5}, findErrorNums3(new int[]{4, 2, 3, 1, 4}));
    }

}
