package com.leetcode;

//e_680_ValidPalindromeII 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;


/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//
//Example 1:
//Input: "aba"
//Output: True
//Example 2:
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
//Note:
//The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
//******************************************************************************************************************
//Companies: Facebook | 41
//******************************************************************************************************************
//Link: https://leetcode.com/problems/valid-palindrome-ii/
//******************************************************************************************************************

public class e_680_ValidPalindromeII {


    public static void main(String[] args) {


    }

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0);
    }

    public boolean validPalindrome(String s, int diff) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            //handling violation case
            if (s.charAt(start) != s.charAt(end)) {
                //in case we got more than one, exit with false
                if (diff >= 1)
                    return false;

                //this will fix this issue: l c u puuuup uc u l
                //                            ^-----------^-^
                //                                     <--Y N we need to check current index [start] with previous end [end - 1]
                //                              ^-----------^
                //                                            OR need to check next to current index [start + 1] with [end]
                //                                            recursively call with diff 1 as we got this as one violation and see next
                //                                            make sure we use logical OR condition [NOT AND]
                if (s.charAt(start + 1) == s.charAt(end) && s.charAt(start) == s.charAt(end - 1))
                    // second param of s.substring (end) goes up to but does not include the given index (right index in this case)
                    return validPalindrome(s.substring(start, end), 1) || validPalindrome(s.substring(start + 1, end + 1), 1);
                //
                else if (s.charAt(start + 1) == s.charAt(end))
                    start++;
                else if (s.charAt(end - 1) == s.charAt(start))
                    end--;
                else//more than 1 diff, return false in this case
                    return false;

                diff++;
                continue;
            }

            start++;
            end--;
        }

        return true;
    }


    @Test
    public void TestValidPalindrome() {

        Assert.assertTrue(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        Assert.assertTrue(validPalindrome("fxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxf"));

        Assert.assertTrue(validPalindrome("lcupuuuupucul"));
        Assert.assertTrue(validPalindrome("accda"));
        Assert.assertTrue(validPalindrome("acdda"));
        Assert.assertFalse(validPalindrome("abdcca"));
        Assert.assertFalse(validPalindrome("mtebbefm"));
        Assert.assertTrue(validPalindrome("mtebbem"));
        Assert.assertFalse(validPalindrome("tebbem"));
        Assert.assertTrue(validPalindrome("aba"));
        Assert.assertTrue(validPalindrome("abca"));
        Assert.assertTrue(validPalindrome(""));
        Assert.assertFalse(validPalindrome("abc"));
    }

}
