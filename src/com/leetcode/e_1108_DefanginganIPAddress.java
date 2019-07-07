package com.leetcode;


//1108. Defanging an IP Address
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//A defanged IP address replaces every period "." with "[.]".
//
//
//
//Example 1:
//
//Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"
//Example 2:
//
//Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"
//
//
//Constraints:
//
//The given address is a valid IPv4 address.
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link: https://leetcode.com/problems/defanging-an-ip-address/
//******************************************************************************************************************


public class e_1108_DefanginganIPAddress {
    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }

        return sb.toString();
    }

    @Test
    public void  TestdefangIPaddr() {
        Assert.assertEquals( "1[.]1[.]1[.]1",defangIPaddr("1.1.1.1"));
        Assert.assertEquals( "255[.]100[.]50[.]0",defangIPaddr("255.100.50.0"));
    }

}
