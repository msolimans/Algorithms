package com.leetcode;

//e_67_AddBinary 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 * Math, Binary
 */

/*Description*/
//******************************************************************************************************************
//Given two binary strings, return their sum (also a binary string).
//
//The input strings are both non-empty and contains only characters 1 or 0.
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
//******************************************************************************************************************
//Companies: Facebook | 52  Google | 2  Apple | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/add-binary/
//******************************************************************************************************************

public class e_67_AddBinary {


    public static void main(String[] args) {


    }

    //For better understanding how to add bits, check this wiki https://www.wikihow.com/Add-Binary-Numbers
    //rules:
    /*
        1 + 1 = 0 carry 1
        0 + 1 = 0 carry 0
        1 + 0 = 0 carry 0
        1 + 1 + 1 = 1 carry 1

        General rule for multiple strings to be added [not relative to this problem but helpful in understanding how to add multiple binary strings:
            For each two pairs of 1s it results in 0 carry 1

            1
            1
            1
            1
            =
            0 carry 1 and 1

            1
            1
            1
            1
            1
            =
            1 carry 1 and 1
     */
    public String addBinary(String a, String b) {

        int ia = a.length() - 1;
        int ib = b.length() - 1;
        int carry = 0;
        int c1s = 0;
        StringBuilder sb = new StringBuilder();
        while (ia >= 0 || ib >= 0 || carry > 0) {
            char na = ia < 0 ? '0' : a.charAt(ia--);
            char nb = ib < 0 ? '0' : b.charAt(ib--);


            //count how many 1 we are adding now
            c1s = 0;
            c1s += na == '1' ? 1 : 0;//in case current bit of string a is 1 add 1 to count
            c1s += nb == '1' ? 1 : 0;//in case current bit of string b is 1 add 1 to count
            c1s += carry == 1 ? 1 : 0;//in case we have carry from previous operation

            switch (c1s) {
                case 3:
                    sb.append("1");//1 + 1 + 1 = 1 carry 1
                    carry = 1;
                    break;
                case 2:
                    sb.append("0"); //1 + 1 = 0 carry 1
                    carry = 1;
                    break;
                case 1:
                    sb.append("1");//1 + 0 or 0 + 1 = 1 carry 0
                    carry = 0;//make sure to reset carry = zero otherwise it will be infinite loop
                    break;
                case 0:
                    sb.append("0");
                    carry = 0;
            }

        }

        //reverse res
        return sb.reverse().toString();

    }

    @Test
    public void TestAddBinary() {
        Assert.assertEquals("100", addBinary("11", "1"));
    }


}
