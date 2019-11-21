package com.leetcode;

//e_392_IsSubsequence 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string s and a string t, check if s is subsequence of t.
//
//You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string,
// and s is a short string (<=100).
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without
// disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
//Example 1:
//s = "abc", t = "ahbgdc"
//
//Return true.
//
//Example 2:
//s = "axc", t = "ahbgdc"
//
//Return false.
//
//Follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence.
// In this scenario, how would you change your code?
//
//Credits:
//Special thanks to @pbrother for adding this problem and creating all test cases.

//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/problems/is-subsequence/
//******************************************************************************************************************

public class e_392_IsSubsequence {


    public static void main(String[] args) {
        System.out.println(new e_392_IsSubsequence().isSubsequence("axc", "avccdsavvcxdddscx"));
    }

    public boolean isSubsequence(String s, String t) {
        //t is very long while s is short so if we get s longer than t => return false
        if (s.length() > t.length())
            return false;

        //s=s a b
        //t=s s a
        //t=s i s a a b
        //moves pointer in s as long as we got a match for the first char in s in t
        //keep moving this pointer in s until we finish t then check if we have si >= s.length if so return true otherwise return false
        int si = 0, ti = 0;

        while (ti < t.length()) {
            if (si > s.length() - 1)
                break;
            if (t.charAt(ti) == s.charAt(si)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }

        return si > s.length() - 1;
    }

    //Another Solution but will give you Time Limit Exceed

    //Array of LinkedList to keep tracking of positions [indices] or occurrence of chars
    public boolean isSubsequence2(String s, String t) {

        if (s.length() == t.length() && !s.equals(t))
            return false;

        if (s.length() > t.length())
            return false;

        List<Integer>[] chars = new ArrayList[25];
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (chars[index] == null)
                chars[index] = new ArrayList<>();
            chars[index].add(i);
        }


        //0 1 - 2 10 - 3 4 - 5 - 2 7
        for (int i = 1; i < s.length(); i++) {
            int indx1 = s.charAt(i - 1) - 'a';
            int indx2 = s.charAt(i) - 'a';
            if (!isValid(chars[indx1], chars[indx2]))
                return false;

        }


        return true;
    }


    boolean isValid(List<Integer> q1, List<Integer> q2) {
        if (q1 == null || q2 == null || q1.size() == 0 || q2.size() == 0)
            return false;

        int i1 = 0, i2 = 0;

        while (i2 < q2.size()) {
            if (q1.get(i1) > q2.get(i2))
                i2++;
            else if (q1.get(i1) < q2.get(i2))
                return true;
        }
        //2 4
        //1 5

        //1 5
        //3 4
        return false;
    }


    @Test
    public void TestisSubsequence() {
//        Assert.assertTrue(isSubsequence("abc", "ahbgdc"));
//        Assert.assertFalse(isSubsequence("axc", "ahbgdc"));

        Assert.assertTrue(isSubsequence2("", "ahbgdc"));
        Assert.assertTrue(isSubsequence2("twn", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
        Assert.assertTrue(isSubsequence2("", "c"));
        Assert.assertFalse(isSubsequence2("d", ""));
        Assert.assertFalse(isSubsequence2("b", "c"));
        Assert.assertTrue(isSubsequence2("abc", "ahbgdc"));
        Assert.assertFalse(isSubsequence2("axc", "ahbgdc"));


    }

}
