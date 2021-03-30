package com.leetcode;

//e_14_LongestCommonPrefix 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//Note:
//
//All given inputs are in lowercase letters a-z.

//******************************************************************************************************************
//Companies: Amazon | 5  Microsoft | 2  IXL | 2  Cisco | 2  Twilio | 2  Snapchat | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/longest-common-prefix/
//******************************************************************************************************************

public class e_14_LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(new e_14_LongestCommonPrefix().longestCommonPrefix(new String[]{"alfa", "alfanar"}));

    }

    //calc common prefix  between 2 strings
    String commonStr(String s1, String s2) {
        //if s1 is bigger than s2, swap to make sure we loop thru all string characters to find the prefix.
        //we may encounter a case where s1 is completely a prefix in s2 .. e.g. s1="hello" s2="helloworld"
        if (s1.length() > s2.length())
            return commonStr(s2, s1);

        //loop thru until we don't see a match or similarity
        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            i++;
        }

        //result should be substring of s1 [from 0 .. i]
        return s1.substring(0, i);
    }


    public String longestCommonPrefix(String[] strs) {
        //empty strings array, return empty common prefix
        if (strs.length == 0)
            return "";

        //common var to store the prefix, we start with first word as a complete prefix
        //if this is the only string in array, return common in this case otherwise continue starting from index 1
        String common = strs[0];
        //from index 1, loop thru and every time calc the common prefix and update common
        for (int i = 1; i < strs.length; i++) {
            //update common with the common prefix between (prev common and current string)
            common = commonStr(common, strs[i]);
            //at any time if we get no common prefix, we return empty result!
            if (common.equals("") || common.length() == 0)
                return "";
        }

        //return common
        return common;
    }

    @Test
    public void TestCommonStr() {
        Assert.assertEquals("alfa", commonStr("alfa", "alfanar"));
        Assert.assertEquals("", commonStr("alfanar", ""));
        Assert.assertEquals("alfanar", commonStr("alfanar", "alfanar"));
        Assert.assertEquals("", commonStr("adsa", "erefd"));
    }


    @Test
    public void TestLongestCommonPrefix() {
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"a", "b", "c"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"a", "a", "c"}));
        Assert.assertEquals("a", longestCommonPrefix(new String[]{"a", "a", "a"}));
        Assert.assertEquals("w", longestCommonPrefix(new String[]{"waac", "wa", "w"}));
        Assert.assertEquals("wa", longestCommonPrefix(new String[]{"waac", "wa", "waf", "wadsad"}));
        Assert.assertEquals("waac", longestCommonPrefix(new String[]{"waac"}));
    }
}
