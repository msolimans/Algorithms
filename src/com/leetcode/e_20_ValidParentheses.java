package com.leetcode;

//e_20_ValidParentheses
//Show Topic Tags

import java.util.Stack;

/**
 * Stack
 */

/*Description*/
//******************************************************************************************************************

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_20_ValidParentheses {


    public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {

                if (c == '[' || c == '{' || c == '(')
                    stack.push(c);
                else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                } else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                }

            }

            return stack.isEmpty();


    }

    public static void main(String[] args) {

        e_20_ValidParentheses solution = new e_20_ValidParentheses();

        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("()[]{"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("()"));
    }
}
