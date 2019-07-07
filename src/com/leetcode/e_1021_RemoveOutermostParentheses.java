package com.leetcode;


//1021. Remove Outermost Parentheses
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//
//A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
//
//Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
//
//Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
//
//
//
//Example 1:
//
//Input: "(()())(())"
//Output: "()()()"
//Explanation:
//The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
//Example 2:
//
//Input: "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation:
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
//Example 3:
//
//Input: "()()"
//Output: ""
//Explanation:
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".
//
//
//Note:
//
//S.length <= 10000
//S[i] is "(" or ")"
//S is a valid parentheses string
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link: https://leetcode.com/problems/remove-outermost-parentheses/
//******************************************************************************************************************


public class e_1021_RemoveOutermostParentheses {

    public static void main(String[] args) {
        System.out.println(new e_1021_RemoveOutermostParentheses().removeOuterParentheses("(())"));
        System.out.println(new e_1021_RemoveOutermostParentheses().removeOuterParentheses("((()))()((()()))"));

    }

    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count += 1;
                //if we have >= 2 open ones, display current one
                if (count >= 2) {
                    result.append("(");
                }
            } else {
                //decrease count by 1 => if it was open ( then count = 1 => count-- => count = 0
                count--;
                //here's we check if we had in the history open ones, then it is time to close it here and display it (append to string/result)
                if (count > 0) {
                    result.append(")");
                }
            }
        }

        return result.toString();
    }


    @Test //((())())(
    public void TestremoveOuterParentheses() {
        Assert.assertEquals("()()()", removeOuterParentheses("(()())(())"));
        Assert.assertEquals("()()()()(())", removeOuterParentheses("(()())(())(()(()))"));
        Assert.assertEquals("()(())", removeOuterParentheses("(()(()))"));
        Assert.assertEquals("", removeOuterParentheses("()()"));
        Assert.assertEquals("", removeOuterParentheses(""));
        Assert.assertEquals("(()())", removeOuterParentheses("((()()))"));
        Assert.assertEquals("(()())()", removeOuterParentheses("((()()))()(())"));
    }
}
