package com.leetcode;

//e_520_DetectCapital 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a word, you need to judge whether the usage of capitals in it is right or not.
//
//We define the usage of capitals in a word to be right when one of the following cases holds:
//
//All letters in this word are capitals, like "USA".
//All letters in this word are not capitals, like "leetcode".
//Only the first letter in this word is capital, like "Google".
//Otherwise, we define that this word doesn't use capitals in a right way.
//
//
//Example 1:
//
//Input: "USA"
//Output: True
//
//
//Example 2:
//
//Input: "FlaG"
//Output: False
//
//
//Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/detect-capital/
//******************************************************************************************************************

public class e_520_DetectCapital {


    public static void main(String[] args) {


    }

    public boolean detectCapitalUse(String word) {
        //count holds how many capital letters in the string
        int count = 0;

        for (int i : word.toCharArray()) {
            //if char within the range of 65 to 90, it's capital
            if (i >= 65 && i <= 90) {
                count++;
            }
        }

        //count more than 1, then it should be all letters
        //count == 1, then it must be the first char
        //no capital letters at all.
        return (count > 1 && count == word.length()) ||
                (count == 1 && word.charAt(0) <= 90) ||
                count == 0;
    }


    @Test
    public void TestDetectCapitalUse() {
        Assert.assertTrue(detectCapitalUse("USA"));
        Assert.assertFalse(detectCapitalUse("FlaG"));
        Assert.assertTrue(detectCapitalUse("Google"));
        Assert.assertTrue(detectCapitalUse(""));
    }
}
