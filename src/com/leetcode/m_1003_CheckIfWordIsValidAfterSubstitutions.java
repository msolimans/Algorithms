package com.leetcode;

//m_1003_CheckIfWordIsValidAfterSubstitutions
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//We are given that the string "abc" is valid.
//
//From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
//
//If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
//
//Return true if and only if the given string S is valid.
//
//
//
//Example 1:
//
//Input: "aabcbc"
//Output: true
//Explanation:
//We start with the valid string "abc".
//Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
//Example 2:
//
//Input: "abcabcababcc"
//Output: true
//Explanation:
//"abcabcabc" is valid after consecutive insertings of "abc".
//Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
//Example 3:
//
//Input: "abccba"
//Output: false
//Example 4:
//
//Input: "cababc"
//Output: false
//
//
//Note:
//
//1 <= S.length <= 20000
//S[i] is 'a', 'b', or 'c'
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
//******************************************************************************************************************

public class m_1003_CheckIfWordIsValidAfterSubstitutions {


    public static void main(String[] args) {
        System.out.println(new m_1003_CheckIfWordIsValidAfterSubstitutions().isValid("abc"));
    }

    public boolean isValid(String S) {

        //use stack to retrieve last chars
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            //for any character that's not 'c' push it
            if (S.charAt(i) != 'c')
                stack.push(S.charAt(i));
            //once we encounter 'c', check if 'b' was directly before 'c' and also 'a' before 'b', if not return false
            else if (!stack.empty() && stack.pop() == 'b' && !stack.empty() && stack.pop() == 'a') {
            } else
                return false;

            i++;
        }

        return stack.empty();
    }


    @Test
    public void TestIsValid() {
        Assert.assertTrue(isValid("abc"));
        Assert.assertTrue(isValid("aabcbc"));
        Assert.assertTrue(isValid("abcabcababcc"));
        Assert.assertFalse(isValid("abcabcababac"));
    }

}