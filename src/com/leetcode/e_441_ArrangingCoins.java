package com.leetcode;

//e_441_ArrangingCoins
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
//Given n, find the total number of full staircase rows that can be formed.
//
//n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
//Example 1:
//
//n = 5
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤
//
//Because the 3rd row is incomplete, we return 2.
//Example 2:
//
//n = 8
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//Because the 4th row is incomplete, we return 3.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/arranging-coins/
//******************************************************************************************************************

public class e_441_ArrangingCoins {


    public static void main(String[] args) {
        System.out.println(new e_441_ArrangingCoins().arrangeCoins(5));
    }

    public int arrangeCoins(int n) {
        //count to preserve how many stairs
        int count = 0;

        for (int i = 1; ; i++) {
            //in case we running out of what's left or the reminaing is not enough to build a new stair row/level we break the loop
            if (n == 0 || n - i < 0)
                break;

            //otherwise, subtract from n what we need in this row to build
            n -= i;
            //add 1 to count
            count++;
        }

        return count;
    }

    @Test
    public void TestArrangeCoins() {
        Assert.assertEquals(2, arrangeCoins(5));
        Assert.assertEquals(3, arrangeCoins(8));
    }

}
