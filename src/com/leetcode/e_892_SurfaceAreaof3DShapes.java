package com.leetcode;

//e_892_SurfaceAreaof3DShapes
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//On a N * N grid, we place some 1 * 1 * 1 cubes.
//
//Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//
//Return the total surface area of the resulting shapes.
//
//
//
//Example 1:
//
//Input: [[2]]
//Output: 10
//Example 2:
//
//Input: [[1,2],[3,4]]
//Output: 34
//Example 3:
//
//Input: [[1,0],[0,2]]
//Output: 16
//Example 4:
//
//Input: [[1,1,1],[1,0,1],[1,1,1]]
//Output: 32
//Example 5:
//
//Input: [[2,2,2],[2,1,2],[2,2,2]]
//Output: 46
//
//
//Note:
//
//1 <= N <= 50
//0 <= grid[i][j] <= 50

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_892_SurfaceAreaof3DShapes {


    public static void main(String[] args) {
        System.out.println(new e_892_SurfaceAreaof3DShapes().surfaceArea(new int[][]{{2}}));
    }

    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                //top and bottom of cube, for each grid cell that does have a value greater than zero, calc the bottom and top of cube which is "2"
                if (grid[i][j] > 0)
                    area += 2;

                //first row [back side of cube]
                if (i == 0) {
                    area += grid[0][j];
                }
                //first column [left side of cube]
                if (j == 0) {
                    area += grid[i][0];
                }

                //last row [front side of cube]
                if (i == grid.length - 1) {
                    area += grid[i][j];
                }
                //column of current row's is the last one, [right side of cube]
                if (j == grid[i].length - 1) {
                    area += grid[i][j];
                }

                //anything before last row, calc the diff between cubes only
                if (i < grid.length - 1) {
                    area += Math.abs(grid[i][j] - grid[i + 1][j]);
                }

                //anything before last column, calc the diff between cubes only
                if (j < grid.length - 1) {
                    area += Math.abs(grid[i][j] - grid[i][j + 1]);
                }

            }
        }

        return area;
    }

    @Test
    public void TestSurfaceArea() {
        Assert.assertEquals(10, surfaceArea(new int[][]{{2}}));
        Assert.assertEquals(32, surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        Assert.assertEquals(46, surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
