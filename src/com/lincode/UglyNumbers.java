package com.lincode;

/**
 * Created by msoliman on 2/17/17.
 */
public class UglyNumbers {
    public static void main(String[] a){

    }

//    Write a program to check whether a given number is an ugly number`.
//
//    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//    For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
//
//    Notice
//
//    Note that 1 is typically treated as an ugly number.
//
//    Example
//    Given num = 8 return true
//    Given num = 14 return false
//




    static   public boolean isUgly(int num) {
        // Write your code here
//        if(num)

        for(int i=3;i*i<num;i+=2) {
            if(num % i == 0)
                return false;
        }

        return  false;

    }
}
