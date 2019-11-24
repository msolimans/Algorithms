package com.leetcode;

//e_125_ValidPalindrome 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//Example 1:
//
//Input: "A man, a plan, a canal: Panama"
//Output: true
//Example 2:
//
//Input: "race a car"
//Output: false

//******************************************************************************************************************
//Companies: Facebook | 43  Microsoft | 8  Yandex | 7  Apple | 5  Google | 2  Amazon | 2  Adobe | 2  Bloomberg | 2  eBay | 2  Wayfair | 2  Wish | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/valid-palindrome/
//******************************************************************************************************************

public class e_125_ValidPalindrome {


    public static void main(String[] args) {

        System.out.println(new e_125_ValidPalindrome().isPalindrome("abc"));
    }

    public boolean isPalindrome(String s) {

        int start = 0, end = s.length() - 1;
        while (start < end) {
            //ignores anything otherthan alphanumerics
            if (!isAlphaNumberic(s.charAt(start))) {
                start++;
                continue;
            }
            //ignores anything otherthan alphanumerics
            if (!isAlphaNumberic(s.charAt(end))) {
                end--;
                continue;
            }

            //both chars at start/end are alphnumeric, it is time to check if they are equal. if not return false
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;

            start++;
            end--;
        }

        return true;
    }

    boolean isAlphaNumberic(char c) {

        //based on ascii ranges
        //48-57  -> 0-9
        //65-90  -> A-Z
        //97-122 -> a-z
        int i = (int) c;
        return (i >= 97 && i <= 122) || (i >= 65 && i <= 90) || (i >= 48 && i <= 57);

        //can be written in regular expression like this
//        return String.format("%c", c).matches("[a-zA-Z0-9]");
    }

    @Test
    public void TestIsPalindrome() {
        Assert.assertFalse(isPalindrome("0P"));
        Assert.assertFalse(isPalindrome("0123456789"));
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertTrue(isPalindrome(""));
        Assert.assertFalse(isPalindrome("123"));
        Assert.assertFalse(isPalindrome("1c2aC3"));
        Assert.assertFalse(isPalindrome("1c2up: o; 345-=+p 3118765 uC3"));
    }

}
