package com.leetcode;

//e_917_ReverseOnlyLetters 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
//
//
//
//Example 1:
//
//Input: "ab-cd"
//Output: "dc-ba"
//Example 2:
//
//Input: "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
//Example 3:
//
//Input: "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//Note:
//
//S.length <= 100
//33 <= S[i].ASCIIcode <= 122
//S doesn't contain \ or "

//******************************************************************************************************************
//Companies: Microsoft
//******************************************************************************************************************
//Link: https://leetcode.com/problems/reverse-only-letters/
//******************************************************************************************************************

public class e_917_ReverseOnlyLetters {


    public static void main(String[] args) {
        System.out.println(new e_917_ReverseOnlyLetters().reverseOnlyLetters("abc-19csa"));
        System.out.println(new e_917_ReverseOnlyLetters().reverseOnlyLetters("abc-19cs"));

    }


    //chars range
    //65 - 90 A - Z
    //97 - 122 a - z
    boolean isChar(String s, int i) {
        int v = (int) s.charAt(i);

        if ((v >= 65 && v <= 90) || (v >= 97 && v <= 122))
            return true;

        return false;
    }




    public String reverseOnlyLetters(String S) {

        int i = 0, j = S.length() - 1;
        char[] res = S.toCharArray();
        while (i < j) {

            //if current elem at i is not char, increase index i, don't continue in the loop
            if(!isChar(S, i)) {
                i++;
                continue;
            }

            //if current elem at j is not char, increase index j, don't continue in the loop
            if(!isChar(S, j)){
                j--;
                continue;
            }

            //otherwise, if both of them are chars now it is time to swap both and move indices
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;

            //don't forget to update indices
            i++;
            j--;

        }

        return String.valueOf(res);
    }

    @Test
    public void TestIsChar() {

        Assert.assertTrue(isChar("ab", 0));
        Assert.assertTrue(isChar("z", 0));
        Assert.assertTrue(isChar("A", 0));
        Assert.assertTrue(isChar("Z", 0));
    }

    @Test
    public void TestReverseOnlyLetters() {
        Assert.assertEquals("", reverseOnlyLetters(""));
        Assert.assertEquals("d1c1ba", reverseOnlyLetters("a1b1cd"));
        Assert.assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
