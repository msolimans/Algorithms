package com.leetcode;

//e_121_BestTimeToBuyAndSellStock 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Note that you cannot sell a stock before you buy one.
//
//Example 1:
//
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
//Example 2:
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//******************************************************************************************************************

public class e_121_BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        System.out.println(new e_121_BestTimeToBuyAndSellStock().maxProfit(new int[]{1, 3, 4, 6}));

    }

    public int maxProfit(int[] prices) {
        int ibuy = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            //if current elem is less than previous buy, update index of buy
            if (prices[i] < prices[ibuy]) {
                ibuy = i;
                continue;
            }
            //check subsequent elems, if they're making bigger profit record it
            if (i > ibuy && prices[i] - prices[ibuy] > profit)
                profit = prices[i] - prices[ibuy];
        }

        return profit;
    }

    @Test
    public void TestMaxProfit() {
        Assert.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assert.assertEquals(8, maxProfit(new int[]{1, 7, 7, 9}));

        Assert.assertEquals(6, maxProfit(new int[]{1, 7, 1}));
        Assert.assertEquals(6, maxProfit(new int[]{1, 7, 1, 1}));


        Assert.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));

        Assert.assertEquals(0, maxProfit(new int[]{7, 1}));
        Assert.assertEquals(6, maxProfit(new int[]{1, 7}));
        Assert.assertEquals(7, maxProfit(new int[]{1, 7, 8}));

    }
}
