package com.leetcode;

//m_5256_Reconstructa2RowBinaryMatrix
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given the following details of a matrix with n columns and 2 rows :
//
//The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
//The sum of elements of the 0-th(upper) row is given as upper.
//The sum of elements of the 1-st(lower) row is given as lower.
//The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
//Your task is to reconstruct the matrix with upper, lower and colsum.
//
//Return it as a 2-D integer array.
//
//If there are more than one valid solution, any of them will be accepted.
//
//If no valid solution exists, return an empty 2-D array.
//
//
//
//Example 1:
//
//Input: upper = 2, lower = 1, colsum = [1,1,1]
//Output: [[1,1,0],[0,0,1]]
//Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
//Example 2:
//
//Input: upper = 2, lower = 3, colsum = [2,2,1,1]
//Output: []
//Example 3:
//
//Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
//Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
//
//
//Constraints:
//
//1 <= colsum.length <= 10^5
//0 <= upper, lower <= colsum.length
//0 <= colsum[i] <= 2

//******************************************************************************************************************
//Companies: Contest
//******************************************************************************************************************
//Link: https://leetcode.com/contest/weekly-contest-162/problems/reconstruct-a-2-row-binary-matrix/
//******************************************************************************************************************

public class m_5256_Reconstructa2RowBinaryMatrix {


    public static void main(String[] args) {
        List<List<Integer>> act = new m_5256_Reconstructa2RowBinaryMatrix().reconstructMatrix(2, 1, new int[]{1, 1, 1});
        System.out.println(Arrays.toString(act.toArray()));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == 2) {
                if (upper > 0 && lower > 0) {
                    colsum[i] = -1;
                    upper--;
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }

        }

        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == -1) {
                result1.add(1);
                result2.add(1);
                continue;
            }

            if (colsum[i] > 0 && upper > 0) {
                colsum[i]--;
                upper--;
                result1.add(1);
            } else {
                result1.add(0);
            }

            if (colsum[i] > 0 && lower > 0) {
                colsum[i]--;
                lower--;
                result2.add(1);
            } else {
                result2.add(0);
            }

            if (colsum[i] > 0)
                return new ArrayList<>();
        }

        if (upper > 0 || lower > 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);

        return result;
    }


    @Test
    public void TestreconstructMatrix() {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1, 1, 0));
        res.add(Arrays.asList(0, 0, 1));
        List<List<Integer>> act = reconstructMatrix(2, 1, new int[]{1, 1, 1});
        Assert.assertEquals(res, act);

        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> act1 = reconstructMatrix(2, 3, new int[]{2, 2, 1, 1});
        Assert.assertEquals(res1, act1);


        List<List<Integer>> res2 = new ArrayList<>();
        res2.add(Arrays.asList(1, 1, 1, 0, 1, 0, 0, 1, 0, 0));
        res2.add(Arrays.asList(1, 0, 1, 0, 0, 0, 1, 1, 0, 1));
        List<List<Integer>> act2 = reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});
        Assert.assertEquals(res2, act2);


        List<List<Integer>> res3 = new ArrayList<>();
        res3.add(Arrays.asList(1, 1, 1, 1, 0));
        res3.add(Arrays.asList(0, 1, 0, 1, 0));
        List<List<Integer>> act3 = reconstructMatrix(4, 2, new int[]{1, 2, 1, 2, 0});
        Assert.assertEquals(res3, act3);


    }
}
