package com.g4g.school;

import java.util.Scanner;


//Problem Title
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a list of names, display the longest name.

//Input: First line of input contains an integer T, the number of test cases. T test cases follows. First line of each test case contains an integer N, i.e total number of names. Next N lines contains names of different length.
//
//
//        Output: Longest name in the list of names.
//
//
//        Constraints:
//
//        1<=T<=10
//        1<=N<=10
//
//
//        Example:
//
//        Input:
//        1
//        5
//        Geek
//        Geeks
//        Geeksfor
//        GeeksforGeek
//        GeeksforGeeks
//
//        Output:
//        GeeksforGeeks
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/display-longest-name/0/
//******************************************************************************************************************

public class DisplayLongestName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        //alittle bit different than usual (but better than saving the strings into memory)
        while (T-- > 0) {
            String max = "";
            String current = "";

            //read how many number of strings
            int n = scan.nextInt();

            //loop through and scan all strings
            while(n-- > 0){

                //save input string into current variable
                current = scan.next();

                //compare length of the current input string with max's length, if the current one bigger change max to be the current
                if(current.length() > max.length())
                    max = current;

            }
            
            System.out.println(max);


        }
    }

}
