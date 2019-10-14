package com.leetcode;

//e_122_BestTimeToBuyAndSellStockII 
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
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//Example 1:
//
//Input: [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Example 2:
//
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//             engaging multiple transactions at the same time. You must sell before buying again.
//Example 3:
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//******************************************************************************************************************

public class e_122_BestTimeToBuyAndSellStockII {


    public static void main(String[] args) {
System.out.println(new e_122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{1,7,7,10}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int p = Integer.MAX_VALUE;
        boolean buy = true;
        boolean sell = false;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            //time to buy:
            // 1) we're allowed to buy
            // 2) as long as we today's price that's less than previous day
            // 3) and tomorrow's prc is > today's
            if (buy && prices[i] < p && i < prices.length - 1 && prices[i + 1] > prices[i]) {
                buy = false;
                sell = true;
                p = prices[i];

            //we sell when:
                // 1) we are allowed to [we bought somethin before]
                // 2) today's price is > yesterday's prc
                // 3) no more days for stock [today is the last] or tomorrow's price is less than today's one
            } else if (sell && prices[i] > p && (i == prices.length - 1 || i < prices.length - 1 && prices[i + 1] < prices[i])) {
                profit += prices[i] - p;
                p = prices[i];
                sell = false;
                buy = true;
            }

        }


        return profit;

    }

    @Test
    public void TestMaxProfit() {
        Assert.assertEquals(8, maxProfit(new int[]{1,7,7,9}));
        Assert.assertEquals(0, maxProfit(new int[]{7}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 1}));
        Assert.assertEquals(6, maxProfit(new int[]{1, 7}));
        Assert.assertEquals(7, maxProfit(new int[]{1, 7,8}));
        Assert.assertEquals(6, maxProfit(new int[]{1, 7,1}));
        Assert.assertEquals(6, maxProfit(new int[]{1, 7,1,1}));
        Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }
}
