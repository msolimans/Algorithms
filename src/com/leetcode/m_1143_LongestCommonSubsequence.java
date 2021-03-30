package com.leetcode;

//m_1143_LongestCommonSubsequence 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 * Dynamic Programming
 */

/*Description*/
//******************************************************************************************************************
//Given two strings text1 and text2, return the length of their longest common subsequence.
//
//A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
//
//
//
//If there is no common subsequence, return 0.
//
//
//
//Example 1:
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//Example 2:
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//Example 3:
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//Constraints:
//
//1 <= text1.length <= 1000
//1 <= text2.length <= 1000
//The input strings consist of lowercase English characters only.

//******************************************************************************************************************
//Companies: Amazon | 3  Google | 2  Microsoft | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/longest-common-subsequence/
//******************************************************************************************************************

public class m_1143_LongestCommonSubsequence {


    public static void main(String[] args) {


    }

    //this is well known dynamic programming algorithm
    //we should construct this array based on the example
    //if we have similar chars, add 1 to the diagonal val
    //if they are not similar, get the max val between [top i-1,j] and [left i,j-1]
    //      a   b   c   d   e
    //      0   1   2   3   4
    //-----------------------
    //a 0 | 1   1   1   1   1
    //    |       \
    //c 1 | 1   1   2   2   2
    //    |               \
    //e 2 | 1   1   2   2   3

    //result is 3
    public int longestCommonSubsequence(String text1, String text2) {
        //if any of them is empty, returns 0
        if (text1.length() == 0 || text2.length() == 0)
            return 0;

        //make sure that text1 is longer!
        if (text2.length() > text1.length())
            return longestCommonSubsequence(text2, text1);

        //text1 represents rows while text2 represents cols
        int[][] res = new int[text1.length()][text2.length()];

        //fill matrix
        for (int i = 0; i < text1.length(); i++)
            for (int j = 0; j < text2.length(); j++) {
                //if both are equal, add one to diagonal
                if (text1.charAt(i) == text2.charAt(j)) {
                    int diagonal = i == 0 || j == 0 ? 0 : res[i - 1][j - 1];
                    res[i][j] = diagonal + 1;
                } else {//not equal
                    //top is either zero [in case of first row] or i-1,j
                    int top = i == 0 ? 0 : res[i - 1][j];
                    //left is either zerp [in case of first col] or i,j-1
                    int left = j == 0 ? 0 : res[i][j - 1];
                    //get max of top i-1,j and left i,j-1
                    res[i][j] = Math.max(top, left);
                }
            }

        return res[text1.length() - 1][text2.length() - 1];
    }

    @Test
    public void TestLongestCommonSubsequence() {
        Assert.assertEquals(3, longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(0, longestCommonSubsequence("abcde", "f"));
        Assert.assertEquals(0, longestCommonSubsequence("abcde", "f"));
        Assert.assertEquals(0, longestCommonSubsequence("", ""));
        Assert.assertEquals(0, longestCommonSubsequence("", "ssd"));
        Assert.assertEquals(1, longestCommonSubsequence("s", "ssd"));
        Assert.assertEquals(2, longestCommonSubsequence("sd", "ssd"));
        Assert.assertEquals(3, longestCommonSubsequence("sfaaasoooosd", "ssd"));
    }

}
