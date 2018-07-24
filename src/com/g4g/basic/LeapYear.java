package com.g4g.basic;

//Leap Year
//Show Topic Tags

import java.util.Calendar;
import java.util.Scanner;



/**
 * misc
 * math
 */

/*Description*/
//***********************************
//    For an input year tell whether the year is leap or not.
//
//     Input:
//     First line contains an integer, the number of test cases 'T' Each test case should contain a positive integer N(Year).
//
//
//     Output:
//     Print "Yes" if it is a leap year else "No". (Without the double quotes)
//
//
//     Constraints:
//     1<=T<=31
//     1<=N<=9999
//
//
//     Example:
//     Input:
//     1
//     4
//
//     Output:
//     Yes
//
//     ** For More Input/Output Examples Use 'Expected Output' option **
//     http://practice.geeksforgeeks.org/problems/leap-year/0/?ref=self#ExpectOP

public class LeapYear {
    public static  void main(String[] args){
        Scanner scan = new Scanner (System.in);
        int T = scan.nextInt();

        while(T-- > 0){
            //pick the year
            int year = scan.nextInt();
            //validate from java itself -> import static java.time.Year.isLeap;
            System.out.println(isLeap(year)? "Yes": "No");
        }
    }

    static  boolean isLeap(int year){
        //year divisible by 4 or 400
        //and
        //not divisible by 100
        return (year % 4 == 0 || year % 400 == 0) && year % 100 != 0;
    }
}
