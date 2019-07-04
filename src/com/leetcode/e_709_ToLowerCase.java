package com.leetcode;


//709. To Lower Case
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//
//
//        Example 1:
//
//        Input: "Hello"
//        Output: "hello"
//        Example 2:
//
//        Input: "here"
//        Output: "here"
//        Example 3:
//
//        Input: "LOVELY"
//        Output: "lovely"
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/to-lower-case/
//******************************************************************************************************************


public class e_709_ToLowerCase {

    public static void main(String[] args) {
        System.out.println(new e_709_ToLowerCase().toLowerCase("Hello"));
    }


    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) { //uppercase
                arr[i] |= 32;
            }

            sb.append(arr[i]);
        }

        return sb.toString();
    }


    @Test
    public void TesttoLowerCase(){
        Assert.assertEquals("hello", toLowerCase("Hello"));
        Assert.assertEquals("world", toLowerCase("WorLD"));

    }
}
