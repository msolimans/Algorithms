package com.leetcode;


//459. Repeated Substring Pattern
//Show Topic Tags

import com.alkhawarizms.DataStructure.Lists.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//
//
//        Example 1:
//
//        Input: "abab"
//        Output: True
//        Explanation: It's the substring "ab" twice.
//        Example 2:
//
//        Input: "aba"
//        Output: False
//        Example 3:
//
//        Input: "abcabcabcabc"
//        Output: True
//        Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/repeated-substring-pattern/
//******************************************************************************************************************


public class e_459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new e_459_RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return true;
        }

        //window of n, 1, 2, 3, 4, 5 .. n/2
        //window of 2 XOR => 33 33 33 won't work as chars might come not in order e.g. "a . b . b . a"
        //window of 3, Use StringBuilder, Array or 2 Queues
        int window = 1;
        //int pxor = 0;
        //int xor = 0;
        StringBuilder pxor = new StringBuilder();
        StringBuilder xor = new StringBuilder();

        while (window <= s.length() / 2) {//equal windows or dist
            if (s.length() % window != 0) {
                window++;
                continue;
            }

            //verify all windows are the same

            for (int i = 0; i < s.length(); i++) {
                xor.append(s.charAt(i));

                if ((i+1) % window == 0) {

                    if (pxor.length() != 0 && !pxor.toString().equals(xor.toString())) {
                        pxor=new StringBuilder();
                        xor=new StringBuilder();
                        break;
                    }

                    if (i == s.length() - 1) {
                        return true;
                    }

                    //else continue
                    pxor = xor;
                    xor=new StringBuilder();
                }
            }

            window++;
        }

        return false;
    }

    @Test
    public void TestrepeatedSubstringPattern() {
        Assert.assertTrue(repeatedSubstringPattern("abab"));
        Assert.assertFalse(repeatedSubstringPattern("abac"));
        Assert.assertFalse(repeatedSubstringPattern("aba"));
        Assert.assertEquals(true, repeatedSubstringPattern("abcabcabcabc"));
        Assert.assertEquals(true, repeatedSubstringPattern("abaababaab"));
    }

}
