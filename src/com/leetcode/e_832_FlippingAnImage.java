package com.leetcode;

//832: Flipping An Image
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//
//To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
//To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//
//Example 1:
//
//Input: [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//Example 2:
//
//Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
//Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//Notes:
//
//1 <= A.length = A[0].length <= 20
//0 <= A[i][j] <= 1

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/flipping-an-image/
//******************************************************************************************************************

public class e_832_FlippingAnImage {


    public static void main(String[] args) {
        int[][] a = new e_832_FlippingAnImage().flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.print("\n");
        }

    }

    public int[][] flipAndInvertImage(int[][] A) {
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            int s = 0;
            int e = A[i].length - 1;
            while (s <= e) {
                temp = A[i][s] ^ 1;
                //xor 0 X 1 = 1
                //    1 X 1 = 0
                A[i][s] = A[i][e] ^ 1;
                A[i][e] = temp;
                s++;
                e--;
            }
        }

        return A;
    }

    @Test
    public void TestflipAndInvertImage() {
        Assert.assertArrayEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}, flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
        Assert.assertArrayEquals(new int[][]{{1, 0, 0}}, flipAndInvertImage(new int[][]{{1, 1, 0}}));
        Assert.assertArrayEquals(new int[][]{{0}}, flipAndInvertImage(new int[][]{{1}}));
        Assert.assertArrayEquals(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}, flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
    }

}
