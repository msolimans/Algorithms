package com.leetcode;

//e_1196_HowManyApplesCanYouPutintotheBasket 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
//
//Return the maximum number of apples you can put in the basket.
//
//
//
//Example 1:
//
//Input: arr = [100,200,150,1000]
//Output: 4
//Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
//Example 2:
//
//Input: arr = [900,950,800,1000,700,800]
//Output: 5
//Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.
//
//
//Constraints:
//
//1 <= arr.length <= 10^3
//1 <= arr[i] <= 10^3

//******************************************************************************************************************
//Companies: Virtu Financial
//******************************************************************************************************************
//Link: https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
//******************************************************************************************************************

public class e_1196_HowManyApplesCanYouPutintotheBasket {


    public static void main(String[] args) {


    }

    //Greedy Algorithm
    //2 Approaches:
    // 1) you can sort them and start from smallest to the bigger
    // 2) store in min heap, pop from it the apples with min weight as long as the total weight doesn't exceed 5000
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int i = 0, sum = 0;

        while (i < arr.length) {
            if (sum + arr[i] > 5000)
                break;
            sum += arr[i++];
        }


        return i;
    }

    //Greedy Algorithm
    //2 Approaches:
    // 1) you can sort them and start from smallest to the bigger
    // 2) store in min heap, pop from it the apples with min weight as long as the total weight doesn't exceed 5000
    public int maxNumberOfApples2(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr)
            pq.add(i);

        int sum = 0, count = 0;
        while (!pq.isEmpty()) {
            if (sum + pq.peek() > 5000)
                break;

            sum += pq.poll();
            count++;
        }

        return count;
    }


    @Test
    public void TestMaxNumberOfApples() {
        Assert.assertEquals(4, maxNumberOfApples(new int[]{100, 200, 150, 1000}));
        Assert.assertEquals(0, maxNumberOfApples(new int[]{}));
        Assert.assertEquals(1, maxNumberOfApples(new int[]{2}));
        Assert.assertEquals(5, maxNumberOfApples(new int[]{900, 950, 800, 1000, 700, 800}));


        Assert.assertEquals(4, maxNumberOfApples2(new int[]{100, 200, 150, 1000}));
        Assert.assertEquals(5, maxNumberOfApples2(new int[]{900, 950, 800, 1000, 700, 800}));

    }


}
