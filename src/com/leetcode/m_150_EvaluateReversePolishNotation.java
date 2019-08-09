package com.leetcode;

//m_150_EvaluateReversePolishNotation 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Note:
//
//Division between two integers should truncate toward zero.
//The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
//Example 1:
//
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation:
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
//******************************************************************************************************************

public class m_150_EvaluateReversePolishNotation {


    public static void main(String[] args) {


    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    //addition and multiply ops are the same so we don't have to keep the same order
                    result = stack.pop() + stack.pop();
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    break;
                case "/":
                    //we need to keep the same order, e.g. "13", "5" , "/" => should be 13 / 5 not 5 / 13
                    int last = stack.pop();
                    result =  stack.pop() / last;
                    break;
                case "-":
                    //same for subtraction
                    last = stack.pop();
                    result = stack.pop() - last;
                    break;
                default:
                    //convert to int and push the elem to the stack
                    result = Integer.parseInt(t);
                    break;
            }

            //push the result (result of an operation) or the element itself
            stack.push(result);
        }

        //the result should be the last element in the stack
        return stack.pop();
    }

    @Test
    public void TestevalRPN() {
        Assert.assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assert.assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
