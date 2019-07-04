package com.leetcode;


//28. Implement strStr()
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/implement-strstr/
//******************************************************************************************************************


public class e_28_ImplementstrStr {

    public static void main(String[] args) {
        System.out.println(new e_28_ImplementstrStr().strStr("mississippi", "issip"));

    }


    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }

        if (needle.length() == 0) {
            return 0;
        }


        int ih = 0;
        int in = 0;


        while (ih <= haystack.length() - needle.length()) {
            in = 0;
            for (int i = ih; i < ih + needle.length(); i++) {
                if (haystack.charAt(i) != needle.charAt(in++)) {
                    break;
                }

                if (in > needle.length() - 1) {
                    return ih;
                }

            }
            ih++;

        }

        return -1;

    }


    @Test
    public void TeststrStr() {
        Assert.assertEquals(0, strStr("a", ""));
        Assert.assertEquals(4, strStr("mississippi", "issip"));
        Assert.assertEquals(0, strStr("", ""));
        Assert.assertEquals(2, strStr("hello", "ll"));
        Assert.assertEquals(0, strStr("hello", "he"));
        Assert.assertEquals(3, strStr("hello", "lo"));
        Assert.assertEquals(9, strStr("hello world", "ld"));
        Assert.assertEquals(-1, strStr("aaaaa", "bba"));
    }

}
