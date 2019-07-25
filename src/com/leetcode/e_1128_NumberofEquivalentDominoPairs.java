package com.leetcode;

//e_1128: Number of Equivalent Domino Pairs
//Show Topic Tags

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
//
//Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
//
//
//
//Example 1:
//
//Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
//Output: 1
//
//
//Constraints:
//
//1 <= dominoes.length <= 40000
//1 <= dominoes[i][j] <= 9

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/number-of-equivalent-domino-pairs/
//******************************************************************************************************************

public class e_1128_NumberofEquivalentDominoPairs {


    public static void main(String[] args) {

        System.out.println(new e_1128_NumberofEquivalentDominoPairs().numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
    }


    public int numEquivDominoPairs(int[][] dominoes) {
        //store number of occurrences in arr
        //based on input, 1<=dominoes<=9 so we can create arr of up to 99 index which means int[100]
        int[] arr = new int[100];

        int result = 0;

        //loop throug all dominoes and count occurences and then store them in arr
        for (int i = 0; i < dominoes.length; i++) {
            int current = dominoes[i][0] * 10 + dominoes[i][1];
            int reversed = dominoes[i][1] * 10 + dominoes[i][0];

            //we only care about one occurence [specific order]
            if (arr[current] == 0 && arr[reversed] == 0)
                arr[current] = 1;
                //check if we visited this pair before, keep increasing the same one
            else if (arr[current] > 0)
                arr[current] += 1;
            else
                //otherwise check the reversed pair and keep incrementing its occurence
                arr[reversed] += 1;
        }

        //loop through occurrences array and only consider items with occurences >= 2
        for (int i = 0; i <= 99; i++) {
            if (arr[i] > 1) {
                //calculate number of combinations using formula [ (n * n-1) / 2]
                result += (arr[i] * (arr[i] - 1)) / 2;
            }
        }

        return result;

    }


    @Test
    public void TestnumEquivDominoPairs() {
        Assert.assertEquals(1, numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        Assert.assertEquals(6, numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {2, 1}, {3, 4}, {5, 6}, {3, 4}, {4, 3}}));
        Assert.assertEquals(0, numEquivDominoPairs(new int[][]{}));
    }
//12 0
//21 0
}
