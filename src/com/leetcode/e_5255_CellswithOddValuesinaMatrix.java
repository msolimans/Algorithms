package com.leetcode;

//e_5255_CellswithOddValuesinaMatrix
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
//
//Return the number of cells with odd values in the matrix after applying the increment to all indices.
//
//
//
//Example 1:
//
//
//Input: n = 2, m = 3, indices = [[0,1],[1,1]]
//Output: 6
//Explanation: Initial matrix = [[0,0,0],[0,0,0]].
//After applying first increment it becomes [[1,2,1],[0,1,0]].
//The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
//Example 2:
//
//
//Input: n = 2, m = 2, indices = [[1,1],[0,0]]
//Output: 0
//Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
//
//
//Constraints:
//
//1 <= n <= 50
//1 <= m <= 50
//1 <= indices.length <= 100
//0 <= indices[i][0] < n
//0 <= indices[i][1] < m

//******************************************************************************************************************
//Companies: Contest
//******************************************************************************************************************
//Link: https://leetcode.com/contest/weekly-contest-162/problems/cells-with-odd-values-in-a-matrix/
//******************************************************************************************************************

public class e_5255_CellswithOddValuesinaMatrix {


    public static void main(String[] args) {


    }

    public int oddCells(int n, int m, int[][] indices) {
        if (n == 0 && m == 0)
            return 0;

        int[][] res = new int[n][m];

        if (indices == null || indices.length == 0)
            return 0;


        for (int[] indx : indices) {
            int ci = indx[0];
            int cj = indx[1];
            //2,3
            for (int i = 0; i < n; i++) {
                res[i][cj]++;
            }

            for (int j = 0; j < m; j++) {
                res[ci][j]++;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] % 2 > 0)
                    count++;
            }
        }

        return count;

    }

    @Test
    public void TestOddCalls() {

        Assert.assertEquals(2, oddCells(1, 3, new int[][]{{0, 1}, {0, 2}}));
        Assert.assertEquals(6, oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        Assert.assertEquals(0, oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
        Assert.assertEquals(0, oddCells(2, 2, null));
    }


}
