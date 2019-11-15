package com.leetcode;

//m_59_SpiralMatrixII 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//Example:
//
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
//******************************************************************************************************************
//Companies: Amazon, Microsoft, Adobe, Yandex
//******************************************************************************************************************
//Link: https://leetcode.com/problems/spiral-matrix-ii/
//******************************************************************************************************************

public class m_59_SpiralMatrixII {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new m_59_SpiralMatrixII().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int rs = 0, re = n - 1, cs = 0, ce = n - 1;
        int count = 1;

        while (rs <= re && cs <= ce) {

            for (int i = cs; i <= ce; i++) {
                result[rs][i] = count++;
            }

            rs++;

            for (int i = rs; i <= re; i++) {
                result[i][ce] = count++;
            }
            ce--;

            //we might have done all cols and rows here
            if (rs <= re && cs <= ce) {
                for (int i = ce; i >= cs; i--) {
                    result[re][i] = count++;
                }
                re--;

                for (int i = re; i >= rs; i--)
                    result[i][cs] = count++;

                cs++;
            }


        }

        return result;
    }

    @Test
    public void TestgenerateMatrix() {

        Assert.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, generateMatrix(3));
        Assert.assertArrayEquals(new int[][]{{1, 2}, {4, 3}}, generateMatrix(2));
        Assert.assertArrayEquals(new int[][]{{1}}, generateMatrix(1));
        Assert.assertArrayEquals(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}, generateMatrix(4));
        Assert.assertArrayEquals(new int[][]{}, generateMatrix(0));
    }


}
