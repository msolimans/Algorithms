package com.leetcode;

//e_415_AddStrings
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//Note:
//
//The length of both num1 and num2 is < 5100.
//Both num1 and num2 contains only digits 0-9.
//Both num1 and num2 does not contain any leading zero.
//You must not use any built-in BigInteger library or convert the inputs to integer directly.

//******************************************************************************************************************
//Companies: Facebook | 16  Oracle | 5  Microsoft | 2  Snapchat | 2  Adobe | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/add-strings/
//******************************************************************************************************************

public class e_415_AddStrings {


    public static void main(String[] args) {
        System.out.println(new e_415_AddStrings().addStrings("0", "23254657"));

    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        //pointers to last index of nums
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        //stores carry
        int carry = 0;

        //as long as we still have more elems to add in either num1 or num2 and we do have carry left over from previous add operations
        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            int n1 = i1 < 0 ? 0 : num1.charAt(i1--) - '0';
            int n2 = i2 < 0 ? 0 : num2.charAt(i2--) - '0';

            //calc sums
            int sum = n1 + n2 + carry;
            //calc carry
            carry = sum / 10;
            //append modulus to result
            sb.append(sum % 10);
        }

        //reverse res string
        return sb.reverse().toString();
    }

    @Test
    public void TestAddStrings() {
        Assert.assertEquals("1298", addStrings("999", "299"));
        Assert.assertEquals("3249734784378437478547343443467767875473169350147225133090774756534474952972875677487747747346552655265526536656971898193141396240604819708088774477346456475678019567524330695309791806574",
                addStrings("3249734784378437478547387378267237476486437838743873873673276327632763268328485949096570698120302409854044387238673228237839009783762165347654895903287",
                        "3249734784378437478547343443467767872223434565768787654543387378267237476486437838743873873673276327632763268328485949096570698120302409854044387238673228237839009783762165347654895903287"));
    }
}
