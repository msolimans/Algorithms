package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

//1470. Shuffle the Array
//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//
//Return the array in the form [x1,y1,x2,y2,...,xn,yn].
//
//
//
//Example 1:
//
//Input: nums = [2,5,1,3,4,7], n = 3
//Output: [2,3,5,4,1,7]
//Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
//Example 2:
//
//Input: nums = [1,2,3,4,4,3,2,1], n = 4
//Output: [1,4,2,3,3,2,4,1]
//Example 3:
//
//Input: nums = [1,1,2,2], n = 2
//Output: [1,2,1,2]
//
//
//Constraints:
//
//1 <= n <= 500
//nums.length == 2n
//1 <= nums[i] <= 10^3
public class e_1470_ShuffletheArray {
    //O(n) with extra storage O(n/2)
    public int[] shuffle(int[] nums, int n) {
        //save first half in extra storage for simple shuffling
        int[] half = new int[n - 1];
        for (int i = 1; i < n; i++) {
            half[i - 1] = nums[i];
        }

        int x = 0;
        int y = n;
        //loop thru array from 1 ... n-1
        //spread elems based on index - we can put elems in odd indices from second half of array while even ones from the first half of the array
        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 == 0)
                nums[i] = half[x++];
            else
                nums[i] = nums[y++];
        }

        //return result
        return nums;
    }



    @Test
    public void TestShuffle() {
        Assert.assertArrayEquals(new int[]{2, 3, 5, 4, 1, 7}, shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        Assert.assertArrayEquals(new int[]{1,4,2,3,3,2,4,1}, shuffle(new int[]{1,2,3,4,4,3,2,1}, 4));
        Assert.assertArrayEquals(new int[]{1,4}, shuffle(new int[]{1,4}, 2));
        Assert.assertArrayEquals(new int[]{1,4,3,2}, shuffle(new int[]{1,3,4,2}, 2));
    }
}
