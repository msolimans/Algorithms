package com.g4g.easy;

import java.util.Scanner;
import java.util.Stack;


//Parenthesis Checker
//Show Topic Tags

/**
 * Stack, Strings
 */

/*Description*/
//******************************************************************************************************************
//Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
//For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
//
//
//
//        Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        Each test case consist of a string of expression, in a separate line.
//
//        Output:
//
//        Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 100
//        1 ≤ |s| ≤ 100
//
//
//        Example:
//
//        Input:
//        3
//        {([])}
//        ()
//        ()[]
//
//        Output:
//        balanced
//        balanced
//        balanced
//******************************************************************************************************************
//Companies: Yatra, Walmart labs, Snapdeal, Oracle, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/parenthesis-checker/0
//******************************************************************************************************************

public class ParenthesisChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            String s = scan.next();
            System.out.println(run(s) ? "balanced": "not balanced");
        }
    }


    static boolean run(String s) {
        //add all open (left) parenthesis into stack, once you have a close parenthesis pop those open
        //if stack is empty and we have close brace or parenthesis => return false => more close/right parenthesis
        //if stack has values after finishing all string => return false => more open parenthesis

        Stack<Character> openParenthesis = new Stack<>();

        for(int i=0;i<s.length();i++){
            //open braces
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{')
                openParenthesis.push(s.charAt(i));
            //close braces
            else {
                //no matching open one
                if(openParenthesis.isEmpty())
                    return false;


                //check and compare exact matchings
                switch (s.charAt(i)){
                    case ']':
                        if(openParenthesis.peek() != '[') //should be matched with ]
                            return  false;
                        break;
                    case '}':
                        if(openParenthesis.peek() != '{') //should be matched with }
                            return false;
                        break;
                    case ')':
                        if(openParenthesis.peek() != '(') //should be matched with )
                            return false;
                        break;
                    //any other strings
                    default:
                        return false;
                }

                //make sure you pop the closing brace
                openParenthesis.pop();
            }
        }

        //we have still left-over open braces that don't have matching closing ones.
        if(!openParenthesis.isEmpty())
            return false;


        return true;

    }
}
