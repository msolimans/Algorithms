package com.g4g.school;



import java.util.Scanner;
import java.util.Stack;


//Reverse a string
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given a string S as input. You have to reverse the given string.
//
//Input: First line of input contains a single integer T which denotes the number of test cases. T test cases follows, first line of each test case contains a string S.
//
//Output: Corresponding to each test case, print the string S in reverse order.
//
//Constraints:
//
//1<=T<=100
//3<= length(S) <=1000
//
//
//Example:
//
//Input:
//3
//Geeks
//GeeksforGeeks
//GeeksQuiz
//
//Output:
//skeeG
//skeeGrofskeeG
//ziuQskeeG
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-array-elements/0
//******************************************************************************************************************

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            String s = scan.next();

            System.out.println(run(s));
            System.out.println(run1(s));
            System.out.println(run2(s));
        }
    }


    //using string builder (1 simple call)
    static String run(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    //using swapping (algorithmic impl)
    static String run1(String str){
        int s = -1;
        int e = str.length();

        char[] arr = new char[str.length()];
        for(int i =0;i<str.length();i++){
            arr[i] = str.charAt(i);
        }

        char temp = 'a';

        while(s++ < e--){
            //swap
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
        }

        return String.valueOf(arr);
    }


    //using stack
    static String run2(String str){
      Stack<Character> stack = new Stack<>();
      //you can use StringBuilder or array of chars
        char[] arr = new char[str.length()];

      for(int i =0;i<str.length();i++){
          stack.push(str.charAt(i));
      }

      int i =0;
      while(!stack.empty()){
          arr[i++] = stack.pop();
      }

      return String.valueOf(arr);
    }
}
