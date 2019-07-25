package com.leetcode;

//m_678: Valid Parenthesis String
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
//An empty string is also valid.
//Example 1:
//Input: "()"
//Output: True
//Example 2:
//Input: "(*)"
//Output: True
//Example 3:
//Input: "(*))"
//Output: True
//Note:
//The string size will be in the range [1, 100].

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/valid-parenthesis-string/
//******************************************************************************************************************

public class m_678_Valid_Parenthesis_String {


    public static void main(String[] args) {
        System.out.println(new m_678_Valid_Parenthesis_String().checkValidString("(*"));
        System.out.println(new m_678_Valid_Parenthesis_String().checkValidString("*("));
    }

    public boolean checkValidString(String s) {

        //maintain indexes of open and asterisks in stack
        Stack<Integer> open = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            //push into stack any open parenthesis
            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == '*') {
                //push asterisks into its stack
                asterisks.push(i);
            } else {

                //if we encounter ) close parenthesis, check the nearest open parenthesis first and pop it
                if (open.size() > 0)
                    open.pop();
                    //if no previous open parenthesis, check asterisk to substitute for this close parenthesis
                else if (asterisks.size() > 0)
                    //asterisks--;
                    asterisks.pop();
                else
                    //if we encounter close and neither open or asterisk were encountered before, return false
                    return false;
            }
        }

        //after we finish all close parenthsis, check balance between open and asterisk
        //if open is greater than asterisks that means there's no correct balance here, return false
        if (open.size() > 0 && asterisks.size() < open.size()) {
            return false;
        } else if (open.size() > 0) {
            //loop through all indexes of open parenthesis and compare these indexes with asterisks
            //if any open parenthesis came after asterisk that means it not valid e.g. *( so return false
            while (open.size() > 0) {
                if (open.pop() > asterisks.pop()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void TestCheckValidString() {
        Assert.assertEquals(true, checkValidString("()"));
        Assert.assertEquals(true, checkValidString("(*)"));
        Assert.assertEquals(true, checkValidString("(*))"));
        Assert.assertEquals(true, checkValidString("(**))*"));
        Assert.assertEquals(true, checkValidString("(((***"));
        Assert.assertEquals(true, checkValidString("(*"));
        Assert.assertEquals(true, checkValidString("*)"));
        Assert.assertEquals(true, checkValidString(""));
        Assert.assertEquals(true, checkValidString("*"));
        Assert.assertEquals(false, checkValidString("("));
        Assert.assertEquals(false, checkValidString(")"));
        Assert.assertEquals(false, checkValidString("())"));
        Assert.assertEquals(false, checkValidString("(()"));
        Assert.assertEquals(true, checkValidString("(((******))"));
        Assert.assertEquals(false, checkValidString("(())((())()()(*)(*()(())())())()()((()())"));//((()))(*
        Assert.assertEquals(false, checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        Assert.assertEquals(false, checkValidString("*("));


    }

}
