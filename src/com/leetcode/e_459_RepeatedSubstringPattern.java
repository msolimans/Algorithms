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
//Companies: Google
//******************************************************************************************************************
//Link: https://leetcode.com/problems/repeated-substring-pattern/
//******************************************************************************************************************


public class e_459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new e_459_RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s.length() == 1)
            return true;

        int w = 1;
        //construct a window
        while (w <= s.length() / 2) {//at max 2 halfs
            //if window doesn't make equal window sizes, just increase its size
            if (s.length() % w != 0) {
                w++;
                continue;
            }

            //make sure we have window divisible by window
            String s1 = s.substring(0, w);

            //compare other strings
            for (int i = 0; i <= s.length() - w; i += w) {
                if (!s.substring(i, i + w).equals(s1))
                    break;
                //if it is the last elem in the array, we got a match
                if (i == s.length() - w)
                    return true;
            }

            w++;
        }

        //no matches found, return false
        return false;


    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return true;
        }

        //window of n, 1, 2, 3, 4, 5 .. n/2
        //window of 2 XOR => 33 33 33 won't work as chars might come not in order e.g. "a . b . b . a"
        //window of 3, Use StringBuilder, Array or 2 Queues
        int window = 1;
        StringBuilder prevstr = new StringBuilder();
        StringBuilder str = new StringBuilder();

        while (window <= s.length() / 2) {//equal windows or dist
            if (s.length() % window != 0) {
                window++;
                continue;
            }

            //verify all windows are the same
            for (int i = 0; i < s.length(); i++) {
                str.append(s.charAt(i));

                //we collected a full window
                if ((i + 1) % window == 0) {

                    //check if the current window is similar to the previous one, if not break
                    if (prevstr.length() != 0 && !prevstr.toString().equals(str.toString())) {
                        prevstr = new StringBuilder();
                        str = new StringBuilder();
                        break;
                    }

                    //if we are done with all of them, we reached the end of str then we return true
                    if (i == s.length() - 1) {
                        return true;
                    }

                    //else continue checking more windows
                    prevstr = str;
                    //reset current str window
                    str = new StringBuilder();
                }
            }

            //increase window size
            window++;
        }

        return false;
    }

    @Test
    public void TestrepeatedSubstringPattern() {
        Assert.assertTrue(repeatedSubstringPattern("abab"));
        Assert.assertFalse(repeatedSubstringPattern("abac"));
        Assert.assertFalse(repeatedSubstringPattern("aba"));
        Assert.assertTrue(repeatedSubstringPattern("abcabcabcabc"));
        Assert.assertTrue(repeatedSubstringPattern("abaababaab"));

        //////////////////////////////////////////

        Assert.assertTrue(repeatedSubstringPattern2("abab"));
        Assert.assertFalse(repeatedSubstringPattern2("abac"));
        Assert.assertFalse(repeatedSubstringPattern2("aba"));
        Assert.assertTrue(repeatedSubstringPattern2("abcabcabcabc"));
        Assert.assertTrue(repeatedSubstringPattern2("abaababaab"));
        Assert.assertTrue(repeatedSubstringPattern2("acxacxacx"));
        Assert.assertFalse(repeatedSubstringPattern2("acxaxc"));
        Assert.assertTrue(repeatedSubstringPattern2("a"));
        Assert.assertFalse(repeatedSubstringPattern2("abbbva"));
        Assert.assertTrue(repeatedSubstringPattern2("aaaa"));

    }

}
