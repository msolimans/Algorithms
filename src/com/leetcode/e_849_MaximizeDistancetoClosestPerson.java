package com.leetcode;

//849. Maximize Distance to Closest Person
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
// In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
//
//There is at least one empty seat, and at least one person sitting.
//
//Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
//
//Return that maximum distance to closest person.
//
//Example 1:
//
//Input: [1,0,0,0,1,0,1]
//Output: 2
//Explanation:
//If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
//If Alex sits in any other open seat, the closest person has distance 1.
//Thus, the maximum distance to the closest person is 2.
//Example 2:
//
//Input: [1,0,0,0]
//Output: 3
//Explanation:
//If Alex sits in the last seat, the closest person is 3 seats away.
//This is the maximum distance possible, so the answer is 3.
//Note:
//
//1 <= seats.length <= 20000
//seats contains only 0s or 1s, at least one 0, and at least one 1.
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximize-distance-to-closest-person/
//******************************************************************************************************************

public class e_849_MaximizeDistancetoClosestPerson {

    public static void main(String[] args) {
        System.out.println(new e_849_MaximizeDistancetoClosestPerson().maxDistToClosest(new int[]{1, 0}));
    }

    //O(n) soln
    //loop through array of seats, count all empty seats and do the following rules:
    // if counted empty seats were between 2 booked seats you divide by 2 (to sit in the middle or as far as you can from both) e.g. 1 0 0 0 1
    // if empty seats only has one side [reserved, either left or right] count all empty seats to sit in the very end far from the last reserved seat e.g. 0 0 0 0 1 OR 1 0 0 0 0
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int current = 0;
        boolean visitOne = false;

        for (int i = 0; i < seats.length; i++) {


            if (seats[i] == 1) {
                if (visitOne) {
                    if (current % 2 > 0)//if it's odd, add 1
                        current = (current / 2) + 1;
                    else
                        current = current / 2; //even, just divide /2
                }

                //store the max count in max
                if (current > max)
                    max = current;

                //reset current
                current = 0;

                visitOne = true;
            } else {
                current++;
                //if no one at the right side of seats e.g. 1 0 0 0 we have to compare current empty seats with max here
                if (i == seats.length - 1) {
                    if (current > max)
                        max = current;
                }
            }
        }

        return max;
    }

    @Test
    public void TestmaxDistToClosest() {
        Assert.assertEquals(1, maxDistToClosest(new int[]{1, 0}));
        Assert.assertEquals(1, maxDistToClosest(new int[]{0, 1}));
        Assert.assertEquals(1, maxDistToClosest(new int[]{1, 0, 0, 1}));
        Assert.assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));

        Assert.assertEquals(1, maxDistToClosest(new int[]{1, 0, 0, 1, 0, 1}));
        Assert.assertEquals(3, maxDistToClosest(new int[]{0, 0, 0, 1}));
        Assert.assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
        Assert.assertEquals(1, maxDistToClosest(new int[]{1, 0, 0, 1}));
        Assert.assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 1, 0, 0, 0, 0, 0, 1}));
        Assert.assertEquals(3, maxDistToClosest(new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 1}));
        Assert.assertEquals(5, maxDistToClosest(new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0}));


    }
}
