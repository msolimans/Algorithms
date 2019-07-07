package com.leetcode;

//807. Max Increase to Keep City Skyline
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
// In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.
//
//At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
//
//What is the maximum total sum that the height of the buildings can be increased?
//
//Example:
//Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
//Output: 35
//Explanation:
//The grid is:
//[ [3, 0, 8, 4],
//  [2, 4, 5, 7],
//  [9, 2, 6, 3],
//  [0, 3, 1, 0] ]
//
//The skyline viewed from top or bottom is: [9, 4, 8, 7]
//The skyline viewed from left or right is: [8, 7, 9, 3]
//
//The grid after increasing the height of buildings without affecting skylines is:
//
//gridNew = [ [8, 4, 8, 7],
//            [7, 4, 7, 7],
//            [9, 4, 8, 7],
//            [3, 3, 3, 3] ]
//
//Notes:
//
//1 < grid.length = grid[0].length <= 50.
//All heights grid[i][j] are in the range [0, 100].
//All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.
//******************************************************************************************************************
//Companies: N.A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/max-increase-to-keep-city-skyline/
//******************************************************************************************************************

public class m_807_MaxIncreasetoKeepCitySkyline {
    public static void main(String[] args) {
        int[][] gridNew = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        System.out.println(new m_807_MaxIncreasetoKeepCitySkyline().maxIncreaseKeepingSkyline(gridNew));
        for (int i = 0; i < gridNew.length; i++) {
            for (int j = 0; j < gridNew[i].length; j++) {
                System.out.printf("%s  ", gridNew[i][j]);
            }

            System.out.print("\n");
        }
    }


    //First collect and save max elem for each row into an auxiliary space (HashMap),
    // then traverse by column to compare each element with the max of current column
    // and max of current row (that was collected and saved in auxiliary space
    //Time complexity O(n)
    //Auxiliary space O(NoOfRows)
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        HashMap<Integer, Integer> rowMax = new HashMap<>();

        //calc max elem per row
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            rowMax.put(i, max);
        }

        int result = 0;

        //only traverse by colmn now
        for (int j = 0; j < grid[0].length; j++) {
            int max = grid[0][j];
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }

            //update every elem inside col with the max elem per colm such that it doesn't exceed rowMax we collected earlier
            for (int i = 0; i < grid.length; i++) {
                //if elem is greater than the max(col) and max(col) is less than max(row) then we can update this elem safely
                if (grid[i][j] < max) { //only less than to skip max elem itself
                    int update = 0;

                    if (max <= rowMax.get(i)) {
                        update = max;
                    } else {
                        update = rowMax.get(i);
                    }
                    //add to the result
                    result += update - grid[i][j];
                    //update elem
                    grid[i][j] = update;
                }
            }

        }

        return result;
    }

    @Test
    public void TestmaxIncreaseKeepingSkyline() {
        int[][] gridNew = new int[][]{
                {8, 4, 8, 7},
                {7, 4, 7, 7},
                {9, 4, 8, 7},
                {3, 3, 3, 3}};
        Assert.assertEquals(0, maxIncreaseKeepingSkyline(gridNew));

        gridNew = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        Assert.assertEquals(35, maxIncreaseKeepingSkyline(gridNew));

        gridNew = new int[][]{
                {3, 0, 8, 4}};
        Assert.assertEquals(0, maxIncreaseKeepingSkyline(gridNew));


        gridNew = new int[][]{
                {3, 0, 8, 4}, {1, 1, 1, 1}};
        Assert.assertEquals(1, maxIncreaseKeepingSkyline(gridNew));
    }


}
