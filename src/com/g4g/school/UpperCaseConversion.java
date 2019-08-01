package com.g4g.school;



import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Upper case conversion
//Show Topic Tags

/**
 * Strings, Arrays, Regular Expressions, Splits, Loops
 */

/*Description*/
//******************************************************************************************************************
//Given a string , write a program to title case every first letter of words in string.

//Input:
//        The first line consists of an integer T i.e number of test cases. The first and only line of each test case consists of a string s.
//
//        Output:
//        Print the required output.
//
//        Constraints:
//        1<=T<=100
//        1<=|Length of string|<=1000
//
//        Example:
//        Input:
//        1
//        I love programming
//
//        Output:
//        I Love Programming
//******************************************************************************************************************
//Companies: Nagarro
//******************************************************************************************************************
//Link:https://practice.geeksforgeeks.org/problems/upper-case-conversion/0
//******************************************************************************************************************

public class UpperCaseConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();//used to skip only new line after entry of N
        while (T-- > 0) {

            String str = scan.nextLine(); //collects strings (inputs)

            System.out.println(run(str));
            System.out.println(run1(str));
            System.out.println(run2(str));
        }
    }


    static String run(String str) {
        StringBuilder builder = new StringBuilder();

        String[] strs = str.split(" ");
        for (String s : strs) {
            if (Objects.equals(s, ""))
            {
                builder.append(" ");
                continue;
            }

            builder.append(Character.toUpperCase(s.charAt(0)) + (s.length()>1?s.substring(1):"") + " " );
        }

        return  builder.toString();
    }

    static String run2(String str){
        StringBuilder builder = new StringBuilder(str);

       boolean upper = true;
       for(int i =0;i<builder.length();i++){
           if(builder.charAt(i) == ' ') {
               upper = true;
               continue;
           }

           if(upper && builder.charAt(i) != ' '){
               builder.setCharAt(i, Character.toUpperCase(builder.charAt(i)));
               upper = false;
           }
       }

       return builder.toString();
    }

    static String run1(String str){
        String s = StringReplacer.replace(str, Pattern.compile("(\\s+[a-z])"), (Matcher m) -> {
            //System.out.print(m);
            return ""+m.group().toUpperCase();
        });

        return s.charAt(0) != ' '? Character.toUpperCase(s.charAt(0)) + s.substring(1): s;
    }
}

class StringReplacer{
    public static String replace(String str, Pattern pattern, StringMatchHandler handler){
        Matcher matcher = pattern.matcher(str);
        StringBuffer buffer = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(buffer, handler.replace(matcher));
        }

        matcher.appendTail(buffer);

        return buffer.toString();
    }

}

interface StringMatchHandler{
    String replace(Matcher matcher);
}