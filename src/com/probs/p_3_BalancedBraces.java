package com.probs;

import com.alkhawarizms.DataStructure.Stacks.StackBasedArray;

import java.util.Stack;

/**
 * Created by msoliman on 4/22/17.
 */
public class p_3_BalancedBraces {

    public static void main(String[] strs) {
        System.out.println(isBalanced("{(1+2)}"));
        System.out.println(isBalanced("{[(1+2)}"));
        System.out.println(isBalanced("{[(1+2)*(3-10)]+[1]}"));


        System.out.println(getBrokenBracesPosition("foo(bar);"));
        System.out.println(getBrokenBracesPosition("foo(bar[i);"));
        System.out.println(getBrokenBracesPosition("{[(1+2)*(3-10)]+[1]}"));
    }


    //return position where broken braces happened, if all balanced returns -1
    static int getBrokenBracesPosition(String str) {
        Stack<Character> s = new Stack();


        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(')
                s.push(ch);

            else if (ch == '}') {
                if (s.pop() != '{')
                    return i + 1;
            }
            else if (ch == ')') {
                if (s.pop() != '(')
                    return i + 1;
            }
            else if(ch == ']') {
                if (s.pop() != '[')
                    return i + 1;
            }
        }

        if(!s.isEmpty())
            return str.length();
        else
            return -1;
    }


    //whether the braces are balanced in a string
    //examples:
    // foo(bar); true
    //foo(bar[); false as "[" doesn't have its enclosing
    public static boolean isBalanced(String str) {
        StackBasedArray<Character> stackBasedArray = new StackBasedArray<>();

        for (char c : str.toCharArray()) {

            if (c == '[' || c == '(')
                stackBasedArray.push(c);
            else {

                if (c == ']') {
                    if (stackBasedArray.pop() != '[')
                        return false;

                } else if (c == ')') {
                    if (stackBasedArray.pop() != '(')
                        return false;
                    else if (c == '}')
                        if (stackBasedArray.pop() != '{')
                            return false;
                }
                //skip and continue for any other chars except "),]"
            }

        }

        //after finishing the string, if the stack is not empty which means it still has openning braces that don't have matching closing ones
        return stackBasedArray.isEmpty();
    }
}
