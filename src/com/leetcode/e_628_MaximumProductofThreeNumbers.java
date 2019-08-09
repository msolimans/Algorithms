package com.leetcode;

//e_628_MaximumProductofThreeNumbers 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array, find three numbers whose product is maximum and output the maximum product.
//
//Example 1:
//
//Input: [1,2,3]
//Output: 6
//
//
//Example 2:
//
//Input: [1,2,3,4]
//Output: 24
//
//
//Note:
//
//The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
//Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-product-of-three-numbers/
//******************************************************************************************************************

public class e_628_MaximumProductofThreeNumbers {


    public static void main(String[] args) {


    }

    public int maximumProduct(int[] nums) {
        //length is less than 3, return 0
        if (nums.length < 3) {
            return 0;
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        //maintain the greatest max values in the array
        //maintain the least min values in the array [bcs of negative values] only 2 to make positive
        for (int n : nums) {

            //if n greater than max3, saves max1/max2/max3
            if (n > max3) {
                max1 = max2;
                max2 = max3;
                max3 = n;
            } else if (n > max2) {//if n greater than max2, saves max1/max2
                max1 = max2;
                max2 = n;
            } else if (n > max1) {//if n greater than max1, saves max1
                max1 = n;
            }

            if (n < min2) {//if n less than min2, saves min1/min2
                min1 = min2;
                min2 = n;
            } else if (n < min1) {//if n less than min1, saves min1
                min1 = n;
            }
        }

        //which one is greater! min1, min2, max3 OR max1, max2, max3
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }

    @Test
    public void TestmaximumProduct() {
        Assert.assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
        Assert.assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(720, maximumProduct(new int[]{-4, -3, -2, -1, 60}));
        Assert.assertEquals(18, maximumProduct(new int[]{-1, -3, 6}));
        Assert.assertEquals(-18, maximumProduct(new int[]{-1, -3, -6}));
        Assert.assertEquals(216, maximumProduct(new int[]{6, -6, 6, 6}));
    }
}
