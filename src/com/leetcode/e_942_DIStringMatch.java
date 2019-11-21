package com.leetcode;

//e_942_DIStringMatch 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
//
//Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
//
//If S[i] == "I", then A[i] < A[i+1]
//If S[i] == "D", then A[i] > A[i+1]
//
//
//Example 1:
//
//Input: "IDID"
//Output: [0,4,1,3,2]
//Example 2:
//
//Input: "III"
//Output: [0,1,2,3]
//Example 3:
//
//Input: "DDI"
//Output: [3,2,0,1]
//
//
//Note:
//
//1 <= S.length <= 10000
//S only contains characters "I" or "D".

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/di-string-match/
//******************************************************************************************************************

public class e_942_DIStringMatch {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new e_942_DIStringMatch().diStringMatch("DDI")));
    }

    public int[] diStringMatch(String S) {

        int i = 0;
        int lo = 0, hi = S.length();
        int[] res = new int[S.length() + 1];

        //we can't make <= length as it will raise out of range exception
        while (i < S.length()) {
            if (S.charAt(i) == 'I')
                res[i++] = lo++;
            else
                res[i++] = hi--;
        }


        //this will lead checking last char in the input array, notice [i-1] to avoid exception
        //we do the same conditions as above
        if (S.charAt(i - 1) == 'I') {
            res[i] = lo++;
        } else
            res[i] = hi--;


        return res;
    }

    @Test
    public void TestDiStringMatch() {
        Assert.assertArrayEquals(new int[]{0, 4, 1, 3, 2}, diStringMatch("IDID"));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, diStringMatch("III"));
        Assert.assertArrayEquals(new int[]{3, 2, 0, 1}, diStringMatch("DDI"));
    }

}
