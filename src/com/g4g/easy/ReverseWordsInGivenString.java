package com.g4g.easy;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;


//Reverse words in a given string
//Show Topic Tags

/**
 * String, Stack
 */

/*Description*/
//******************************************************************************************************************
// Given a String of length N reverse the words in it. Words are separated by dots.

//Input:
//        The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string containing spaces and characters.
//
//
//        Output:
//        For each test case, output a single line containing the reversed String.
//
//        Constraints:
//        1<=T<=20
//        1<=Lenght of String<=2000
//
//
//        Example:
//        Input:
//        2
//        i.like.this.program.very.much
//        pqr.mno
//
//        Output:
//        much.very.program.this.like.i
//        mno.pqr
//******************************************************************************************************************
//Companies: MakeMyTrip, Goldman-Sachs, Cisco, Amazon, Adobe, Accolite, SAP-labs, Paytm, Microsoft
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0/?ref=self
//******************************************************************************************************************

public class ReverseWordsInGivenString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            System.out.println(run(scan.next()));
        }
    }


    static String run(String s) {

        //usually stacks used for any reversal operations.
        Stack<String> reversed = new Stack<>();

        //string builder is used for any string comabinations
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            //check if there dot, add it to stack, clear string builder and continue
            if(s.charAt(i) == '.') {
                reversed.push(sb.toString());
                sb = new StringBuilder();
                continue;
            }

            //append word's characters into string builder
            sb.append(s.charAt(i));
        }

        //make sure the sb doesn't have values
        //this check is used as the last word after (dot) in the sebtebce doesn't have dot at the end
        if(!Objects.equals(sb.toString(), ""))
            reversed.push(sb.toString());

        //initiate it again to use to append strings in reversed order from stack
        sb = new StringBuilder();

        while(!reversed.isEmpty()){
            sb.append(".").append(reversed.pop());
        }

        //substring from 1 to avoid the first dot added in previous while loop (in the first iteration)
        return sb.toString().substring(1);


    }
}
