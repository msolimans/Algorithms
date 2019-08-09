package com.leetcode;

//m_74_Searcha2DMatrix
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//Example 1:
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
//Example 2:
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/search-a-2d-matrix/
//******************************************************************************************************************

public class m_74_Searcha2DMatrix {


    public static void main(String[] args) {
        System.out.println(new m_74_Searcha2DMatrix().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 23));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        //if matrix's empty, return false
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int lastRowIndx = matrix.length - 1;

        //pass number of cols
        int lastColIndx = matrix[0].length - 1;

        //find the right row in which our target might be within its range
        return findInRow(matrix, 0, lastRowIndx, lastColIndx, target);
    }


    public boolean findInRow(int[][] matrix, int start, int end, int cols, int target) {
        //if end less start, we're out of search range , return false
        //if start less than zero or greater than last row's index, we're out of search boundary, return false
        //if end less than zero or greater than last row's index, we're out of range, return false
        if (end < start || start > matrix.length - 1 || start < 0 || end < 0 || end > matrix.length - 1 || (start == end && (target < matrix[start][0] || target > matrix[start][cols])))
            return false;

        //find the mid
        int midi = (start + end) / 2;

        //check where the target may exist?
        //if it's within the range between first and last elem in that row, call findInCol to try to find it inside this row
        if (target >= matrix[midi][0] && target <= matrix[midi][cols]) {
            //find it
            return findInCol(matrix, 0, cols, midi, target);
        } else if (target < matrix[midi][0]) {//if target is less than first elem in the row, shrink search area - start ... mid - 1
            return findInRow(matrix, start, midi - 1, cols, target);
        } else//otherwise shrink search area - mid + 1 ... end
            return findInRow(matrix, midi + 1, end, cols, target);

    }

    //findInCol search for a target in in specific rowIndx by going thru cols inside that row and returns whether it exists?
    //same concept as binary search we did earlier but in row
    public boolean findInCol(int[][] matrix, int start, int end, int rowIndx, int target) {
        if (end < start || start < 0 || start > matrix[0].length - 1 || end < 0 || end > matrix[0].length - 1)
            return false;

        if (start == end && (target < matrix[rowIndx][start] || target > matrix[rowIndx][end]))
            return false;

        int midj = (start + end) / 2;


        if (target == matrix[rowIndx][midj]) {
            return true;
        } else if (target < matrix[rowIndx][midj]) {
            return findInCol(matrix, start, midj - 1, rowIndx, target);
        } else
            return findInCol(matrix, midj + 1, end, rowIndx, target);

    }


    //Unit tests

    @Test
    public void TestSearchMatrix() {
        Assert.assertEquals(false, searchMatrix(new int[][]{}, 3));

        Assert.assertEquals(false, searchMatrix(new int[][]{{}}, 3));

        Assert.assertEquals(true, searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));

        Assert.assertEquals(true, searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 23));

        Assert.assertEquals(false, searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0));

        Assert.assertEquals(true, searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 50));


    }

    @Test
    public void TestFindInCol() {

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 0, 3));

        Assert.assertEquals(false, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 0, 4));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 1, 11));

        Assert.assertEquals(false, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 1, 30));

        Assert.assertEquals(false, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 1, 7));

        Assert.assertEquals(false, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 0, 0));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 2, 50));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 2, 23));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 2, 30));


        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 3, 2, 34));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 60}
        }, 0, 4, 2, 34));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 60}
        }, 0, 4, 2, 50));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 60}
        }, 0, 4, 2, 60));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 60}
        }, 0, 4, 2, 23));

        Assert.assertEquals(true, findInCol(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 60}
        }, 0, 4, 2, 30));


    }


    @Test
    public void TestFindInRow() {


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 9));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 52));

        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 21));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 17));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 12));

        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 1));


        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7, 8},
                {10, 11, 16, 20, 21},
                {23, 30, 34, 50, 51},
                {60, 70, 80, 90, 91}
        }, 0, 3, 4, 91));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {60, 70, 80, 90}
        }, 0, 3, 3, 4));

        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {60, 70, 80, 90}
        }, 0, 3, 3, 3));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {60, 70, 80, 90}
        }, 0, 3, 3, 0));


        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {60, 70, 80, 90}
        }, 0, 3, 3, 80));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {60, 70, 80, 90}
        }, 0, 3, 3, 100));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 28));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 60));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 8));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 0));

        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 4));

        Assert.assertEquals(true, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 3));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 0));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 8));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 21));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 60));


        Assert.assertEquals(false, findInRow(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 0, 2, 3, 4));


    }

}
