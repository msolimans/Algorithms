package com.leetcode;

//e_605_CanPlaceFlowers 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Suppose you have a long flowerbed in which some of the plots are planted and some are not. However,
// flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
//Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
// and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
//
//Example 1:
//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: True
//Example 2:
//Input: flowerbed = [1,0,0,0,1], n = 2
//Output: False
//Note:
//The input array won't violate no-adjacent-flowers rule.
//The input array size is in the range of [1, 20000].
//n is a non-negative integer which won't exceed the input array size.
//******************************************************************************************************************
//Companies: LinkedIn
//******************************************************************************************************************
//Link: https://leetcode.com/problems/can-place-flowers/
//******************************************************************************************************************

public class e_605_CanPlaceFlowers {


    public static void main(String[] args) {


    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //if n is greater than half of n elems + 1, return false
        if (n > (flowerbed.length + 1) / 2)
            return false;

        int i = 0;
        while (i < flowerbed.length) {
            //if 1 encountered, make 2 jumps
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }

            //if first elem, with an array that has 1 elem or more elems such that elem at 2nd index is zero
            if (i == 0 && ((flowerbed.length == 1) || (flowerbed.length > 1 && flowerbed[1] == 0))) {
                n--;
                flowerbed[i] = 1;
                //if elem is the last one in the array, such that previous one was zero as well
            } else if (i == flowerbed.length - 1 && flowerbed.length - 2 >= 0 && flowerbed[flowerbed.length - 2] == 0) {
                n--;
                flowerbed[i] = 1;
                //in the middle, make sure both left side and right side are both empty [zero]
            } else if (i - 1 >= 0 && flowerbed[i - 1] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }

            //in case n reached to zero, no need to continue as we make sure we can fill it with n elems/flowers
            if (n == 0)
                return true;

            i++;
        }


        return n <= 0;
    }

    @Test
    public void TestcanPlaceFlowers() {
        Assert.assertTrue(canPlaceFlowers(new int[]{0, 0, 0}, 2));
        Assert.assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        Assert.assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        Assert.assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));

        Assert.assertTrue(canPlaceFlowers(new int[]{0, 0, 0, 0, 1}, 2));
        Assert.assertTrue(canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0}, 2));
        Assert.assertTrue(canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 3));
        Assert.assertTrue(canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, 3));
        Assert.assertTrue(canPlaceFlowers(new int[]{0}, 1));
        Assert.assertFalse(canPlaceFlowers(new int[]{1}, 1));
        Assert.assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0}, 3));
    }

}
